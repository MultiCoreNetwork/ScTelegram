package it.multicoredev.stgi.scarpet.functions.telegram;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;
import it.multicoredev.stgi.scarpet.values.telegram.MessageValue;
import it.multicoredev.stgi.telegram.TelegramBot;

public class Messages {
    public static void apply(Expression expr) {
        // telegram_send_message(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_message(
        //    bot «string»,
        //    chat_id «string»,
        //    text «string»,
        //    parse_mode? «null|string»,
        //    entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_web_page_preview? «null|numeric-bool»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_message", 3, (c, t, lv) -> {
            //FIXME Parameterverwaltung
            String botName = lv.get(0).evalValue(c).getString();
            String chatID = lv.get(1).evalValue(c).getString();
            String message_text = lv.get(2).evalValue(c).getString();

            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null) throw new InternalExpressionException("Invalid bot name: " + botName);
            try {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatID);
                sendMessage.setText(message_text);

                Message message = telegramBot.execute(sendMessage);
                return (_c, _t) -> new MessageValue(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
                throw new InternalExpressionException("Telegram API Exception");
            }
        });

        // telegram_send_photo(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_photo(
        //    bot «string»,
        //    chat_id «string»,
        //    photo «string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_photo", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_audio(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_audio(
        //    bot «string»,
        //    chat_id «string»,
        //    audio «string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    duration? «null|numeric-int»,
        //    performer? «null|string»,
        //    title? «null|string»,
        //    thumb? «null|string|telegram_input_file»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_audio", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_document(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_document(
        //    bot «string»,
        //    chat_id «string»,
        //    document «string|telegram_input_file»,
        //    thumb? «null|string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_content_type_detection? «null|numeric-bool»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_document", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_video(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_video(
        //    bot «string»,
        //    chat_id «string»,
        //    video «string|telegram_input_file»,
        //    duration? «null|numeric-int»,
        //    width? «null|numeric-int»,
        //    height? «null|numeric-int»,
        //    thumb? «null|string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    supports_streaming? «null|numeric-bool»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_video", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_animation(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_animation(
        //    bot «string»,
        //    chat_id «string»,
        //    animation «string|telegram_input_file»,
        //    duration? «null|numeric-int»,
        //    width? «null|numeric-int»,
        //    height? «null|numeric-int»,
        //    thumb? «null|string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_animation", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_voice(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_voice(
        //    bot «string»,
        //    chat_id «string»,
        //    voice «string|telegram_input_file»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    duration? «null|numeric-int»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_voice", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_video_note(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_video_note(
        //    bot «string»,
        //    chat_id «string»,
        //    video_note «string|telegram_input_file»,
        //    duration? «null|numeric-int»,
        //    length? «null|numeric-int»,
        //    thumb? «null|string|telegram_input_file»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_video_note", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_media_group(bot «string», parameters_map «map») => messages «l(telegram_message)»
        //
        // telegram_send_media_group(
        //    bot «string»,
        //    chat_id «string»,
        //    media «string|telegram_input_media_audio»,
        //    duration? «null|numeric-int»,
        //    length? «null|numeric-int»,
        //    thumb? «null|l(telegram_input_media_audio)|l(telegram_input_media_document)|l(telegram_input_media_photo)|l(telegram_input_media_video)|telegram_input_media_audio|telegram_input_media_document|telegram_input_media_photo|telegram_input_media_video»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»
        // ) => messages «l(telegram_message)»
        expr.addLazyFunction("telegram_send_media_group", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_location(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_location(
        //    bot «string»,
        //    chat_id «string»,
        //    latitude «numeric-float»,
        //    latitude «numeric-float»,
        //    horizontal_accuracy? «null|numeric-float»,
        //    live_period? «null|numeric-int»,
        //    heading? «null|numeric-int»,
        //    proximity_alert_radius? «null|numeric-int»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_location", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_venue(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_venue(
        //    bot «string»,
        //    chat_id «string»,
        //    latitude «numeric-float»,
        //    latitude «numeric-float»,
        //    title «null|string»,
        //    address «null|string»,
        //    foursquare_id? «null|string»,
        //    foursquare_type? «null|string»,
        //    google_place_id? «null|string»,
        //    google_place_type? «null|string»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_venue", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_contact(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_contact(
        //    bot «string»,
        //    chat_id «string»,
        //    phone_number «string»,
        //    first_name «string»,
        //    last_name? «null|string»,
        //    vcard? «null|string»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_contact", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_poll(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_poll(
        //    bot «string»,
        //    chat_id «string»,
        //    question «string»,
        //    options «l(string)»,
        //    is_anonymous? «null|numeric-bool»,
        //    type? «null|string»,
        //    allows_multiple_answers? «null|numeric-bool»,
        //    correct_option_id? «null|numeric-int»,
        //    explanation? «null|string»,
        //    explanation_parse_mode? «null|string»,
        //    explanation_entities? «null|l(telegram_message_entity)»,
        //    open_period? «null|numeric-int»,
        //    close_date? «null|numeric-int»,
        //    is_closed? «null|numeric-bool»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_poll", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_dice(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_send_dice(
        //    bot «string»,
        //    chat_id «string»,
        //    emoji? «null|string»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_send_dice", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_send_dice(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_send_dice(bot «string», chat_id «string», action «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_send_chat_action", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_forward_message(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_forward_message(
        //    bot «string»,
        //    chat_id «string»,
        //    from_chat_id «string»,
        //    disable_notification? «null|numeric-bool»,
        //    message_id «numeric-int»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_forward_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_copy_message(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_copy_message(
        //    bot «string»,
        //    chat_id «string»,
        //    from_chat_id «string»,
        //    message_id «numeric-int»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_notification? «null|numeric-bool»,
        //    reply_to_message_id? «null|numeric-int»,
        //    allow_sending_without_reply? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_copy_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_edit_message_live_location(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_edit_message_live_location(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|string»,
        //    latitude «numeric-float»,
        //    latitude «numeric-float»,
        //    horizontal_accuracy? «null|numeric-float»,
        //    live_period? «null|numeric-int»,
        //    proximity_alert_radius? «null|numeric-int»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_edit_message_live_location", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_stop_message_live_location(bot «string», parameters_map «map») => message «telegram_message»
        //
        // telegram_stop_message_live_location(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|string»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => message «telegram_message»
        expr.addLazyFunction("telegram_stop_message_live_location", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_answer_callback_query(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_answer_callback_query(
        //    bot «string»,
        //    callback_query_id «string»,
        //    text? «null|string»,
        //    show_alert? «null|numeric-bool»,
        //    url? «null|string»,
        //    cache_time? «null|numeric-int»,
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_answer_callback_query", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_edit_message_text(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_edit_message_text(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|numeric-int»,
        //    text «string»,
        //    parse_mode? «null|string»,
        //    entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    disable_web_page_preview? «null|numeric-bool»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_edit_message_text", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_edit_message_caption(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_edit_message_caption(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|numeric-int»,
        //    caption? «null|string»,
        //    parse_mode? «null|string»,
        //    caption_entities? «null|l(telegram_message_entity)|telegram_message_entity»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_edit_message_caption", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_edit_message_media(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_edit_message_media(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|numeric-int»,
        //    media «telegram_input_media»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_edit_message_media", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_edit_message_reply_markup(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_edit_message_reply_markup(
        //    bot «string»,
        //    chat_id? «null|string»,
        //    message_id? «null|numeric-int»,
        //    inline_message_id? «null|numeric-int»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => true|false «numeric-bool»
        expr.addLazyFunction("telegram_edit_message_reply_markup", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_stop_poll(bot «string», parameters_map «map») => poll «telegram_poll»
        //
        // telegram_stop_poll(
        //    bot «string»,
        //    chat_id «string»,
        //    message_id? «numeric-int»,
        //    reply_markup? «null|telegram_inline_keyboard_markup|telegram_reply_keyboard_markup|telegram_reply_keyboard_remove|telegram_force_reply»
        // ) => poll «telegram_poll»
        expr.addLazyFunction("telegram_stop_poll", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_delete_message(bot «string», parameters_map «map») => true|false «numeric-bool»
        //
        // telegram_delete_message(bot «string», chat_id «string», message_id «numeric-int») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_delete_message", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });
    }
}
