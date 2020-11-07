package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.passport.EncryptedPassportElement;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class EncryptedPassportElementValue extends ScTelegramValue {
    public EncryptedPassportElementValue(EncryptedPassportElement encryptedPassportElement) {
        super(Arrays.asList(
                new StringValue("type"),         new StringValue(encryptedPassportElement.getType()),
                new StringValue("data"),         NullableValue.string(encryptedPassportElement.getData()),
                new StringValue("phone_number"), NullableValue.string(encryptedPassportElement.getPhoneNumber()),
                new StringValue("email"),        NullableValue.string(encryptedPassportElement.getEmail()),
                new StringValue("files"),        NullableValue.passportFileList(encryptedPassportElement.getFiles()),
                new StringValue("front_side"),   NullableValue.passportFile(encryptedPassportElement.getFrontSide()),
                new StringValue("reverse_side"), NullableValue.passportFile(encryptedPassportElement.getReverseSide()),
                new StringValue("selfie"),       NullableValue.passportFile(encryptedPassportElement.getSelfie()),
                new StringValue("translation"),  NullableValue.passportFileList(encryptedPassportElement.getTranslations()),
                new StringValue("hash"),         new StringValue(encryptedPassportElement.getHash())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_encrypted_passport_element";
    }
}
