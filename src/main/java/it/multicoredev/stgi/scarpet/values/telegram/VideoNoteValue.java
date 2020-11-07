package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.VideoNote;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class VideoNoteValue extends ScTelegramValue {
    public VideoNoteValue(VideoNote videoNote) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(videoNote.getFileId()),
                new StringValue("file_unique_id"), new StringValue(videoNote.getFileUniqueId()),
                new StringValue("length"),         new NumericValue(videoNote.getLength()),
                new StringValue("duration"),       new NumericValue(videoNote.getDuration()),
                new StringValue("thumb"),          NullableValue.photoSize(videoNote.getThumb()),
                new StringValue("file_size"),      NullableValue.numeric(videoNote.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_video_note";
    }
}
