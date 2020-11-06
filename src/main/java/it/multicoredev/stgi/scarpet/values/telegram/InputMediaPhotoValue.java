package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class InputMediaPhotoValue extends ScTelegramValue {
    public InputMediaPhotoValue(InputMediaPhoto inputMediaPhoto) {
        super(Arrays.asList(
                new StringValue("type"),             new StringValue(inputMediaPhoto.getType()),
                new StringValue("media"),            new StringValue(inputMediaPhoto.getMedia()),
                new StringValue("caption"),          NullableValue.string(inputMediaPhoto.getCaption()),
                new StringValue("parse_mode"),       NullableValue.string(inputMediaPhoto.getParseMode()),
                new StringValue("caption_entities"), NullableValue.messageEntitylist(inputMediaPhoto.getEntities())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_input_media_photo";
    }
}
