package com.shophub.PaymentService.controllers;

import com.shophub.PaymentService.dtos.CreatePaymentLinkRequestDto;
import com.shophub.PaymentService.dtos.CreatePaymentLinkResponseDto;
import com.shophub.PaymentService.services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping
    public CreatePaymentLinkResponseDto createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request){
        CreatePaymentLinkResponseDto response=new CreatePaymentLinkResponseDto();
        response.setUrl(paymentService.createPaymentLink(request.getOrderId()));
        return response;
    }
    @GetMapping
    public String test(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@####################################**********************************************************************");
        return "Success";
    }
}
