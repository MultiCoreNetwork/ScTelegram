package de.replaceitem.discarpet;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.Arrays;
import java.util.UUID;

import carpet.CarpetServer;
import carpet.script.CarpetEventServer;
import carpet.script.value.EntityValue;
import carpet.script.value.NullValue;
import carpet.script.value.StringValue;

public class ScarpetEvents {
    public static final CarpetEventServer.Event CHAT_MESSAGE = new CarpetEventServer.Event("chat_message", 3, false) {
        public void onChatMessage(Text text, UUID senderUuid) {
            this.handler.call(
                    () -> {
                        String message;
                        String type;
                        if (text instanceof TranslatableText) {
                            type = ((TranslatableText) text).getKey();
                            message = text.getString();
                        } else if (text instanceof LiteralText) {
                            type = text.getClass().getName();
                            message = (text).getString();
                        } else {
                            message = null;
                            type = text.getClass().getName();
                            System.out.println("Unknown chat event type: " + type);
                        }

                        Entity e = null;
                        for (ServerWorld w : CarpetServer.minecraft_server.getWorlds()) {
                            if (w.getEntity(senderUuid) != null) e = w.getEntity(senderUuid);
                        }

                        return Arrays.asList(
                                new StringValue(message),
                                new StringValue(type),
                                e != null ? new EntityValue(e) : new NullValue()
                        );

                    },
                    () -> {
                        if (senderUuid != null)
                            for (ServerWorld w : CarpetServer.minecraft_server.getWorlds()) {
                                if (w.getEntity(senderUuid) != null)
                                    return w.getEntity(senderUuid).getCommandSource();
                            }
                        return CarpetServer.minecraft_server.getCommandSource();
                    }
            );
        }
    };
}
