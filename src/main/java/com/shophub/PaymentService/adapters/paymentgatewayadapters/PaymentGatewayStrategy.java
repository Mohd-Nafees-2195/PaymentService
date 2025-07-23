package com.shophub.PaymentService.adapters.paymentgatewayadapters;

import com.shophub.PaymentService.adapters.paymentgatewayadapters.stripe.StripePaymentGatewayAdapter;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentGatewayStrategy {
//    private static Random random=new Random();
    private final StripePaymentGatewayAdapter stripePaymentGatewayAdapter;

    public PaymentGatewayStrategy(StripePaymentGatewayAdapter stripePaymentGatewayAdapter){
        this.stripePaymentGatewayAdapter=stripePaymentGatewayAdapter;
    }

    public PaymentGatewayAdapter getPaymentGateway( ){

        return stripePaymentGatewayAdapter;

//        int isEven=random.nextInt(100);
//        if(isEven%2==0){
//            return new RazorpayPaymentGatewatAdapter();
//        }else {
//            return new StripePaymentGatewayAdapter();
//        }
    }
}
