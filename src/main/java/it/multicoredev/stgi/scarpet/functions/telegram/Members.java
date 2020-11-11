package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.value.Value;

public class Members {
    public static void apply(Expression expr) {
        // telegram_kick_chat_member(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_kick_chat_member(
        //    bot «string»,
        //    chat_id «string»,
        //    user_id «numeric-int»,
        //    until_date? «numeric-int»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_kick_chat_member", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_unban_chat_member(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_unban_chat_member(
        //    bot «string»,
        //    chat_id «string»,
        //    user_id «numeric-int»,
        //    only_if_banned? «numeric-bool»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_unban_chat_member", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_restrict_chat_member(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_restrict_chat_member(
        //    bot «string»,
        //    chat_id «string»,
        //    user_id «numeric-int»,
        //    permissions «telegram_chat_permissions»,
        //    until_date? «numeric-int»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_restrict_chat_member", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_promote_chat_member(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_promote_chat_member(
        //    bot «string»,
        //    chat_id «string»,
        //    user_id «numeric-int»,
        //    is_anonymous? «null|numeric-bool»,
        //    can_change_info? «null|numeric-bool»,
        //    can_post_messages? «null|numeric-bool»,
        //    can_edit_messages? «null|numeric-bool»,
        //    can_delete_messages? «null|numeric-bool»,
        //    can_invite_users? «null|numeric-bool»,
        //    can_restrict_members? «null|numeric-bool»,
        //    can_pin_messages? «null|numeric-bool»,
        //    can_promote_members? «numeric-bool»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_promote_chat_member", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

    }
}
