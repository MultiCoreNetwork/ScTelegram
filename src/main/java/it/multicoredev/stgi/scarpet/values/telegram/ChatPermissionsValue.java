package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ChatPermissions;

import java.util.Arrays;
import java.util.List;

import carpet.script.value.StringValue;
import it.multicoredev.stgi.scarpet.values.NullableValue;

public class ChatPermissionsValue extends ScTelegramValue {
    public ChatPermissionsValue(ChatPermissions chatPermissions) {
        super(Arrays.asList(
                new StringValue("can_send_messages"),         NullableValue.numeric(chatPermissions.getCanSendMessages()),
                new StringValue("can_send_media_messages"),   NullableValue.numeric(chatPermissions.getGetCanSendMediaMessages()),
                new StringValue("can_send_polls"),            NullableValue.numeric(chatPermissions.getCanSendPolls()),
                new StringValue("can_send_other_messages"),   NullableValue.numeric(chatPermissions.getCanSendOtherMessages()),
                new StringValue("can_add_web_page_previews"), NullableValue.numeric(chatPermissions.getCanAddWebPagePreviews()),
                new StringValue("can_change_info"),           NullableValue.numeric(chatPermissions.getCanChangeInfo()),
                new StringValue("can_invite_users"),          NullableValue.numeric(chatPermissions.getCanInviteUsers()),
                new StringValue("can_pin_messages"),          NullableValue.numeric(chatPermissions.getCanPinMessages())
        ));
    }

    @Override
    public String getTypeString() {
        return "telegram_chat_permissions";
    }

    @Override
    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Arrays.asList(
            "can_send_messages",
            "can_send_media_messages",
            "can_send_polls",
            "can_send_other_messages",
            "can_add_web_page_previews",
            "can_change_info",
            "can_invite_users",
            "can_pin_messages"
    );
}
