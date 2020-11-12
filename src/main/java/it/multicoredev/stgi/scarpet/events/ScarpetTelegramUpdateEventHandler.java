package it.multicoredev.stgi.scarpet.events;

import org.telegram.telegrambots.meta.api.objects.Update;

public class ScarpetTelegramUpdateEventHandler {
    public static void onUpdateEvent(String botUsername, Update update) {
        if(update.hasMessage()) {
            ScarpetTelegramEvents.TELEGRAM_MESSAGE.onTelegramMessage(botUsername, update.getMessage(), update.getUpdateId());
        }
        if(update.hasInlineQuery()) {
            ScarpetTelegramEvents.TELEGRAM_INLINE_QUERY.onTelegramInlineQuery(botUsername, update.getInlineQuery(), update.getUpdateId());
        }
        if(update.hasChosenInlineQuery()) {
            ScarpetTelegramEvents.TELEGRAM_CHOSEN_INLINE_QUERY.onTelegramChosenInlineQuery(botUsername, update.getChosenInlineQuery(), update.getUpdateId());
        }
        if(update.hasCallbackQuery()) {
            ScarpetTelegramEvents.TELEGRAM_CALLBACK_QUERY.onTelegramCallbackQuery(botUsername, update.getCallbackQuery(), update.getUpdateId());
        }
        if(update.hasEditedMessage()) {
            ScarpetTelegramEvents.TELEGRAM_EDITED_MESSAGE.onTelegramMessage(botUsername, update.getEditedMessage(), update.getUpdateId());
        }
        if(update.hasChannelPost()) {
            ScarpetTelegramEvents.TELEGRAM_CHANNEL_POST.onTelegramMessage(botUsername, update.getChannelPost(), update.getUpdateId());
        }
        if(update.hasEditedMessage()) {
            ScarpetTelegramEvents.TELEGRAM_EDITED_CHANNEL_POST.onTelegramMessage(botUsername, update.getEditedChannelPost(), update.getUpdateId());
        }
        if(update.hasShippingQuery()) {
            ScarpetTelegramEvents.TELEGRAM_SHIPPING_QUERY.onTelegramShippingQuery(botUsername, update.getShippingQuery(), update.getUpdateId());
        }
        if(update.hasPreCheckoutQuery()) {
            ScarpetTelegramEvents.TELEGRAM_PRE_CHECKOUT_QUERY.onTelegramPreCheckoutQuery(botUsername, update.getPreCheckoutQuery(), update.getUpdateId());
        }
        if(update.hasPoll()) {
            ScarpetTelegramEvents.TELEGRAM_POLL.onTelegramPoll(botUsername, update.getPoll(), update.getUpdateId());
        }
        if(update.hasPollAnswer()) {
            ScarpetTelegramEvents.TELEGRAM_POLL_ANSWER.onTelegramPollAnswer(botUsername, update.getPollAnswer(), update.getUpdateId());
        }
    }
}
