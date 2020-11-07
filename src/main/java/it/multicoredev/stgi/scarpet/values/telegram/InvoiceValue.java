package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.payments.Invoice;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;

public class InvoiceValue extends ScTelegramValue {
    public InvoiceValue(Invoice invoice) {
        super(Arrays.asList(
                new StringValue("title"),           new StringValue(invoice.getTitle()),
                new StringValue("description"),     new StringValue(invoice.getDescription()),
                new StringValue("start_parameter"), new StringValue(invoice.getStartParameter()),
                new StringValue("currency"),        new StringValue(invoice.getCurrency()),
                new StringValue("total_amount"),    new NumericValue(invoice.getTotalAmount())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_invoice";
    }
}
