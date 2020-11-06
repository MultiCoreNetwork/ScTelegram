package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Voice;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class VoiceValue extends ScTelegramValue {
    public VoiceValue(Voice voice) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(voice.getFileId()),
                new StringValue("file_unique_id"), new StringValue(voice.getFileUniqueId()),
                new StringValue("duration"),       new NumericValue(voice.getDuration()),
                new StringValue("mime_type"),      NullableValue.string(voice.getMimeType()),
                new StringValue("file_size"),      NullableValue.numeric(voice.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_audio";
    }
}
