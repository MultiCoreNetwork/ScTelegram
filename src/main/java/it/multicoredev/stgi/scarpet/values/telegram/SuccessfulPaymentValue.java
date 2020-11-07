package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.SuccessfulPayment;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class SuccessfulPaymentValue extends ScTelegramValue {
    public SuccessfulPaymentValue(SuccessfulPayment successfulPayment) {
        super(Arrays.asList(
                new StringValue("currency"),                   new StringValue(successfulPayment.getCurrency()),
                new StringValue("total_amount"),               new NumericValue(successfulPayment.getTotalAmount()),
                new StringValue("invoice_payload"),            new StringValue(successfulPayment.getInvoicePayload()),
                new StringValue("shipping_option_id"),         NullableValue.string(successfulPayment.getShippingOptionId()),
                new StringValue("order_info"),                 NullableValue.orderInfo(successfulPayment.getOrderInfo()),
                new StringValue("telegram_payment_charge_id"), NullableValue.string(successfulPayment.getTelegramPaymentChargeId()),
                new StringValue("telegram_payment_charge_id"), NullableValue.string(successfulPayment.getProviderPaymentChargeId())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_successful_payment";
    }
}
