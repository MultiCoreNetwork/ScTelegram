package it.multicoredev.stgi.scarpet.functions;

import carpet.script.Expression;
import carpet.script.LazyValue;
import carpet.script.value.Value;

public class Messages {
    public static void apply(Expression expr) {
        expr.addLazyFunction("telegram_send_message", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_photo", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_audio", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_document", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_video", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_animation", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_voice", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_video_note", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_media_group", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_location", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_venue", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_contact", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_poll", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_dice", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_send_chat_action", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_forward_message", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_copy_message", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_edit_message_live_location", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_stop_message_live_location", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
        expr.addLazyFunction("telegram_answer_callback_query", -1, (c, t, lv) -> {

            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
