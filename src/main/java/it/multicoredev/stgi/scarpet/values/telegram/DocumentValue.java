package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Document;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class DocumentValue extends ScTelegramValue {
    public DocumentValue(Document document) {
        super(Arrays.asList(
                new StringValue("file_id"),        new StringValue(document.getFileId()),
                new StringValue("file_unique_id"), new StringValue(document.getFileUniqueId()),
                new StringValue("thumb"),          NullableValue.photoSize(document.getThumb()),
                new StringValue("file_name"),      NullableValue.string(document.getFileName()),
                new StringValue("mime_type"),      NullableValue.string(document.getMimeType()),
                new StringValue("file_size"),      NullableValue.numeric(document.getFileSize())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_document";
    }
}
