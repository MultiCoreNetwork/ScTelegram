package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

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
        return "telegram_input_media_photo";
    }
}
