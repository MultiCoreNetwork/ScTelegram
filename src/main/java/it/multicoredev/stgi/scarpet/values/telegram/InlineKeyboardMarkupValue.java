package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.StringValue;

import static java.util.stream.Collectors.toList;


public class InlineKeyboardMarkupValue extends ReplyKeyboardValue {
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
        return "telegram_inline_keyboard_markup";
    }
}
