package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class ShippingQueryValue extends ScTelegramValue {
    public ShippingQueryValue(ShippingQuery shippingQuery) {
        super(Arrays.asList(
                new StringValue("id"),               new StringValue(shippingQuery.getId()),
                new StringValue("from"),             new UserValue(shippingQuery.getFrom()),
                new StringValue("invoice_payload"),  new StringValue(shippingQuery.getInvoicePayload()),
                new StringValue("shipping_address"), new ShippingAddressValue(shippingQuery.getShippingAddress())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_shipping_query";
    }
}