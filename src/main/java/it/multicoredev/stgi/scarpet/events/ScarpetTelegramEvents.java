package it.multicoredev.stgi.scarpet.events;

import carpet.script.value.NullValue;
import carpet.script.value.NumericValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;
import it.multicoredev.stgi.scarpet.values.telegram.*;
import net.minecraft.entity.Entity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Arrays;

import carpet.CarpetServer;
import carpet.script.CarpetEventServer.Event;
import carpet.script.value.StringValue;
import org.telegram.telegrambots.meta.api.objects.inlinequery.ChosenInlineQuery;
import org.telegram.telegrambots.meta.api.objects.inlinequery.InlineQuery;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;
import org.telegram.telegrambots.meta.api.objects.payments.ShippingQuery;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollAnswer;

public class ScarpetTelegramEvents extends Event {
    public static ScarpetTelegramEvents TELEGRAM_MESSAGE = new ScarpetTelegramEvents("telegram_message", 3, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.message(message),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_INLINE_QUERY = new ScarpetTelegramEvents("telegram_inline_query", 3, false) {
        @Override
        public void onTelegramInlineQuery(String botUsername, InlineQuery inlineQuery, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.inlineQuery(inlineQuery),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_CHOSEN_INLINE_QUERY = new ScarpetTelegramEvents("telegram_chosen_inline_query", 3, false) {
        @Override
        public void onTelegramChosenInlineQuery(String botUsername, ChosenInlineQuery chosenInlineQuery, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.chosenInlineQuery(chosenInlineQuery),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_CALLBACK_QUERY = new ScarpetTelegramEvents("telegram_callback_query", 3, false) {
        @Override
        public void onTelegramCallbackQuery(String botUsername, CallbackQuery callbackQuery, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.callbackQuery(callbackQuery),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_EDITED_MESSAGE = new ScarpetTelegramEvents("telegram_edited_message", 3, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.message(message),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_CHANNEL_POST = new ScarpetTelegramEvents("telegram_channel_post", 3, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.message(message),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_EDITED_CHANNEL_POST = new ScarpetTelegramEvents("telegram_edited_channel_post", 3, false) {
        @Override
        public void onTelegramMessage(String botUsername, Message message, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.message(message),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_SHIPPING_QUERY = new ScarpetTelegramEvents("telegram_shipping_query", 3, false) {
        @Override
        public void onTelegramShippingQuery(String botUsername, ShippingQuery shippingQuery, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.shippingQuery(shippingQuery),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_PRE_CHECKOUT_QUERY = new ScarpetTelegramEvents("telegram_pre_checkout_query", 3, false) {
        @Override
        public void onTelegramPreCheckoutQuery(String botUsername, PreCheckoutQuery preCheckoutQuery, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.preCheckoutQuery(preCheckoutQuery),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_POLL = new ScarpetTelegramEvents("telegram_poll", 3, false) {
        @Override
        public void onTelegramPoll(String botUsername, Poll poll, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.poll(poll),
                            NullableValue.numeric(updateId)
                    ),
                    () -> CarpetServer.minecraft_server.getCommandSource()
            );
        }
    };

    public static ScarpetTelegramEvents TELEGRAM_POLL_ANSWER = new ScarpetTelegramEvents("telegram_poll_answer", 3, false) {
        @Override
        public void onTelegramPollAnswer(String botUsername, PollAnswer pollAnswer, Integer updateId) {
            handler.call(
                    () -> Arrays.asList(
                            NullableValue.string(botUsername),
                            NullableValue.pollAnswer(pollAnswer),
                            NullableValue.numeric(updateId)
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
                //if(entity == null) return Arrays.asList(NullableValue.string(message), NullableValue.string(type),new NullValue());
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

    public void onTelegramMessage(String botUsername, Message message, Integer updateId) {
    }
    public void onTelegramInlineQuery(String botUsername, InlineQuery inlineQuery, Integer updateId) {
    }
    public void onTelegramChosenInlineQuery(String botUsername, ChosenInlineQuery chosenInlineQuery, Integer updateId) {
    }
    public void onTelegramCallbackQuery(String botUsername, CallbackQuery callbackQuery, Integer updateId) {
    }
    public void onTelegramShippingQuery(String botUsername, ShippingQuery shippingQuery, Integer updateId) {
    }
    public void onTelegramPreCheckoutQuery(String botUsername, PreCheckoutQuery preCheckoutQuery, Integer updateId) {
    }
    public void onTelegramPoll(String botUsername, Poll poll, Integer updateId) {
    }
    public void onTelegramPollAnswer(String botUsername, PollAnswer pollAnswer, Integer updateId) {
    }

    public void onChatMessage(Text text, Entity entity) {
    }
}
