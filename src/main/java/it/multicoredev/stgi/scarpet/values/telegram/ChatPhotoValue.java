package it.multicoredev.stgi.scarpet.values.telegram;

import org.telegram.telegrambots.meta.api.objects.ChatPhoto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import carpet.script.value.MapValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;


public class ChatPhotoValue extends MapValue {
    public ChatPhotoValue(ChatPhoto chatPhoto) {
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
        return "sctelegram_chatphoto";
    }
}
