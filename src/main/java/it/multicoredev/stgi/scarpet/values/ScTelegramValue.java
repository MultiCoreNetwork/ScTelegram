package it.multicoredev.stgi.scarpet.values;

import java.util.ArrayList;
import java.util.Arrays;
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
            pairList.add(new ListValue(Arrays.asList(values.get(i), i < values.size()-1 ? values.get(i+1) : new NullValue())));
        }
        return pairList;
    }
}
