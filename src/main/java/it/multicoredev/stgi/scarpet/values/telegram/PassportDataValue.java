package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.passport.PassportData;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.StringValue;

import static java.util.stream.Collectors.toList;

public class PassportDataValue extends ScTelegramValue {
    public PassportDataValue(PassportData passportData) {
        super(Arrays.asList(
                new StringValue("data"),        new ListValue(passportData.getData().stream().map(EncryptedPassportElementValue::new).collect(toList())),
                new StringValue("credentials"), new EncryptedCredentialsValue(passportData.getCredentials())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_passport_data";
    }
}
