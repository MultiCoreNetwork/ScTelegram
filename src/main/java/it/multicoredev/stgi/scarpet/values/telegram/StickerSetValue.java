package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.stickers.StickerSet;

import java.util.Arrays;

import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

import static java.util.stream.Collectors.toList;

public class StickerSetValue extends ScTelegramValue {
    public StickerSetValue(StickerSet stickerSet) {
        super(Arrays.asList(
                new StringValue("name"),           new StringValue(stickerSet.getName()),
                new StringValue("title"),          new StringValue(stickerSet.getTitle()),
                new StringValue("is_animated"),    new NumericValue(stickerSet.getIsAnimated()),
                new StringValue("contains_masks"), new NumericValue(stickerSet.getContainsMasks()),
                new StringValue("stickers"),       new ListValue(stickerSet.getStickers().stream().map(StickerValue::new).collect(toList())),
                new StringValue("thumb"),          NullableValue.photoSize(stickerSet.getThumb())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_sticker_set";
    }
}
