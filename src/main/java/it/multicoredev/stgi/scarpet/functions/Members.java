package it.multicoredev.stgi.scarpet.functions;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class Members {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_kick_chat_member", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_unban_chat_member", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_restrict_chat_member", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_promote_chat_member", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });

    }
}
