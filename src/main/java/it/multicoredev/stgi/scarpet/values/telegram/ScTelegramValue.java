package it.multicoredev.stgi.scarpet.values.telegram;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import carpet.script.value.ListValue;
import carpet.script.value.MapValue;
import carpet.script.value.NullValue;
import carpet.script.value.Value;

public class ScTelegramValue extends MapValue {
    public ScTelegramValue(List<Value> values) {
       super(listValueToPairList(values));
    }

    public static List listValueToPairList(List<Value> values){
        List<ListValue> pairList = new ArrayList<>();
        for( int i = 0; i < values.size(); i += 2){
            if(i < values.size()-1 && !(values.get(i+1) instanceof NullValue))
                pairList.add(new ListValue(Arrays.asList(values.get(i), values.get(i+1))));
        }
        return pairList;
    }

    @Override
    public JsonElement toJson(){
        List<String> booleanKeys = getBooleanKeys();
        JsonObject jsonMap = new JsonObject();
        getMap().forEach((k, v) -> {
            if(booleanKeys.contains(k.getString())){
                jsonMap.add(k.getString(), new JsonPrimitive(v.getBoolean()));
            } else {
                jsonMap.add(k.getString(), v.toJson());
            }
        });
        return jsonMap;
    }

    public List<String> getBooleanKeys() { return BOOLEAN_KEYS; }
    public static final List<String> BOOLEAN_KEYS = Collections.emptyList();
}
