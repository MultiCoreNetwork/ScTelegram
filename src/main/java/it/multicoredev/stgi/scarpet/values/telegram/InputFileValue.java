package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

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
        return "sctelegram_input_file";
    }
}
