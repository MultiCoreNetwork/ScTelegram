package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class FileDownload {
    public static void apply(Expression expr) {
        // telegram_get_user_profile_photos(bot «string», user_id «numeric-int») => user_photos «telegram_user_profile_photos»
        expr.addLazyFunction("telegram_get_user_profile_photos", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_get_file(bot «string», file_id «string») => file «telegram_file»
        expr.addLazyFunction("telegram_get_file", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

    }
}
