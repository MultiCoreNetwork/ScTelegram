package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ChatPhoto;

import java.util.Arrays;

import carpet.script.value.StringValue;

public class UserProfilePhotosValue extends ScTelegramValue {
    public UserProfilePhotosValue(ChatPhoto chatPhoto) {
        super(Arrays.asList(
                new StringValue("small_file_id"),        new StringValue(chatPhoto.getSmallFileId()),
                new StringValue("small_file_unique_id"), new StringValue(chatPhoto.getSmallFileUniqueId()),
                new StringValue("big_file_id"),          new StringValue(chatPhoto.getBigFileId()),
                new StringValue("big_file_unique_id"),   new StringValue(chatPhoto.getBigFileUniqueId())
        ));
    }

    @Override
    public String getTypeString()
    {
        return "sctelegram_chat_photo";
    }
}
