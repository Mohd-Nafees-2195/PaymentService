package com.shophub.PaymentService.adapters.paymentgatewayadapters;

public interface PaymentGatewayAdapter {
    String createPaymentLink(Long price) throws Exception;
}
