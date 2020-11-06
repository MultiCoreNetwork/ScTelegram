package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class Bot {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_get_me", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_log_out", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_close", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_set_my_commands", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_get_my_commands", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });

    }
}
