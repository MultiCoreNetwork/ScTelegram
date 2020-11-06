package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.games.Animation;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class PhotoSizeValue extends ScTelegramValue {
    public PhotoSizeValue(PhotoSize photoSize) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(photoSize.getFileId()),
                new StringValue("file_unique_id"), new StringValue(photoSize.getFileUniqueId()),
                new StringValue("width"),          new NumericValue(photoSize.getWidth()),
                new StringValue("height"),         new NumericValue(photoSize.getHeight()),
                new StringValue("file_size"),      NullableValue.numeric(photoSize.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_photo_size";
    }
}
