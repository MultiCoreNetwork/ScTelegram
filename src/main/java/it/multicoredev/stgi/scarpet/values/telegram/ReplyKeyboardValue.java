package it.multicoredev.stgi.scarpet.values.telegram;

import java.util.List;

import carpet.script.value.Value;


public class ReplyKeyboardValue extends ScTelegramValue {
    public ReplyKeyboardValue(List<Value> values) {
        super(values);
    }

    @Override
    public String getTypeString()
    {
        return "telegram_reply_keyboard";
    }
}
