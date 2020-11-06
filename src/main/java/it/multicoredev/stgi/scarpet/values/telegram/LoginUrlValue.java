package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.LoginUrl;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class LoginUrlValue extends ScTelegramValue {
    public LoginUrlValue(LoginUrl loginUrl) {
        super(Arrays.asList(
                new StringValue("url"),                  new StringValue(loginUrl.getUrl()),
                new StringValue("forward_text"),         NullableValue.string(loginUrl.getForwardText()),
                new StringValue("bot_username"),         NullableValue.string(loginUrl.getBotUsername()),
                new StringValue("request_write_access"), NullableValue.numeric(loginUrl.getRequestWriteAccess())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_login_url";
    }
}
