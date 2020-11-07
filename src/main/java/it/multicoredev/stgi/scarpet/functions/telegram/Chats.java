package it.multicoredev.stgi.scarpet.functions.telegram;

import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatAdministrators;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMembersCount;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.ChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.stream.Collectors;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.ListValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;
import it.multicoredev.stgi.scarpet.values.telegram.ChatMemberValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatValue;
import it.multicoredev.stgi.telegram.TelegramBot;

import static java.util.stream.Collectors.toList;

public class Chats {
    public static void apply(Expression expr) {
        // telegram_get_chat(bot «string», chat_id «string») => chat «telegram_chat»
        expr.addLazyFunction("telegram_get_chat", 2, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            String chatID = lv.get(1).evalValue(c).getString();

            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                GetChat getChat = new GetChat();
                getChat.setChatId(chatID);
                Chat chat = telegramBot.execute(getChat);
                return (_c, _t) -> new ChatValue(chat);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_get_chat_administrators(bot «string», chat_id «string») => chat_list «l(telegram_chat_member)»
        expr.addLazyFunction("telegram_get_chat_administrators", 2, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            String chatID = lv.get(1).evalValue(c).getString();

            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                GetChatAdministrators getChatAdministrators = new GetChatAdministrators();
                getChatAdministrators.setChatId(chatID);
                List<ChatMember> chatMembers = telegramBot.execute(getChatAdministrators);
                return (_c, _t) -> new ListValue(chatMembers.stream().map(ChatMemberValue::new).collect(toList()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_get_chat_member(bot «string», chat_id «string», user_id «numeric-int») => chat_member «telegram_chat_member»
        expr.addLazyFunction("telegram_get_chat_member", 3, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            String chatID = lv.get(1).evalValue(c).getString();
            int userID = NumericValue.asNumber(lv.get(2).evalValue(c)).getInt();

            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                GetChatMember getChatMember = new GetChatMember();
                getChatMember.setChatId(chatID);
                getChatMember.setUserId(userID);
                ChatMember chatMember = telegramBot.execute(getChatMember);
                return (_c, _t) -> new ChatMemberValue(chatMember);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_get_chat_members_count(bot «string», chat_id «string») => count «numeric-int»
        expr.addLazyFunction("telegram_get_chat_members_count", 2, (c, t, lv) -> {
            String botName = lv.get(0).evalValue(c).getString();
            String chatID = lv.get(1).evalValue(c).getString();

            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                GetChatMembersCount chatMembersCount = new GetChatMembersCount();
                chatMembersCount.setChatId(chatID);
                int count = telegramBot.execute(chatMembersCount);
                return (_c, _t) -> new NumericValue(count);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_set_chat_permissions(bot «string», chat_id «string», permissions «telegram_chat_permissions») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_permissions", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_photo(bot «string», chat_id «string», photo «telegram_input_file») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_photo", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_title(bot «string», chat_id «string», title «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_title", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_set_chat_description(bot «string», chat_id «string», description «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_description", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

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

        // telegram_set_chat_sticker_set(bot «string», chat_id «string», sticker_set_name «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_set_chat_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_delete_chat_sticker_set(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_delete_chat_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_delete_chat_photo(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_delete_chat_photo", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_leave_chat(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_leave_chat", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

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

        // telegram_unpin_chat_message(bot «string», chat_id «string», message_id «numeric-int») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_unpin_chat_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_unpin_all_chat_messages(bot «string», chat_id «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_unpin_all_chat_messages", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_export_chat_invite_link(bot «string», chat_id «string») => link «string»
        expr.addLazyFunction("telegram_export_chat_invite_link", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
