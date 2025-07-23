package com.shophub.PaymentService.services;

import com.shophub.PaymentService.adapters.paymentgatewayadapters.PaymentGatewayAdapter;
import com.shophub.PaymentService.adapters.paymentgatewayadapters.PaymentGatewayStrategy;
import com.shophub.PaymentService.exceptions.InvalidPaymentLinkCreationException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGatewayStrategy paymentGatewayStrategy;
    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy){
        this.paymentGatewayStrategy=paymentGatewayStrategy;
    }

    public String createPaymentLink(Long orderId){
        //1. Get the order details from order service
        // restTemplate.getForDetails("https://orderservice/orders/orderId");
        Long price=123L;
        //2. Get payment Gateway based upon a strategy
        PaymentGatewayAdapter paymentGatewayAdapter= paymentGatewayStrategy.getPaymentGateway();

        //3. Call the payment Gateway to create payment link
        String url="";
        try{
            url=paymentGatewayAdapter.createPaymentLink(price);
        }catch (Exception e){
            e.printStackTrace();
            //throw new InvalidPaymentLinkCreationException("Exception while creating payment link");
        }
        //4 return payment link
        return url;
    }
}
