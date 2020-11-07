package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.passport.EncryptedCredentials;

import java.util.Arrays;

import carpet.script.value.StringValue;

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
        return "telegram_encrypted_credentials";
    }
}
