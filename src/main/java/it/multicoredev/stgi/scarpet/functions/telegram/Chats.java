package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class Chats {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_get_chat", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_get_chat_administrators", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_get_chat_member", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_get_chat_members_count", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_permissions", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_photo", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_title", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_description", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_administrator_custom_title", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_chat_sticker_set", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_delete_chat_sticker_set", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_delete_chat_photo", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_leave_chat", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_pin_chat_message", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_unpin_chat_message", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_unpin_all_chat_messages", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_export_chat_invite_link", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
