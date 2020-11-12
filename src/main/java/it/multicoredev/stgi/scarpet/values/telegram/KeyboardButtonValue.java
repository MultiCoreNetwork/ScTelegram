package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class KeyboardButtonValue extends ScTelegramValue {
    public KeyboardButtonValue(KeyboardButton keyboardButton) {
        super(Arrays.asList(
                new StringValue("text"),             new StringValue(keyboardButton.getText()),
                new StringValue("request_contact"),  NullableValue.numeric(keyboardButton.getRequestContact()),
                new StringValue("request_location"), NullableValue.numeric(keyboardButton.getRequestLocation()),
                new StringValue("request_poll"),     NullableValue.keyboardButtonPollType(keyboardButton.getRequestPoll())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_keyboard_button";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "request_contact",
            "request_location"
    );
}
