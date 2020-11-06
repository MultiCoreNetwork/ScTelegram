package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.Arrays;

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
        return "sctelegram_keyboard_button";
    }
}
