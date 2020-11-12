package it.multicoredev.stgi.scarpet.functions.telegram;

import com.google.gson.Gson;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.GetChat;
import com.pengrad.telegrambot.request.GetChatAdministrators;
import com.pengrad.telegrambot.request.GetChatMember;
import com.pengrad.telegrambot.request.GetChatMembersCount;
import com.pengrad.telegrambot.response.GetChatAdministratorsResponse;
import com.pengrad.telegrambot.response.GetChatMemberResponse;
import com.pengrad.telegrambot.response.GetChatMembersCountResponse;
import com.pengrad.telegrambot.response.GetChatResponse;

import java.util.List;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.NBTSerializableValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;

import static it.multicoredev.stgi.scarpet.functions.Util.get;
import static it.multicoredev.stgi.scarpet.functions.Util.has;
import static it.multicoredev.stgi.scarpet.functions.Util.isTAGCompound;
import static it.multicoredev.stgi.scarpet.functions.Util.toNumeric;
import static java.util.stream.Collectors.toList;

public class Chats {
    public static void apply(Expression expr) {
        // telegram_get_chat(bot «string», parameters_nbt «nbt») => chat «telegram_chat»
        //
        // telegram_get_chat(bot «string», chat_id «string») => chat «telegram_chat»
        expr.addLazyFunction("telegram_get_chat", 2, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            String chatId;
            if (isTAGCompound(params.get(1))) {
                NBTSerializableValue param_nbt = (NBTSerializableValue) params.get(1);
                if (!has(param_nbt, "chat_id"))
                    throw new InternalExpressionException("Missing 'chat_id' value in 'parmeters_nbt'");
                chatId = get(param_nbt,"chat_id").getString();
            } else {
                chatId = params.get(1).getString();
            }

            GetChatResponse response = telegramBot.execute(new GetChat(chatId));
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.chat()));
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_get_chat_administrators(bot «string», parameters_nbt «nbt») => chat_list «l(telegram_chat_member)»
        //
        // telegram_get_chat_administrators(bot «string», chat_id «string») => chat_list «l(telegram_chat_member)»
        expr.addLazyFunction("telegram_get_chat_administrators", 2, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            String chatId;
            if (isTAGCompound(params.get(1))) {
                NBTSerializableValue param_nbt = (NBTSerializableValue) params.get(1);
                if (!has(param_nbt, "chat_id"))
                    throw new InternalExpressionException("Missing 'chat_id' value in 'parmeters_nbt'");
                chatId = get(param_nbt,"chat_id").getString();
            } else {
                chatId = params.get(1).getString();
            }

            GetChatAdministratorsResponse response = telegramBot.execute(new GetChatAdministrators(chatId));
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.administrators()));
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_get_chat_member(bot «string», parameters_nbt «nbt») => chat_member «telegram_chat_member»
        //
        // telegram_get_chat_member(bot «string», chat_id «string», user_id «numeric-int») => chat_member «telegram_chat_member»
        expr.addLazyFunction("telegram_get_chat_member", 3, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            String chatId;
            int userId;
            if (params.size() == 2) {
                if (isTAGCompound(params.get(1))) {
                    NBTSerializableValue param_nbt = (NBTSerializableValue) params.get(1);
                    if (!has(param_nbt, "chat_id"))
                        throw new InternalExpressionException("Missing 'chat_id' value in 'parmeters_nbt'");
                    if (!has(param_nbt, "user_id"))
                        throw new InternalExpressionException("Missing 'user_id' value in 'parmeters_nbt'");

                    chatId = get(param_nbt,"chat_id").getString();
                    try {
                        userId = toNumeric(get(param_nbt, "user_id")).getInt();
                    } catch (NullPointerException e) {
                        throw new InternalExpressionException("Invalid 'user_id' parameter value");
                    }
                } else {
                    throw new InternalExpressionException("'telegram_get_chat_member' requires at least three parameters if the second one is not an 'nbt'");
                }
            } else{
                chatId = params.get(1).getString();
                try {
                    userId = toNumeric(params.get(2)).getInt();
                } catch (NullPointerException e) {
                    throw new InternalExpressionException("Invalid 'user_id' parameter value");
                }
            }

            GetChatMemberResponse response = telegramBot.execute(new GetChatMember(chatId, userId));
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.chatMember()));
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_get_chat_members_count(bot «string», parameters_nbt «nbt») => count «numeric-int»
        //
        // telegram_get_chat_members_count(bot «string», chat_id «string») => count «numeric-int»
        expr.addLazyFunction("telegram_get_chat_members_count", 2, (c, t, lv) -> {
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            String chatId;
            if (isTAGCompound(params.get(1))) {
                NBTSerializableValue param_nbt = (NBTSerializableValue) params.get(1);
                if (!has(param_nbt, "chat_id"))
                    throw new InternalExpressionException("Missing 'chat_id' value in 'parmeters_nbt'");

                chatId = get(param_nbt,"chat_id").getString();
            } else {
                chatId = params.get(1).getString();
            }

            GetChatMembersCountResponse response = telegramBot.execute(new GetChatMembersCount(chatId));
            if (response.isOk())
                return (_c, _t) -> new NumericValue(response.count());
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_set_chat_permissions(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_permissions(bot «string», chat_id «string», permissions «telegram_chat_permissions») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_permissions", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_photo(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_photo(bot «string», chat_id «string», photo «telegram_input_file») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_photo", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_title(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_title(bot «string», chat_id «string», title «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_title", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_description(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_description(bot «string», chat_id «string», description «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_description", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_administrator_custom_title(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_administrator_custom_title(
        //    bot «string»,
        //    chat_id «string»,
        //    user_id «numeric-integer»,
        //    custom_title «string»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_administrator_custom_title", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });


        // telegram_set_chat_sticker_set(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_set_chat_sticker_set(bot «string», chat_id «string», sticker_set_name «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_delete_chat_sticker_set(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_delete_chat_sticker_set(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_delete_chat_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_delete_chat_photo(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_delete_chat_photo(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_delete_chat_photo", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_leave_chat(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_leave_chat(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_leave_chat", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_pin_chat_message(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_pin_chat_message(
        //    bot «string»,
        //    chat_id «string»,
        //    message_id «numeric-int»,
        //    disable_notification? «numeric-bool»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_pin_chat_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_unpin_chat_message(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_unpin_chat_message(bot «string», chat_id «string», message_id «numeric-int») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_unpin_chat_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_unpin_all_chat_messages(bot «string», parameters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_unpin_all_chat_messages(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_unpin_all_chat_messages", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_export_chat_invite_link(bot «string», parameters_nbt «nbt») => link «string»
        //
        // telegram_export_chat_invite_link(bot «string», chat_id «string») => link «string»
        expr.addLazyFunction("telegram_export_chat_invite_link", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
