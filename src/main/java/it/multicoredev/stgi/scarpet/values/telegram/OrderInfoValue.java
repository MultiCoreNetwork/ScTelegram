package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class OrderInfoValue extends ScTelegramValue {
    public OrderInfoValue(OrderInfo orderInfo) {
        super(Arrays.asList(
                new StringValue("name"),             NullableValue.string(orderInfo.getName()),
                new StringValue("phone_number"),     NullableValue.string(orderInfo.getPhoneNumber()),
                new StringValue("email"),            NullableValue.string(orderInfo.getEmail()),
                new StringValue("shipping_address"), NullableValue.shippingAddress(orderInfo.getShippingAddress())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_order_info";
    }
}
