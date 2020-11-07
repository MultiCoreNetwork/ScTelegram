package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaAnimation;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InputMediaAnimationValue extends ScTelegramValue {
    public InputMediaAnimationValue(InputMediaAnimation inputMediaAnimation) {
        super(Arrays.asList(
                new StringValue("type"),             new StringValue(inputMediaAnimation.getType()),
                new StringValue("media"),            new StringValue(inputMediaAnimation.getMedia()),
                new StringValue("thumb"),            NullableValue.inputFile(inputMediaAnimation.getThumb()),
                new StringValue("caption"),          NullableValue.string(inputMediaAnimation.getCaption()),
                new StringValue("parse_mode"),       NullableValue.string(inputMediaAnimation.getParseMode()),
                new StringValue("caption_entities"), NullableValue.messageEntitylist(inputMediaAnimation.getEntities()),
                new StringValue("width"),            NullableValue.numeric(inputMediaAnimation.getWidth()),
                new StringValue("height"),           NullableValue.numeric(inputMediaAnimation.getHeight()),
                new StringValue("duration"),         NullableValue.numeric(inputMediaAnimation.getDuration())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_input_media_animation";
    }
}
