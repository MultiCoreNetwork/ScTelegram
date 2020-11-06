package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ResponseParameters;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ResponseParametersValue extends ScTelegramValue {
    public ResponseParametersValue(ResponseParameters responseParameters) {
        super(Arrays.asList(
                new StringValue("migrate_to_chat_id"), NullableValue.numeric(responseParameters.getMigrateToChatId()),
                new StringValue("retry_after"),        NullableValue.numeric(responseParameters.getRetryAfter())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_response_parameters";
    }
}
