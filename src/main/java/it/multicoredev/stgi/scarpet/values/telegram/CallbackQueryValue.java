package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;


public class CallbackQueryValue extends ScTelegramValue {
    public CallbackQueryValue(CallbackQuery callbackQuery) {
        super(Arrays.asList(
                new StringValue("id"),                new StringValue(callbackQuery.getId()),
                new StringValue("from"),              new UserValue(callbackQuery.getFrom()),
                new StringValue("message"),           NullableValue.message(callbackQuery.getMessage()),
                new StringValue("inline_message_id"), NullableValue.string(callbackQuery.getInlineMessageId()),
                new StringValue("chat_instance"),     new StringValue(callbackQuery.getChatInstance()),
                new StringValue("data"),              NullableValue.string(callbackQuery.getData()),
                new StringValue("game_short_name"),   NullableValue.string(callbackQuery.getGameShortName())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_callback_query";
    }
}
