package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class MessageValue extends ScTelegramValue {
    public MessageValue(Message message) {
        super(Arrays.asList(
                new StringValue("message_id"),                new NumericValue(message.getMessageId()),
                new StringValue("from"),                      NullableValue.user(message.getFrom()),
                new StringValue("sender_chat"),               NullableValue.chat(message.getSenderChat()),
                new StringValue("date"),                      new NumericValue(message.getDate()),
                new StringValue("chat"),                      new ChatValue(message.getChat()),
                new StringValue("forward_from"),              NullableValue.user(message.getForwardFrom()),
                new StringValue("forward_from_chat"),         NullableValue.chat(message.getForwardFromChat()),
                new StringValue("forward_from_message_id"),   NullableValue.numeric(message.getForwardFromMessageId()),
                new StringValue("forward_signature"),         NullableValue.string(message.getForwardSignature()),
                new StringValue("forward_sender_name"),       NullableValue.string(message.getForwardSenderName()),
                new StringValue("forward_date"),              NullableValue.numeric(message.getForwardDate()),
                new StringValue("reply_to_message"),          NullableValue.message(message.getReplyToMessage()),
                new StringValue("via_bot"),                   NullableValue.user(message.getViaBot()),
                new StringValue("edit_date"),                 NullableValue.numeric(message.getEditDate()),
                new StringValue("media_group_id"),            NullableValue.string(message.getMediaGroupId()),
                new StringValue("author_signature"),          NullableValue.string(message.getAuthorSignature()),
                new StringValue("text"),                      NullableValue.string(message.getText()),
                new StringValue("entities"),                  NullableValue.messageEntitylist(message.getEntities()),
                new StringValue("animation"),                 NullableValue.animation(message.getAnimation()),
                new StringValue("audio"),                     NullableValue.audio(message.getAudio()),
                new StringValue("document"),                  NullableValue.document(message.getDocument()),
                new StringValue("photo"),                     NullableValue.photoSizeList(message.getPhoto()),
                new StringValue("sticker"),                   NullableValue.sticker(message.getSticker()),
                new StringValue("video"),                     NullableValue.video(message.getVideo()),
                new StringValue("video_note"),                NullableValue.videoNote(message.getVideoNote()),
                new StringValue("voice"),                     NullableValue.voice(message.getVoice()),
                new StringValue("caption"),                   NullableValue.string(message.getCaption()),
                new StringValue("caption_entities"),          NullableValue.messageEntitylist(message.getCaptionEntities()),
                new StringValue("contact"),                   NullableValue.contact(message.getContact()),
                new StringValue("dice"),                      NullableValue.dice(message.getDice()),
                new StringValue("game"),                      NullableValue.game(message.getGame()),
                new StringValue("poll"),                      NullableValue.poll(message.getPoll()),
                new StringValue("venue"),                     NullableValue.venue(message.getVenue()),
                new StringValue("location"),                  NullableValue.location(message.getLocation()),
                new StringValue("new_chat_members"),          NullableValue.userList(message.getNewChatMembers()),
                new StringValue("left_chat_member"),          NullableValue.user(message.getLeftChatMember()),
                new StringValue("new_chat_title"),            NullableValue.string(message.getNewChatTitle()),
                new StringValue("new_chat_photo"),            NullableValue.photoSizeList(message.getNewChatPhoto()),
                new StringValue("delete_chat_photo"),         NullableValue.numeric(message.getDeleteChatPhoto()),
                new StringValue("group_chat_created"),        NullableValue.numeric(message.getGroupchatCreated()),
                new StringValue("supergroup_chat_created"),   NullableValue.numeric(message.getSuperGroupCreated()),
                new StringValue("channel_chat_created"),      NullableValue.numeric(message.getChannelChatCreated()),
                new StringValue("migrate_to_chat_id"),        NullableValue.numeric(message.getMigrateToChatId()),
                new StringValue("migrate_from_chat_id"),      NullableValue.numeric(message.getMigrateFromChatId()),
                new StringValue("pinned_message"),            NullableValue.message(message.getPinnedMessage()),
                new StringValue("invoice"),                   NullableValue.invoice(message.getInvoice()),
                new StringValue("successful_payment"),        NullableValue.successfulPayment(message.getSuccessfulPayment()),
                new StringValue("connected_website"),         NullableValue.string(message.getConnectedWebsite()),
                new StringValue("passport_data"),             NullableValue.passportData(message.getPassportData()),
                new StringValue("proximity_alert_triggered"), NullableValue.proximityAllertTriggered(message.getProximityAlertTriggered()),
                new StringValue("reply_markup"),              NullableValue.inlineKeyboardMarkup(message.getReplyMarkup())
        ));
    }

    @Override
    public String getTypeString() {
        return "telegram_message";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "delete_chat_photo",
            "group_chat_created",
            "supergroup_chat_created",
            "channel_chat_created"
    );
}
