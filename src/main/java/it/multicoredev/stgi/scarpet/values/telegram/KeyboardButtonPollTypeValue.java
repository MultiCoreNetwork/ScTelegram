package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class KeyboardButtonPollTypeValue extends ScTelegramValue {
    public KeyboardButtonPollTypeValue(KeyboardButtonPollType keyboardButton) {
        super(Arrays.asList(
                new StringValue("type"), new StringValue(keyboardButton.getType())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_keyboard_button_type";
    }
}
