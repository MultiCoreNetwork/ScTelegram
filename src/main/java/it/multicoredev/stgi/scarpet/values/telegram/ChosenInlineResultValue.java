package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ChosenInlineResultValue extends ScTelegramValue {
    public ChosenInlineResultValue(ChosenInlineQuery chosenInlineQuery) {
        super(Arrays.asList(
                new StringValue("result_id"),         new StringValue(chosenInlineQuery.getResultId()),
                new StringValue("from"),              new UserValue(chosenInlineQuery.getFrom()),
                new StringValue("location"),          NullableValue.location(chosenInlineQuery.getLocation()),
                new StringValue("inline_message_id"), NullableValue.string(chosenInlineQuery.getInlineMessageId()),
                new StringValue("query"),             new StringValue(chosenInlineQuery.getQuery())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_chosen_inline_result";
    }
}
