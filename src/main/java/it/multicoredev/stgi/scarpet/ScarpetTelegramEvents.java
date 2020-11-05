package it.multicoredev.stgi.scarpet;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

import carpet.CarpetServer;
import carpet.script.CarpetEventServer.Event;
import carpet.script.value.StringValue;

public class ScarpetTelegramEvents extends Event {
    public static ScarpetTelegramEvents TELEGRAM_EVENT = new ScarpetTelegramEvents("telegram_event", 2, false) {
        @Override
        public void onTelegramEvent(String botUsername, Update update) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new StringValue(update.toString())
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public ScarpetTelegramEvents(String name, int reqArgs, boolean isGlobalOnly) {
        super(name, reqArgs, isGlobalOnly);
    }

    public static void noop() {
    }

    public void onTelegramEvent(String botUsername, Update update) {
    }
}
