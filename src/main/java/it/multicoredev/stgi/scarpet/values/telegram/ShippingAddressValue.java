package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.ShippingAddress;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class ShippingAddressValue extends ScTelegramValue {
    public ShippingAddressValue(ShippingAddress shippingAddress) {
        super(Arrays.asList(
                new StringValue("country_code"), new StringValue(shippingAddress.getCountryCode()),
                new StringValue("state"),        new StringValue(shippingAddress.getState()),
                new StringValue("city"),         new StringValue(shippingAddress.getCity()),
                new StringValue("street_line1"), new StringValue(shippingAddress.getStreetLine1()),
                new StringValue("street_line2"), new StringValue(shippingAddress.getStreetLine2()),
                new StringValue("post_code"),    new StringValue(shippingAddress.getPostCode())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_shipping_address";
    }
}
