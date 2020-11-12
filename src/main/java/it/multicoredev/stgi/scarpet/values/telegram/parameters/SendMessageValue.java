package it.multicoredev.stgi.scarpet.values.telegram.parameters;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.telegram.MessageEntityValue;
import it.multicoredev.stgi.scarpet.values.telegram.ReplyKeyboardValue;

public class SendMessageValue extends ScTelegramParametersValue {
    @Override
    public List<ScTelegramParameter> getParametersList() {
        return Arrays.asList(
                new ScTelegramParameter("chat_id", StringValue.class),
                new ScTelegramParameter("text", StringValue.class),
                new ScTelegramParameter("parse_mode", StringValue.class).optional(),
                new ScTelegramParameter("entities", MessageEntityValue.class).optional().list(),
                new ScTelegramParameter("disable_web_page_preview", NumericValue.class).optional().bool(),
                new ScTelegramParameter("disable_notification", NumericValue.class).optional().bool(),
                new ScTelegramParameter("reply_to_message_id", NumericValue.class).optional(),
                new ScTelegramParameter("allow_sending_without_reply", NumericValue.class).optional().bool(),
                new ScTelegramParameter("reply_markup", ReplyKeyboardValue.class).optional()
        );
    }
}
