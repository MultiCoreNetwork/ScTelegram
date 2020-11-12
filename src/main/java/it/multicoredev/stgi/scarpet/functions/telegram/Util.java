package it.multicoredev.stgi.scarpet.functions.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import java.util.List;

import carpet.script.value.NumericValue;
import carpet.script.value.Value;

public class Util {
    public static <T> T to(Value value, Class<T> toClass) {
        try {
            System.out.println(value.toJson().toString());
            return new ObjectMapper().readValue(value.toJson().toString(), toClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> List<T> toList(Value value, Class<T> toClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(value.toJson().toString(), mapper.getTypeFactory().constructCollectionType(List.class, toClass));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T,X extends Value> T get(List<Value> parameters, int index, Class<T> toClass, Class<X> fromClass){
        Value parameter = (X)parameters.get(index);
        if(parameter.isNull()) return null;
        if(toClass == String.class) return (T) parameter.getString();
        if(toClass == Integer.class) return (T) new Integer(NumericValue.asNumber(parameter).getInt());
        if(toClass == Boolean.class) return (T) new Boolean(parameter.getBoolean());
        if(parameter.getTypeString().equals("sctelegram_inline_keyboard_markup"))
            return (T) to(parameter, InlineKeyboardMarkup.class);
        if(parameter.getTypeString().equals("sctelegram_reply_keyboard_markup"))
            return (T) to(parameter, ReplyKeyboardMarkup.class);
        if(parameter.getTypeString().equals("sctelegram_reply_keyboard_remove"))
            return (T) to(parameter, ReplyKeyboardRemove.class);
        if(parameter.getTypeString().equals("sctelegram_force_reply"))
            return (T) to(parameter, ForceReplyKeyboard.class);
        return to(parameter,toClass);
    }
    /*public static <T> List<T> getList(List<Value> parameters, int index, Class<T> toClass){
        Value parameter = parameters.get(index);
        if(parameter.isNull()) return null;
        return toList(parameter,toClass);
    }*/
}
