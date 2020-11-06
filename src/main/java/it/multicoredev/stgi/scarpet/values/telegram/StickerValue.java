package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class StickerValue extends ScTelegramValue {
    public StickerValue(Sticker sticker) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(sticker.getFileId()),
                new StringValue("file_unique_id"), new StringValue(sticker.getFileUniqueId()),
                new StringValue("width"),          new NumericValue(sticker.getWidth()),
                new StringValue("height"),         new NumericValue(sticker.getHeight()),
                new StringValue("is_animated"),    new NumericValue(sticker.getIsAnimated()),
                new StringValue("thumb"),          NullableValue.photoSize(sticker.getThumb()),
                new StringValue("emoji"),          NullableValue.string(sticker.getEmoji()),
                new StringValue("set_name"),       NullableValue.string(sticker.getSetName()),
                new StringValue("mask_position"),  NullableValue.maskPosition(sticker.getMaskPosition()),
                new StringValue("file_size"),      NullableValue.numeric(sticker.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_sticker";
    }
}
