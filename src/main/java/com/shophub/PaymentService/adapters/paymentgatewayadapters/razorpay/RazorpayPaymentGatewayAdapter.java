package com.shophub.PaymentService.adapters.paymentgatewayadapters.razorpay;

import com.shophub.PaymentService.adapters.paymentgatewayadapters.PaymentGatewayAdapter;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGatewayAdapter implements PaymentGatewayAdapter {
    @Override
    public String createPaymentLink(Long price) {
        return "";
    }
}
