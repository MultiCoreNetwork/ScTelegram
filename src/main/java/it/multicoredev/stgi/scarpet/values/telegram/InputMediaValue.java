package it.multicoredev.stgi.scarpet.values.telegram;

import java.util.List;

import carpet.script.value.Value;

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
