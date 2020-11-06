package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class FileDownload {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_get_user_profile_photos", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_get_file", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });

    }
}
