package it.multicoredev.stgi.scarpet.events;

import com.google.gson.Gson;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.ChosenInlineResult;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Poll;
import com.pengrad.telegrambot.model.PollAnswer;
import com.pengrad.telegrambot.model.PreCheckoutQuery;
import com.pengrad.telegrambot.model.ShippingQuery;
import com.pengrad.telegrambot.model.Update;

import net.minecraft.entity.Entity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.Arrays;

import carpet.CarpetServer;
import carpet.script.CarpetEventServer.Event;
import carpet.script.value.NBTSerializableValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ScTelegramEvents extends Event {
    public static ScTelegramEvents TELEGRAM_EVENT = new ScTelegramEvents("telegram_event", 2, false) {
        @Override
        public void onTelegramEvent(String botUsername, Update update) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(update))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };
    public static ScTelegramEvents TELEGRAM_MESSAGE = new ScTelegramEvents("telegram_message", 2, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            new NBTSerializableValue(new Gson().toJson(message))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };
    public static ScTelegramEvents TELEGRAM_INLINE_QUERY = new ScTelegramEvents("telegram_inline_query", 2, false) {
        @Override
        public void onTelegramInlineQuery(String botUsername, InlineQuery inlineQuery) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(inlineQuery))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_CHOSEN_INLINE_RESULT = new ScTelegramEvents("telegram_chosen_inline_result", 2, false) {
        @Override
        public void onTelegramChosenInlineResult(String botUsername, ChosenInlineResult chosenInlineResult) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(chosenInlineResult))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_CALLBACK_QUERY = new ScTelegramEvents("telegram_callback_query", 2, false) {
        @Override
        public void onTelegramCallbackQuery(String botUsername, CallbackQuery callbackQuery) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(callbackQuery))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_EDITED_MESSAGE = new ScTelegramEvents("telegram_edited_message", 2, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(message))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_CHANNEL_POST = new ScTelegramEvents("telegram_channel_post", 2, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(message))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_EDITED_CHANNEL_POST = new ScTelegramEvents("telegram_edited_channel_post", 2, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(message))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_SHIPPING_QUERY = new ScTelegramEvents("telegram_shipping_query", 2, false) {
        @Override
        public void onTelegramShippingQuery(String botUsername, ShippingQuery shippingQuery) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(shippingQuery))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_PRE_CHECKOUT_QUERY = new ScTelegramEvents("telegram_pre_checkout_query", 2, false) {
        @Override
        public void onTelegramPreCheckoutQuery(String botUsername, PreCheckoutQuery preCheckoutQuery) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(preCheckoutQuery))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_POLL = new ScTelegramEvents("telegram_poll", 2, false) {
        @Override
        public void onTelegramPoll(String botUsername, Poll poll) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(poll))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents TELEGRAM_POLL_ANSWER = new ScTelegramEvents("telegram_poll_answer", 2, false) {
        @Override
        public void onTelegramPollAnswer(String botUsername, PollAnswer pollAnswer) {
            handler.call(
                    () -> Arrays.asList(
                            new StringValue(botUsername),
                            new NBTSerializableValue(new Gson().toJson(pollAnswer))
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScTelegramEvents CHAT_MESSAGE = new ScTelegramEvents("chat_message", 3, false) {
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
                return Arrays.asList(new StringValue(message), new StringValue(type), NullableValue.entity(entity));

            }, () -> {
                if(entity == null) {
                    return CarpetServer.minecraft_server.getCommandSource().withWorld(CarpetServer.minecraft_server.getWorld(World.OVERWORLD));
                } else {
                    return entity.getCommandSource();
                }
            });
        }
    };

    public ScTelegramEvents(String name, int reqArgs, boolean isGlobalOnly) {
        super(name, reqArgs, isGlobalOnly);
    }

    public static void noop() {
    }

    public void onTelegramEvent(String botUsername, Update update) {
    }
    public void onTelegramMessage(String botUsername, Message message) {
    }
    public void onTelegramInlineQuery(String botUsername, InlineQuery inlineQuery) {
    }
    public void onTelegramChosenInlineResult(String botUsername, ChosenInlineResult chosenInlineResult) {
    }
    public void onTelegramCallbackQuery(String botUsername, CallbackQuery callbackQuery) {
    }
    public void onTelegramShippingQuery(String botUsername, ShippingQuery shippingQuery) {
    }
    public void onTelegramPreCheckoutQuery(String botUsername, PreCheckoutQuery preCheckoutQuery) {
    }
    public void onTelegramPoll(String botUsername, Poll poll) {
    }
    public void onTelegramPollAnswer(String botUsername, PollAnswer pollAnswer) {
    }
    public void onChatMessage(Text text, Entity entity) {
    }
}
