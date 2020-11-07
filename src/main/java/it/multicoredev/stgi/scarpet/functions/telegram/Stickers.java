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

public class Stickers {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_send_sticker", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_get_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_upload_sticker_file", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_create_new_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_add_sticker_to_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_set_sticker_position_in_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_delete_sticker_from_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_set_sticker_thumb", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
