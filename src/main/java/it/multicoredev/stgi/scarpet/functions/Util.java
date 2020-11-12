package it.multicoredev.stgi.scarpet.functions;

import carpet.script.value.NBTSerializableValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;

public class Util {
    public static boolean has(NBTSerializableValue parameters_map, String key){
        return parameters_map.has(new StringValue(key));
    }
    public static Value get(NBTSerializableValue parameters_map, String key){
        return parameters_map.get(new StringValue(key));
    }
    public static boolean isTAGList(Value value){
        return value instanceof NBTSerializableValue && ((NBTSerializableValue) value).getTag().getType() == 9;
    }
    public static boolean isTAGCompound(Value value){
        return value instanceof NBTSerializableValue && ((NBTSerializableValue) value).getTag().getType() == 10;
    }
    public static NumericValue toNumeric(Value value){
        if (value instanceof NumericValue){
            return (NumericValue)value;
        }
        try {
            return new NumericValue(value.getString());
        } catch (NumberFormatException format) {
            return null;
        }
    }

}
