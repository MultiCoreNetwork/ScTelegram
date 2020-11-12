package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ChosenInlineQueryValue extends ScTelegramValue {
    public ChosenInlineQueryValue(ChosenInlineQuery inlineQuery) {
        super(Arrays.asList(
                new StringValue("id"),                new StringValue(inlineQuery.getResultId()),
                new StringValue("from"),              new UserValue(inlineQuery.getFrom()),
                new StringValue("location"),          NullableValue.location(inlineQuery.getLocation()),
                new StringValue("inline_message_id"), NullableValue.string(inlineQuery.getInlineMessageId()),
                new StringValue("query"),             new StringValue(inlineQuery.getQuery())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_chosen_inline_query";
    }
}
