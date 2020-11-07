package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ChatMember;

import java.util.Arrays;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ChatMemberValue extends ScTelegramValue {
    public ChatMemberValue(ChatMember chatMember) {
        super(Arrays.asList(
                new StringValue("user"),                      new UserValue(chatMember.getUser()),
                new StringValue("status"),                    new StringValue(chatMember.getStatus()),
                new StringValue("custom_title"),              NullableValue.string(chatMember.getCustomTitle()),
                new StringValue("is_anonymous"),              NullableValue.numeric(chatMember.getIsAnonymous()),
                new StringValue("can_be_edited"),             NullableValue.numeric(chatMember.getCanBeEdited()),
                new StringValue("can_post_messages"),         NullableValue.numeric(chatMember.getCanPostMessages()),
                new StringValue("can_edit_messages"),         NullableValue.numeric(chatMember.getCanEditMessages()),
                new StringValue("can_delete_messages"),       NullableValue.numeric(chatMember.getCanDeleteMessages()),
                new StringValue("can_restrict_members"),      NullableValue.numeric(chatMember.getCanRestrictMembers()),
                new StringValue("can_promote_members"),       NullableValue.numeric(chatMember.getCanPromoteMembers()),
                new StringValue("can_change_info"),           NullableValue.numeric(chatMember.getCanChangeInformation()),
                new StringValue("can_invite_users"),          NullableValue.numeric(chatMember.getCanInviteUsers()),
                new StringValue("can_pin_messages"),          NullableValue.numeric(chatMember.getCanPinMessages()),
                new StringValue("is_member"),                 NullableValue.numeric(chatMember.getIsMemberField()),
                new StringValue("can_send_messages"),         NullableValue.numeric(chatMember.getCanSendMessages()),
                new StringValue("can_send_media_messages"),   NullableValue.numeric(chatMember.getCanSendMediaMessages()),
                new StringValue("can_send_polls"),            NullableValue.numeric(chatMember.getCanSendPolls()),
                new StringValue("can_send_other_messages"),   NullableValue.numeric(chatMember.getCanSendOtherMessages()),
                new StringValue("can_add_web_page_previews"), NullableValue.numeric(chatMember.getCanAddWebPagePreviews()),
                new StringValue("until_date"),                NullableValue.numeric(chatMember.getUntilDate())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "telegram_chat_member";
    }
}
