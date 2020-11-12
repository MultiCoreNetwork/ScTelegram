package it.multicoredev.stgi.telegram;

<<<<<<< Updated upstream
import it.multicoredev.stgi.scarpet.events.ScarpetTelegramUpdateEventHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramEventHandler {
=======
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import java.util.List;

import static it.multicoredev.stgi.scarpet.events.ScTelegramEvents.*;

public class TelegramEventHandler implements UpdatesListener {
>>>>>>> Stashed changes
    private String botUsername;

    public TelegramEventHandler(String botUsername) {
        this.botUsername = botUsername;
    }

<<<<<<< Updated upstream
    public void handleTelegramEvent(Update update) {
        ScarpetTelegramUpdateEventHandler.onUpdateEvent(botUsername, update);
=======

    @Override
    public int process(List<Update> updates) {
        updates.forEach(u -> {
            TELEGRAM_EVENT.onTelegramEvent(botUsername, u);
            if(u.message() != null)
                TELEGRAM_MESSAGE.onTelegramMessage(botUsername, u.message());
            if(u.inlineQuery() != null)
                TELEGRAM_INLINE_QUERY.onTelegramInlineQuery(botUsername, u.inlineQuery());
            if(u.chosenInlineResult() != null)
                TELEGRAM_CHOSEN_INLINE_RESULT.onTelegramChosenInlineResult(botUsername, u.chosenInlineResult());
            if(u.callbackQuery() != null)
                TELEGRAM_CALLBACK_QUERY.onTelegramCallbackQuery(botUsername, u.callbackQuery());
            if(u.editedMessage() != null)
                TELEGRAM_EDITED_MESSAGE.onTelegramMessage(botUsername, u.editedMessage());
            if(u.channelPost() != null)
                TELEGRAM_CHANNEL_POST.onTelegramMessage(botUsername, u.channelPost());
            if(u.editedChannelPost() != null)
                TELEGRAM_EDITED_CHANNEL_POST.onTelegramMessage(botUsername, u.editedChannelPost());
            if(u.shippingQuery() != null)
                TELEGRAM_SHIPPING_QUERY.onTelegramShippingQuery(botUsername, u.shippingQuery());
            if(u.preCheckoutQuery() != null)
                TELEGRAM_PRE_CHECKOUT_QUERY.onTelegramPreCheckoutQuery(botUsername, u.preCheckoutQuery());
            if(u.poll() != null)
                TELEGRAM_POLL.onTelegramPoll(botUsername, u.poll());
            if(u.pollAnswer() != null)
                TELEGRAM_POLL_ANSWER.onTelegramPollAnswer(botUsername, u.pollAnswer());
        });


        return UpdatesListener.CONFIRMED_UPDATES_ALL;
>>>>>>> Stashed changes
    }
}
