package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaVideo;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class InputMediaVideoValue extends ScTelegramValue {
    public InputMediaVideoValue(InputMediaVideo inputMediaVideo) {
        super(Arrays.asList(
                new StringValue("type"),               new StringValue(inputMediaVideo.getType()),
                new StringValue("media"),              new StringValue(inputMediaVideo.getMedia()),
                new StringValue("thumb"),              NullableValue.inputFile(inputMediaVideo.getThumb()),
                new StringValue("caption"),            NullableValue.string(inputMediaVideo.getCaption()),
                new StringValue("parse_mode"),         NullableValue.string(inputMediaVideo.getParseMode()),
                new StringValue("caption_entities"),   NullableValue.messageEntitylist(inputMediaVideo.getEntities()),
                new StringValue("width"),              NullableValue.numeric(inputMediaVideo.getWidth()),
                new StringValue("height"),             NullableValue.numeric(inputMediaVideo.getHeight()),
                new StringValue("duration"),           NullableValue.numeric(inputMediaVideo.getDuration()),
                new StringValue("supports_streaming"), NullableValue.numeric(inputMediaVideo.getSupportsStreaming())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_input_media_video";
    }
}
