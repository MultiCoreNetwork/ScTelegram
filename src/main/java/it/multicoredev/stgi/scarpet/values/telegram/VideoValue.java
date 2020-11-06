package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Video;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class VideoValue extends ScTelegramValue {
    public VideoValue(Video video) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(video.getFileId()),
                new StringValue("file_unique_id"), new StringValue(video.getFileUniqueId()),
                new StringValue("width"),          new NumericValue(video.getWidth()),
                new StringValue("height"),         new NumericValue(video.getHeight()),
                new StringValue("duration"),       new NumericValue(video.getDuration()),
                new StringValue("thumb"),          NullableValue.photoSize(video.getThumb()),
                new StringValue("file_name"),      NullableValue.string(video.getFileName()),
                new StringValue("mime_type"),      NullableValue.string(video.getMimeType()),
                new StringValue("file_size"),      NullableValue.numeric(video.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_video";
    }
}
