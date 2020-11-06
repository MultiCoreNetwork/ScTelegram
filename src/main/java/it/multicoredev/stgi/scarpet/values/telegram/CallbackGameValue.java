package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.games.CallbackGame;

import java.util.Arrays;

import carpet.script.value.MapValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class CallbackGameValue extends ScTelegramValue {
    public CallbackGameValue(CallbackGame callbackGame) {
        super(Arrays.asList());
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_callback_game";
    }
}
