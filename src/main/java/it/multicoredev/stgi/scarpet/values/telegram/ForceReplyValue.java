package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ForceReplyValue extends ReplyKeyboardValue {
    public ForceReplyValue(ForceReplyKeyboard forceReplyKeyboard) {
        super(Arrays.asList(
                new StringValue("force_reply"), new NumericValue(forceReplyKeyboard.getForceReply()),
                new StringValue("selective"),   NullableValue.numeric(forceReplyKeyboard.getSelective())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_force_reply";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "force_reply",
            "selective"
    );
}
