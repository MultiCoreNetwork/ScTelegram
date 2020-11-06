package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.ScTelegramValue;


public class BotCommandValue extends ScTelegramValue {
    public BotCommandValue(BotCommand botCommand) {
        super(Arrays.asList(
                new StringValue("command"),     new StringValue(botCommand.getCommand()),
                new StringValue("description"), new StringValue(botCommand.getDescription())
        ));
    }

    @Override
    public String getTypeString() {
        return "sctelegram_bot_command";
    }
}
