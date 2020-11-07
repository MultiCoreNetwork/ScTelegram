package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.Chat;

import java.util.Arrays;

import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ChatValue extends ScTelegramValue {
    public ChatValue(Chat chat) {
        super(Arrays.asList(
                new StringValue("id"),                          new NumericValue(chat.getId()),
                new StringValue("type"),                        new StringValue(chat.getType()),
                new StringValue("title"),                       NullableValue.string(chat.getTitle()),
                new StringValue("username"),                    NullableValue.string(chat.getUserName()),
                new StringValue("first_name"),                  NullableValue.string(chat.getFirstName()),
                new StringValue("last_name"),                   NullableValue.string(chat.getLastName()),
                new StringValue("photo"),                       NullableValue.chatPhoto(chat.getPhoto()),
                new StringValue("bio"),                         NullableValue.string(chat.getBio()),
                new StringValue("description"),                 NullableValue.string(chat.getDescription()),
                new StringValue("invite_link"),                 NullableValue.string(chat.getInviteLink()),
                new StringValue("pinned_message"),              NullableValue.message(chat.getPinnedMessage()),
                new StringValue("permissions"),                 NullableValue.chatPermissions(chat.getPermissions()),
                new StringValue("slow_mode_delay"),             NullableValue.numeric(chat.getSlowModeDelay()),
                new StringValue("sticker_set_name"),            NullableValue.string(chat.getStickerSetName()),
                new StringValue("can_set_sticker_set"),         NullableValue.numeric(chat.getCanSetStickerSet()),
                new StringValue("linked_chat_id"),              NullableValue.numeric(chat.getLinkedChatId()),
                new StringValue("location"),                    NullableValue.chatLocation(chat.getLocation())
                //new StringValue("allMembersAreAdministrators"), NullableValue.numeric(chat.getAllMembersAreAdministrators())
        ));
    }
    @Override
    public String getTypeString()
    {
        return "telegram_chat";
    }
}
