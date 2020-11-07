package it.multicoredev.stgi.scarpet.functions.telegram;

import carpet.script.Expression;
import carpet.script.value.Value;

public class Stickers {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_send_sticker", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_get_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_upload_sticker_file", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_create_new_sticker_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_add_sticker_to_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_set_sticker_position_in_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_delete_sticker_from_set", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        expr.addLazyFunction("telegram_set_sticker_thumb", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
