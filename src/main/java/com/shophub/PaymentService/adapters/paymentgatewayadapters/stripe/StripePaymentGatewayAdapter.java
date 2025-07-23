package com.shophub.PaymentService.adapters.paymentgatewayadapters.stripe;

import com.shophub.PaymentService.adapters.paymentgatewayadapters.PaymentGatewayAdapter;
import com.shophub.PaymentService.exceptions.InvalidPaymentLinkCreationException;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {

    private StripeClient stripeClient;
    public StripePaymentGatewayAdapter(StripeClient stripeClient){
        this.stripeClient=stripeClient;
    }

    @Override
    public String createPaymentLink(Long productPrice) throws Exception {

        //Product Object
            ProductCreateParams productParams =
                    ProductCreateParams.builder()
                            .setDescription("(created by Stripe Shell)")
                            .setName("scaler course ")
                            .setActive(true)
                            .setDefaultPriceData(
                                    ProductCreateParams.DefaultPriceData.builder()
                                            .setCurrency("inr")
                                            .setUnitAmount(99999L)
                                            .build()
                            )
                            .build();

            Product product = Product.create(productParams);

            //Price Object
            PriceCreateParams priceParams =
                    PriceCreateParams.builder()
                            .setCurrency("inr")
                            .setProduct(product.getId())
                            .setUnitAmount(99999L)
                            .build();

            Price price = Price.create(priceParams);

        //Payment Link
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .setCurrency("inr")
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(
                                PaymentLinkCreateParams.AfterCompletion.builder()
                                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                        .setRedirect(
                                                PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                        .setUrl("https://scaler.com/")
                                                        .build()
                                        )
                                        .build()
                        )
                        .setInvoiceCreation(
                                PaymentLinkCreateParams.InvoiceCreation.builder().setEnabled(true).build()
                        )
                        .setPhoneNumberCollection(
                                PaymentLinkCreateParams.PhoneNumberCollection.builder().setEnabled(false).build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();
    }
}
