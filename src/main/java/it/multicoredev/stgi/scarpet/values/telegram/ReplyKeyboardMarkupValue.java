package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.ListValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

import static java.util.stream.Collectors.toList;


public class ReplyKeyboardMarkupValue extends ReplyKeyboardValue {
    public ReplyKeyboardMarkupValue(ReplyKeyboardMarkup replyKeyboardMarkup) {
        super(Arrays.asList(
                new StringValue("keyboard"), new ListValue(
                        replyKeyboardMarkup.getKeyboard().stream().map(
                                i -> new ListValue(i.stream().map(KeyboardButtonValue::new).collect(toList()))
                        ).collect(toList())),
                new StringValue("resize_keyboard"),   NullableValue.numeric(replyKeyboardMarkup.getResizeKeyboard()),
                new StringValue("one_time_keyboard"), NullableValue.numeric(replyKeyboardMarkup.getOneTimeKeyboard()),
                new StringValue("selective"),         NullableValue.numeric(replyKeyboardMarkup.getSelective())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_reply_keyboard_markup";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "resize_keyboard",
            "one_time_keyboard",
            "selective"
    );
}
