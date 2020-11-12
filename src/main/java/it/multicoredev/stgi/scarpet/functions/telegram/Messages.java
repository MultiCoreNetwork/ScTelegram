package it.multicoredev.stgi.scarpet.functions.telegram;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.Collections;
import java.util.List;

import carpet.script.Expression;
import carpet.script.exception.InternalExpressionException;
import carpet.script.value.ListValue;
import carpet.script.value.NBTSerializableValue;
import carpet.script.value.NullValue;
import carpet.script.value.NumericValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.ScTelegram;

import static it.multicoredev.stgi.scarpet.functions.Util.get;
import static it.multicoredev.stgi.scarpet.functions.Util.has;
import static it.multicoredev.stgi.scarpet.functions.Util.isTAGCompound;
import static it.multicoredev.stgi.scarpet.functions.Util.isTAGList;
import static it.multicoredev.stgi.scarpet.functions.Util.toNumeric;
import static java.util.stream.Collectors.toList;

public class Messages {
    public static void apply(Expression expr) {
        // telegram_send_message(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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
        expr.addLazyFunction("telegram_send_message", -1, (c, t, lv) -> {
            if (lv.size() < 2)
                throw new InternalExpressionException("'telegram_set_my_commands' requires at least two parameters");
            if (lv.size() > 10)
                throw new InternalExpressionException("'telegram_set_my_commands' requires at most ten parameters");
            List<Value> params = lv.stream().map(a -> a.evalValue(c)).collect(toList());
            String botName = params.get(0).getString();
            TelegramBot telegramBot = ScTelegram.telegramBots.get(botName);
            if (telegramBot == null)
                throw new InternalExpressionException("Invalid bot name: " + botName);

            SendMessage sendMessage;
            if (params.size() == 2) {
                if (isTAGCompound(params.get(1))) {
                    NBTSerializableValue param_nbt = (NBTSerializableValue) params.get(1);
                    if (!has(param_nbt, "chat_id"))
                        throw new InternalExpressionException("Missing 'chat_id' value in 'parmeters_nbt'");
                    if (!has(param_nbt, "text"))
                        throw new InternalExpressionException("Missing 'text' value in 'parmeters_nbt'");
                    sendMessage = new SendMessage(get(param_nbt, "chat_id").getString(), get(param_nbt, "text").getString());

                    // parameter 'parse_mode'
                    if (has(param_nbt, "parse_mode"))
                        try {
                            sendMessage.parseMode(ParseMode.valueOf(get(param_nbt, "parse_mode").getString()));
                        } catch (IllegalArgumentException e) {
                            throw new InternalExpressionException("Invalid 'parse_mode' value in 'parmeters_nbt'");
                        }

                    // parameter 'entities'
                    if (has(param_nbt, "entities")) {
                        Value entitiesValue = get(param_nbt, "entities");
                        String entitiesJson;
                        if (entitiesValue instanceof ListValue) {
                            entitiesJson = new Gson().toJson(entitiesValue);
                        } else if (isTAGList(entitiesValue)) {
                            entitiesJson = new Gson().toJson(entitiesValue);
                        } else {
                            ListValue botCommands = new ListValue(Collections.singletonList(entitiesValue));
                            entitiesJson = new Gson().toJson(botCommands);
                        }

                        try {
                            sendMessage.entities(new Gson().fromJson(entitiesJson, MessageEntity[].class));
                        } catch (JsonParseException e) {
                            throw new InternalExpressionException("Invalid 'entities' value in 'parmeters_nbt'");
                        }
                    }

                    // parameter 'disable_web_page_preview'
                    if (has(param_nbt, "disable_web_page_preview"))
                        sendMessage.disableWebPagePreview(get(param_nbt, "disable_web_page_preview").getBoolean());

                    // parameter 'disable_notification'
                    if (has(param_nbt, "disable_notification"))
                        sendMessage.disableNotification(get(param_nbt, "disable_notification").getBoolean());

                    // parameter 'reply_to_message_id'
                    if (has(param_nbt, "reply_to_message_id")) {
                        NumericValue replyToMessageId = toNumeric(get(param_nbt, "reply_to_message_id"));
                        if (replyToMessageId != null)
                            sendMessage.replyToMessageId(replyToMessageId.getInt());
                        else
                            throw new InternalExpressionException("Invalid 'reply_to_message_id' value in 'parmeters_nbt'");
                    }

                    // parameter 'allow_sending_without_reply'
                    if (has(param_nbt, "allow_sending_without_reply"))
                        sendMessage.allowSendingWithoutReply(get(param_nbt, "allow_sending_without_reply").getBoolean());

                    // parameter 'reply_markup'
                    if (has(param_nbt, "reply_markup")) {
                        Value replyMarkupValue = get(param_nbt, "reply_markup");
                        if (isTAGCompound(replyMarkupValue)) {
                            String replyMarkupJson = new Gson().toJson(replyMarkupValue);

                            try {
                                sendMessage.replyMarkup(new Gson().fromJson(replyMarkupJson, Keyboard.class));
                            } catch (JsonParseException e) {
                                throw new InternalExpressionException("Invalid 'reply_markup' value in 'parmeters_nbt'");
                            }
                        } else
                            throw new InternalExpressionException("Invalid 'reply_markup' value in 'parmeters_nbt'");
                    }
                } else {
                    throw new InternalExpressionException("'telegram_set_my_commands' requires at least three parameters if the second one is not an 'nbt'");
                }
            } else {
                sendMessage = new SendMessage(params.get(1).getString(), params.get(2).getString());

                // parameter 'parse_mode'
                if (params.size() > 3 && !(params.get(3) instanceof NullValue))
                    try {
                        sendMessage.parseMode(ParseMode.valueOf(params.get(3).getString()));
                    } catch (IllegalArgumentException e) {
                        throw new InternalExpressionException("Invalid 'parse_mode' parameter value");
                    }

                // parameter 'entities'
                if (params.size() > 4 && !(params.get(4) instanceof NullValue)) {
                    Value entitiesValue = params.get(4);
                    String entitiesJson;
                    if (entitiesValue instanceof ListValue) {
                        entitiesJson = new Gson().toJson(entitiesValue);
                    } else if (isTAGList(entitiesValue)) {
                        entitiesJson = new Gson().toJson(entitiesValue);
                    } else {
                        ListValue botCommands = new ListValue(Collections.singletonList(entitiesValue));
                        entitiesJson = new Gson().toJson(botCommands);
                    }

                    try {
                        sendMessage.entities(new Gson().fromJson(entitiesJson, MessageEntity[].class));
                    } catch (JsonParseException e) {
                        throw new InternalExpressionException("Invalid 'entities' parameter value");
                    }
                }

                // parameter 'disable_web_page_preview'
                if (params.size() > 5 && !(params.get(5) instanceof NullValue))
                    sendMessage.disableWebPagePreview(params.get(5).getBoolean());

                // parameter 'disable_notification'
                if (params.size() > 6 && !(params.get(6) instanceof NullValue))
                    sendMessage.disableNotification(params.get(6).getBoolean());

                // parameter 'reply_to_message_id'
                if (params.size() > 7 && !(params.get(7) instanceof NullValue)) {
                    NumericValue replyToMessageId = toNumeric(params.get(7));
                    if (replyToMessageId != null)
                        sendMessage.replyToMessageId(replyToMessageId.getInt());
                    else
                        throw new InternalExpressionException("Invalid 'reply_to_message_id' parameter value");
                }

                // parameter 'allow_sending_without_reply'
                if (params.size() > 8 && !(params.get(8) instanceof NullValue))
                    sendMessage.allowSendingWithoutReply(params.get(8).getBoolean());

                // parameter 'reply_markup'
                if (params.size() > 9 && !(params.get(9) instanceof NullValue)) {
                    Value replyMarkupValue = params.get(9);
                    if (isTAGCompound(replyMarkupValue)) {
                        String replyMarkupJson = new Gson().toJson(replyMarkupValue);

                        try {
                            sendMessage.replyMarkup(new Gson().fromJson(replyMarkupJson, Keyboard.class));
                        } catch (JsonParseException e) {
                            throw new InternalExpressionException("Invalid 'reply_markup' parameter value");
                        }
                    } else
                        throw new InternalExpressionException("Invalid 'reply_markup' parameter value");
                }
            }

            SendResponse response = telegramBot.execute(sendMessage);
            if (response.isOk())
                return (_c, _t) -> new NBTSerializableValue(new Gson().toJson(response.message()));
            else return (_c, _t) -> Value.NULL;
        });

        // telegram_send_photo(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_audio(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_document(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_video(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_animation(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_voice(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_video_note(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_media_group(bot «string», parmeters_nbt «nbt») => messages «l(telegram_message)»
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

        // telegram_send_location(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_venue(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_contact(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_poll(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_dice(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_send_dice(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
        //
        // telegram_send_dice(bot «string», chat_id «string», action «string») => true|false «numeric-bool»
        expr.addLazyFunction("telegram_send_chat_action", -1, (c, t, lv) -> {
            //TODO Funktion implementieren
            return (cc, tt) -> {
                return Value.NULL;
            };
        });

        // telegram_forward_message(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_copy_message(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_edit_message_live_location(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_stop_message_live_location(bot «string», parmeters_nbt «nbt») => message «telegram_message»
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

        // telegram_answer_callback_query(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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

        // telegram_edit_message_text(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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

        // telegram_edit_message_caption(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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

        // telegram_edit_message_media(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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

        // telegram_edit_message_reply_markup(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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

        // telegram_stop_poll(bot «string», parmeters_nbt «nbt») => poll «telegram_poll»
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

        // telegram_delete_message(bot «string», parmeters_nbt «nbt») => true|false «numeric-bool»
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
