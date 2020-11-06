package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ForceReplyValue extends ScTelegramValue {
    public ForceReplyValue(ForceReplyKeyboard forceReplyKeyboard) {
        super(Arrays.asList(
                new StringValue("force_reply"), new NumericValue(forceReplyKeyboard.getForceReply()),
                new StringValue("selective"),   NullableValue.numeric(forceReplyKeyboard.getSelective())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_force_reply";
    }
}
