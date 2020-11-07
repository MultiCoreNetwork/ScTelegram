package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InlineQueryValue extends ScTelegramValue {
    public InlineQueryValue(InlineQuery inlineQuery) {
        super(Arrays.asList(
                new StringValue("id"),       new StringValue(inlineQuery.getId()),
                new StringValue("from"),     new UserValue(inlineQuery.getFrom()),
                new StringValue("location"), NullableValue.location(inlineQuery.getLocation()),
                new StringValue("query"),    new StringValue(inlineQuery.getQuery()),
                new StringValue("offset"),   new StringValue(inlineQuery.getOffset())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_inline_query";
    }
}
