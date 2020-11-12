package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaDocument;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class InputMediaDocumentValue extends InputMediaValue {
    public InputMediaDocumentValue(InputMediaDocument inputMediaDocument) {
        super(Arrays.asList(
                new StringValue("type"),                           new StringValue(inputMediaDocument.getType()),
                new StringValue("media"),                          new StringValue(inputMediaDocument.getMedia()),
                new StringValue("thumb"),                          NullableValue.inputFile(inputMediaDocument.getThumb()),
                new StringValue("caption"),                        NullableValue.string(inputMediaDocument.getCaption()),
                new StringValue("parse_mode"),                     NullableValue.string(inputMediaDocument.getParseMode()),
                new StringValue("caption_entities"),               NullableValue.messageEntitylist(inputMediaDocument.getEntities()),
                new StringValue("disable_content_type_detection"), NullableValue.numeric(inputMediaDocument.getDisableContentTypeDetection())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_input_media_document";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "disable_content_type_detection"
    );
}
