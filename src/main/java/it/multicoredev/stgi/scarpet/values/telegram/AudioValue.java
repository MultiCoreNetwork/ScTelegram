package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Audio;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;


public class AudioValue extends ScTelegramValue {
    public AudioValue(Audio audio) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(audio.getFileId()),
                new StringValue("file_unique_id"), new StringValue(audio.getFileUniqueId()),
                new StringValue("duration"),       new NumericValue(audio.getDuration()),
                new StringValue("performer"),      NullableValue.string(audio.getPerformer()),
                new StringValue("title"),          NullableValue.string(audio.getTitle()),
                new StringValue("file_name"),      NullableValue.string(audio.getFileName()),
                new StringValue("mime_type"),      NullableValue.string(audio.getMimeType()),
                new StringValue("file_size"),      NullableValue.numeric(audio.getFileSize()),
                new StringValue("thumb"),          NullableValue.photoSize(audio.getThumb())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_audio";
    }
}
