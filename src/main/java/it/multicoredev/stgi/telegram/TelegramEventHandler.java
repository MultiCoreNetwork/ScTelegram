package it.multicoredev.stgi.telegram;

import it.multicoredev.stgi.scarpet.events.ScarpetTelegramUpdateEventHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramEventHandler {
    private String botUsername;

    public TelegramEventHandler(String botUsername) {
        this.botUsername = botUsername;
    }

    public void handleTelegramEvent(Update update) {
        ScarpetTelegramUpdateEventHandler.onUpdateEvent(botUsername, update);
    }
}
