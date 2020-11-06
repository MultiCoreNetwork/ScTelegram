package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.Arrays;

import carpet.script.value.MapValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;

public class MessageEntityValue extends ScTelegramValue {
    public MessageEntityValue(MessageEntity messageEntity) {
        super(Arrays.asList(
                new StringValue("type"),     new StringValue(messageEntity.getText()),
                new StringValue("offset"),   new NumericValue(messageEntity.getOffset()),
                new StringValue("length"),   new NumericValue(messageEntity.getLength()),
                new StringValue("url"),      NullableValue.string(messageEntity.getUrl()),
                new StringValue("user"),     NullableValue.user(messageEntity.getUser()),
                new StringValue("language"), NullableValue.string(messageEntity.getLanguage())
        ));
    }

    @Override
    public String getTypeString() {
        return "sctelegram_message_entity";
    }
}
