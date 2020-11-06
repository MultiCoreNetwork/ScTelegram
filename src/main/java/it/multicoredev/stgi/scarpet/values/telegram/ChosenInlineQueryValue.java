package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

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
        return "sctelegram_chosen_inline_query";
    }
}