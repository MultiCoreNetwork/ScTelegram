package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.passport.PassportFile;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;

public class PassportFileValue extends ScTelegramValue {
    public PassportFileValue(PassportFile passportFile) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(passportFile.getFileId()),
                new StringValue("file_unique_id"), new StringValue(passportFile.getFileUniqueId()),
                new StringValue("file_size"),      new NumericValue(passportFile.getFileSize()),
                new StringValue("file_date"),      new NumericValue(passportFile.getFileDate())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_passport_file";
    }
}
