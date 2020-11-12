package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaVideo;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InputMediaVideoValue extends InputMediaValue {
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
        return "telegram_input_media_video";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "supports_streaming"
    );
}
