package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.passport.EncryptedCredentials;
import org.telegram.telegrambots.meta.api.objects.passport.PassportData;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

import static java.util.stream.Collectors.toList;

public class EncryptedCredentialsValue extends ScTelegramValue {
    public EncryptedCredentialsValue(EncryptedCredentials encryptedCredentials) {
        super(Arrays.asList(
                new StringValue("data"),   new StringValue(encryptedCredentials.getData()),
                new StringValue("hash"),   new StringValue(encryptedCredentials.getHash()),
                new StringValue("secret"), new StringValue(encryptedCredentials.getSecret())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_encrypted_credentials";
    }
}
