package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaAudio;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class InputMediaAudioValue extends ScTelegramValue {
    public InputMediaAudioValue(InputMediaAudio inputMediaAudio) {
        super(Arrays.asList(
                new StringValue("type"),             new StringValue(inputMediaAudio.getType()),
                new StringValue("media"),            new StringValue(inputMediaAudio.getMedia()),
                new StringValue("thumb"),            NullableValue.inputFile(inputMediaAudio.getThumb()),
                new StringValue("caption"),          NullableValue.string(inputMediaAudio.getCaption()),
                new StringValue("parse_mode"),       NullableValue.string(inputMediaAudio.getParseMode()),
                new StringValue("caption_entities"), NullableValue.messageEntitylist(inputMediaAudio.getEntities()),
                new StringValue("duration"),         NullableValue.numeric(inputMediaAudio.getDuration()),
                new StringValue("performer"),        NullableValue.string(inputMediaAudio.getPerformer()),
                new StringValue("title"),            NullableValue.string(inputMediaAudio.getTitle())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_input_media_audio";
    }
}
