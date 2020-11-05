package it.multicoredev.stgi.telegram;

import org.telegram.telegrambots.meta.api.objects.Update;

import static it.multicoredev.stgi.scarpet.ScarpetTelegramEvents.TELEGRAM_EVENT;

public class TelegramEventHandler {
    private String botUsername;

    public TelegramEventHandler(String botUsername) {
        this.botUsername = botUsername;
    }

    public void handleTelegramEvent(Update update) {
        TELEGRAM_EVENT.onTelegramEvent(botUsername, update);
    }
}
