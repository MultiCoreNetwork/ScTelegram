package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class PreCheckoutQueryValue extends ScTelegramValue {
    public PreCheckoutQueryValue(PreCheckoutQuery preCheckoutQuery) {
        super(Arrays.asList(
                new StringValue("id"),                 new StringValue(preCheckoutQuery.getId()),
                new StringValue("from"),               new UserValue(preCheckoutQuery.getFrom()),
                new StringValue("currency"),           new StringValue(preCheckoutQuery.getCurrency()),
                new StringValue("total_amount"),       new NumericValue(preCheckoutQuery.getTotalAmount()),
                new StringValue("invoice_payload"),    new StringValue(preCheckoutQuery.getInvoicePayload()),
                new StringValue("shipping_option_id"), NullableValue.string(preCheckoutQuery.getShippingOptionId()),
                new StringValue("order_info"),         NullableValue.orderInfo(preCheckoutQuery.getOrderInfo())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_pre_checkout_query";
    }
}
