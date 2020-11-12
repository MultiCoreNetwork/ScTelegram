package it.multicoredev.stgi.scarpet.values;

import net.minecraft.entity.Entity;

import carpet.script.value.EntityValue;
import carpet.script.value.NullValue;
import carpet.script.value.NumericValue;
import carpet.script.value.StringValue;
import carpet.script.value.Value;

public class NullableValue {
    public static Value string(String arg) {
        if (arg != null) return new StringValue(arg);
        return new NullValue();
    }

    public static Value numeric(Double arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Integer arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Boolean arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value numeric(Long arg) {
        if (arg != null) return new NumericValue(arg);
        return new NullValue();
    }

    public static Value entity(Entity arg) {
        if (arg != null) return new EntityValue(arg);
        return new NullValue();
    }
}