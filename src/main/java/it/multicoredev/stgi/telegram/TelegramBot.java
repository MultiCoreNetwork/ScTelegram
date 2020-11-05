package it.multicoredev.stgi.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {
    private String botUsername;
    private String botToken;
    private TelegramEventHandler telegramEventHandler;

    public TelegramBot(String botUsername, String botToken, TelegramEventHandler telegramEventHandler) {
        this.botUsername = botUsername;
        this.botToken = botToken;
        this.telegramEventHandler = telegramEventHandler;
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        telegramEventHandler.handleTelegramEvent(update);
    }
}
