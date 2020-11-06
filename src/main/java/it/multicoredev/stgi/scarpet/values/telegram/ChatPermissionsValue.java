package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;

import carpet.script.value.MapValue;


public class ChatPermissionsValue extends MapValue {
    public ChatPermissionsValue(Message message) {
        super(Arrays.asList(
                //todo
        ));
    }

    @Override
    public String getTypeString() {
        return "sctelegram_chat_permission";
    }
}
