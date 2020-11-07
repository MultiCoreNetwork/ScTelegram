package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InputFileValue extends ScTelegramValue {
    public InputFileValue(InputFile inputFile) {
        super(Arrays.asList(
                new StringValue("attach_name"), new StringValue(inputFile.getAttachName()),
                new StringValue("path"),        NullableValue.string(inputFile.getNewMediaFile().getPath())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_input_file";
    }
}
