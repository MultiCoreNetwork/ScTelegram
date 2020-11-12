package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InlineKeyboardButtonValue extends ScTelegramValue {
    public InlineKeyboardButtonValue(InlineKeyboardButton inlineKeyboardButton) {
        super(Arrays.asList(
                new StringValue("text"),                             new StringValue(inlineKeyboardButton.getText()),
                new StringValue("url"),                              NullableValue.string(inlineKeyboardButton.getUrl()),
                new StringValue("login_url"),                        NullableValue.loginUrl(inlineKeyboardButton.getLoginUrl()),
                new StringValue("callback_data"),                    NullableValue.string(inlineKeyboardButton.getCallbackData()),
                new StringValue("switch_inline_query"),              NullableValue.string(inlineKeyboardButton.getSwitchInlineQuery()),
                new StringValue("switch_inline_query_current_chat"), NullableValue.string(inlineKeyboardButton.getSwitchInlineQueryCurrentChat()),
                new StringValue("callback_game"),                    NullableValue.callbackGame(inlineKeyboardButton.getCallbackGame()),
                new StringValue("pay"),                              new NumericValue(inlineKeyboardButton.getPay())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_inline_keyboard_button";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "pay"
    );
}
