package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.games.Animation;
import org.telegram.telegrambots.meta.api.objects.payments.OrderInfo;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;


public class AnimationValue extends ScTelegramValue {
    public AnimationValue(Animation animationValue) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(animationValue.getFileId()),
                new StringValue("file_unique_id"), new StringValue(animationValue.getFileUniqueId()),
                new StringValue("width"),          new NumericValue(animationValue.getWidth()),
                new StringValue("height"),         new NumericValue(animationValue.getHeight()),
                new StringValue("duration"),       new NumericValue(animationValue.getDuration()),
                new StringValue("thumb"),          NullableValue.photoSize(animationValue.getThumb()),
                new StringValue("file_name"),      NullableValue.string(animationValue.getFileName()),
                new StringValue("mime_type"),      NullableValue.string(animationValue.getMimetype()),
                new StringValue("file_size"),      NullableValue.numeric(animationValue.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_animation";
    }
}
