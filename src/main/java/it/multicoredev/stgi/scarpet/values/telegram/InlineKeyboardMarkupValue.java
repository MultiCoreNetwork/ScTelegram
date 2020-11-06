package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Dice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

import static java.util.stream.Collectors.toList;


public class InlineKeyboardMarkupValue extends ScTelegramValue {
    public InlineKeyboardMarkupValue(InlineKeyboardMarkup inlineKeyboardMarkup) {
        super(Arrays.asList(
                new StringValue("emoji"), new ListValue(
                        inlineKeyboardMarkup.getKeyboard().stream().map(
                                i -> new ListValue(i.stream().map(InlineKeyboardButtonValue::new).collect(toList()))
                        ).collect(toList()))
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_inline_keyboard_markup";
    }
}