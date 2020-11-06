package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ReplyKeyboardRemoveValue extends ScTelegramValue {
    public ReplyKeyboardRemoveValue(ReplyKeyboardRemove replyKeyboardRemove) {
        super(Arrays.asList(
                new StringValue("remove_keyboard"), new NumericValue(replyKeyboardRemove.getRemoveKeyboard()),
                new StringValue("selective"),       NullableValue.numeric(replyKeyboardRemove.getSelective())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_reply_keyboard_remove";
    }
}
