package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.media.InputMediaDocument;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class InputMediaDocumentValue extends ScTelegramValue {
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
        return "sctelegram_input_media_document";
    }
}
