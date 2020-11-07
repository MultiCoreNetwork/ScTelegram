package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ChatLocation;

import java.util.Arrays;

import carpet.script.value.StringValue;


public class ChatLocationValue extends ScTelegramValue {
    public ChatLocationValue(ChatLocation chatLocation) {
        super(Arrays.asList(
                new StringValue("location"), new LocationValue(chatLocation.getLocation()),
                new StringValue("address"),  new StringValue(chatLocation.getAddress())
        ));
    }

    @Override
    public String getTypeString() {
        return "telegram_chat_location";
    }
}
