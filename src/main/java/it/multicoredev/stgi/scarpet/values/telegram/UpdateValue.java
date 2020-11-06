package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class UpdateValue extends ScTelegramValue {
    public UpdateValue(Update update) {
        super(Arrays.asList(
                new StringValue("id"),                   new NumericValue(update.getUpdateId()),
                new StringValue("message"),              NullableValue.message(update.getMessage()),
                new StringValue("edited_message"),       NullableValue.message(update.getEditedMessage()),
                new StringValue("channel_post"),         NullableValue.message(update.getChannelPost()),
                new StringValue("edited_channel_post"),  NullableValue.message(update.getEditedChannelPost()),
                new StringValue("inline_query"),         NullableValue.inlineQuery(update.getInlineQuery()),
                new StringValue("chosen_inline_result"), NullableValue.chosenInlineQuery(update.getChosenInlineQuery()),
                new StringValue("callback_query"),       NullableValue.callbackQuery(update.getCallbackQuery()),
                new StringValue("shipping_query"),       NullableValue.shippingQuery(update.getShippingQuery()),
                new StringValue("pre_checkout_query"),   NullableValue.preCheckoutQuery(update.getPreCheckoutQuery()),
                new StringValue("poll"),                 NullableValue.poll(update.getPoll()),
                new StringValue("poll_answer"),          NullableValue.pollAnswer(update.getPollAnswer())
        ));
    }

    @Override
    public String getTypeString() {
        return "sctelegram_update";
    }
}
