package it.multicoredev.stgi.scarpet.functions.telegram;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.request.Close;
import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.request.GetMyCommands;
import com.pengrad.telegrambot.request.LogOut;
import com.pengrad.telegrambot.request.SetMyCommands;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.GetMyCommandsResponse;

import java.util.List;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.ListValue;
import carpet.script.value.NBTSerializableValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;

import static it.multicoredev.stgi.scarpet.functions.Util.isTAGList;
import static java.util.stream.Collectors.toList;

public class Bot {
    public static void apply(Expression expr) {

        // telegram_get_me(bot «string») => user «telegram_user»
        expr.addLazyFunction("telegram_get_me", 1, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);
            GetMeResponse response = telegramBot.execute(new GetMe());
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.user()));
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_log_out(bot «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_log_out", 1, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);
            BaseResponse response = telegramBot.execute(new LogOut());
            return (_c, _t) -> new NumericValue(response.isOk());
        });

        // telegram_close(bot «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_close", 1, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);
            BaseResponse response = telegramBot.execute(new Close());
            return (_c, _t) -> new NumericValue(response.isOk());
        });

        // telegram_set_my_commands(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_my_commands(bot «string», commands «l(telegram_bot_command)») => true|false «numeric-bool»
        //
        // telegram_set_my_commands(
        //    bot «string»,
        //    command «telegram_bot_command»,
        //    command? «telegram_bot_command»,
        //    ...
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_my_commands", -1, (c, t, lv) -> {
            if (lv.size() < 2)
                throw new InternalExpressionException("'telegram_set_my_commands' requires at least two parameters");
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            String botCommandsJson;
            if (params.size() == 2 && params.get(1) instanceof ListValue) {
                botCommandsJson = new Gson().toJson(params.get(1));
            } else if (params.size() == 2 && isTAGList(params.get(1))) {
                botCommandsJson = new Gson().toJson(params.get(1));
            } else {
                ListValue botCommands = new ListValue(params.subList(1, params.size()));
                botCommandsJson = new Gson().toJson(botCommands);
            }

            BotCommand[] botCommands;
            try {
                botCommands = new Gson().fromJson(botCommandsJson, BotCommand[].class);
            } catch (JsonParseException e) {
                throw new InternalExpressionException("Error during the execution of 'telegram_set_my_commands'");
            }

            BaseResponse response = telegramBot.execute(new SetMyCommands(botCommands));
            return (_c, _t) -> new NumericValue(response.isOk());
        });

        // telegram_get_my_commands(bot «string») => commands «telegram_bot_command[]»
        expr.addLazyFunction("telegram_get_my_commands", 1, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);
            GetMyCommandsResponse response = telegramBot.execute(new GetMyCommands());
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.commands()));
            else return (_c, _t) -> Value.NULL;
        });
    }
}
