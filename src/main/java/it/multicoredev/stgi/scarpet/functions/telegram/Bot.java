package it.multicoredev.stgi.scarpet.functions.telegram;

import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.methods.commands.GetMyCommands;
import org.telegram.telegrambots.meta.api.methods.updates.Close;
import org.telegram.telegrambots.meta.api.methods.updates.LogOut;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.WebhookInfo;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;
import it.multicoredev.stgi.scarpet.values.telegram.BotCommandValue;
import it.multicoredev.stgi.scarpet.values.telegram.UserValue;
import it.multicoredev.stgi.telegram.TelegramBot;

import static java.util.stream.Collectors.toList;

public class Bot {
    public static void apply(Expression expr) {

        // telegram_get_me(bot «string») => user «telegram_user»
        expr.addLazyFunction("telegram_get_me", 1, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                User user = telegramBot.execute(new GetMe());
                return (_c, _t) -> new UserValue(user);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_log_out(bot «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_log_out", 1, (c, t, lv) -> {
            //FIXME Ausnahme beheben
            String botName = lv.get(0).evalValue(c).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                WebhookInfo webhookInfo = telegramBot.execute(new LogOut());
                return (_c, _t) -> new NumericValue(webhookInfo != null);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_close(bot «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_close", 1, (c, t, lv) -> {
            //FIXME Ausnahme beheben
            String botName = lv.get(0).evalValue(c).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                WebhookInfo webhookInfo = telegramBot.execute(new Close());
                return (_c, _t) -> new NumericValue(webhookInfo != null);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_set_my_commands(bot «string», commands «l(telegram_bot_command)») => true|false «numeric-bool»
        // telegram_set_my_commands(
        //    bot «string»,
        //    command «telegram_bot_command»,
        //    command? «telegram_bot_command»,
        //    ...
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_my_commands", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_get_my_commands(bot «string») => commands «l(telegram_bot_command)»
        expr.addLazyFunction("telegram_get_my_commands", -1, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                List<BotCommand> botCommands = telegramBot.execute(new GetMyCommands());
                return (_c, _t) -> new ListValue(botCommands.stream().map(BotCommandValue::new).collect(toList()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });
    }
}
