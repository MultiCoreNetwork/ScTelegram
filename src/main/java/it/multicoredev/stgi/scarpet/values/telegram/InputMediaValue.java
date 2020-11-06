package it.multicoredev.stgi.scarpet.values.telegram;

import java.util.List;

import carpet.script.value.Value;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class InputMediaValue extends ScTelegramValue {
    public InputMediaValue(List<Value> values) {
        super(values);
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_input_media";
    }
}
