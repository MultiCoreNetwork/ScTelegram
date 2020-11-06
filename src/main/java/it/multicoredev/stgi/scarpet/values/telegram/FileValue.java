package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.File;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class FileValue extends ScTelegramValue {
    public FileValue(File file) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(file.getFileId()),
                new StringValue("file_unique_id"), new StringValue(file.getFileUniqueId()),
                new StringValue("file_size"),      NullableValue.numeric(file.getFileSize()),
                new StringValue("file_path"),      NullableValue.string(file.getFilePath())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_file";
    }
}
