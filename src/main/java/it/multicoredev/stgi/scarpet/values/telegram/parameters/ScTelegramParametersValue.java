package it.multicoredev.stgi.scarpet.values.telegram.parameters;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import carpet.script.value.ListValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;
import it.multicoredev.stgi.scarpet.values.telegram.ScTelegramValue;

import static java.util.stream.Collectors.toList;


public class ScTelegramParametersValue extends ScTelegramValue {
    public ScTelegramParametersValue(List<Value> values) {
        super(values);
    }
    public ScTelegramParametersValue() { super(Collections.emptyList()); }

    public ScTelegramParametersValue from(List<Value> parameters){
        List<Class<? extends Value>> types = getParametersTypes();
        List<String> keys = getParametersKeys();
        List<String> lists = getListKeys();

        for(int i = 0; i < parameters.size(); i++){
            String key = keys.get(i);
            Class<? extends Value> type = types.get(i);
            if(lists.contains(key) && parameters.get(i) instanceof ListValue){
                ListValue listParameter = (ListValue) parameters.get(i);
                List<Value> castedParameter = listParameter.getItems().stream().map(p -> type.cast(p)).collect(toList());
                put(new ListValue(Arrays.asList(new StringValue(key), new ListValue(castedParameter))));
            } else
                put(new ListValue(Arrays.asList(new StringValue(key), type.cast(parameters.get(i)))));
        }
        return this;
    }

    public List<String> getParametersKeys() {
        return getParametersList().stream().map(p -> p.getKey()).collect(toList());
    }

    public List<Class<? extends Value>> getParametersTypes() {
        return getParametersList().stream().map(p -> (Class<? extends Value>)p.getClassType()).collect(toList());
    }

    public List<String> getListKeys() {
        return getParametersList().stream().filter(p -> p.isList()).map(p -> p.getKey()).collect(toList());
    }

    @Override
    public List<String> getBooleanKeys() {
        return getParametersList().stream().filter(p -> p.isBoolean()).map(p -> p.getKey()).collect(toList());
    }

    public List<ScTelegramParameter> getParametersList() { return Collections.emptyList(); }
}
