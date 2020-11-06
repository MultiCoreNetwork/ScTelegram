package it.multicoredev.stgi.scarpet.values;

import carpet.script.value.*;
import net.minecraft.entity.Entity;
import org.telegram.telegrambots.meta.api.objects.ChatLocation;
import org.telegram.telegrambots.meta.api.objects.ChatPermissions;
import org.telegram.telegrambots.meta.api.objects.ChatPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

import it.multicoredev.stgi.scarpet.values.telegram.ChatLocationValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatPermissionsValue;
import it.multicoredev.stgi.scarpet.values.telegram.ChatPhotoValue;
import it.multicoredev.stgi.scarpet.values.telegram.MessageValue;

public class NullableValue {
    public static Value string(String arg){
        if(arg != null) return new StringValue(arg);
        return new NullValue();
    }
    public static Value numeric(String arg){
        if(arg != null) return new NumericValue(arg);
        return new NullValue();
    }
    public static Value numeric(Double arg){
        if(arg != null) return new NumericValue(arg);
        return new NullValue();
    }
    public static Value numeric(Integer arg){
        if(arg != null) return new NumericValue(arg);
        return new NullValue();
    }
    public static Value numeric(Boolean arg){
        if(arg != null) return new NumericValue(arg);
        return new NullValue();
    }
    public static Value numeric(Long arg){
        if(arg != null) return new NumericValue(arg);
        return new NullValue();
    }
    public static Value entity(Entity arg){
        if(arg != null) return new EntityValue(arg);
        return new NullValue();
    }

    // TELEGRAM //
    public static Value chatPhoto(ChatPhoto arg){
        if(arg != null) return new ChatPhotoValue(arg);
        return new NullValue();
    }
    public static Value message(Message arg){
        if(arg != null) return new MessageValue(arg);
        return new NullValue();
    }
    public static Value chatPermissions(ChatPermissions arg){
        if(arg != null) return new ChatPermissionsValue(arg);
        return new NullValue();
    }
    public static Value chatLocation(ChatLocation arg){
        if(arg != null) return new ChatLocationValue(arg);
        return new NullValue();
    }

}
