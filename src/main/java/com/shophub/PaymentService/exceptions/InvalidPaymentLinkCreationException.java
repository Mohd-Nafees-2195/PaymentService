package com.shophub.PaymentService.exceptions;

public class InvalidPaymentLinkCreationException extends RuntimeException {
    public InvalidPaymentLinkCreationException(String message){
        super(message);
    }
}
