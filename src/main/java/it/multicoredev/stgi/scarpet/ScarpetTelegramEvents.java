package it.multicoredev.stgi.scarpet;

import it.multicoredev.stgi.scarpet.values.NullableValue;
import net.minecraft.entity.Entity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

import carpet.CarpetServer;
import carpet.script.CarpetEventServer.Event;
import carpet.script.value.StringValue;

import javax.validation.constraints.Null;

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


    public static ScarpetTelegramEvents CHAT_MESSAGE = new ScarpetTelegramEvents("chat_message", 3, false) {
        @Override
        public void onChatMessage(Text text,Entity entity) {
            this.handler.call(() -> {
                String message;
                String type;
                if(text instanceof TranslatableText) {
                    type = ((TranslatableText) text).getKey();
                    message = text.getString();
                } else if(text instanceof LiteralText) {
                    type = text.getClass().getName();
                    message = (text).getString();
                } else {
                    message = "unknown text type";
                    type = text.getClass().getName();
                }
                //if(entity == null) return Arrays.asList(new StringValue(message), new StringValue(type),new NullValue());
                return Arrays.asList(NullableValue.string(message), NullableValue.string(type),NullableValue.entity(entity));

            }, () -> {
                if(entity == null) {
                    return CarpetServer.minecraft_server.getCommandSource().withWorld(CarpetServer.minecraft_server.getWorld(World.OVERWORLD));
                } else {
                    return entity.getCommandSource();
                }
            });
        }
    };

    public ScarpetTelegramEvents(String name, int reqArgs, boolean isGlobalOnly) {
        super(name, reqArgs, isGlobalOnly);
    }

    public static void noop() {
    }

    public void onTelegramEvent(String botUsername, Update update) {
    }

    public void onChatMessage(Text text, Entity entity) {
    }
}
