package it.multicoredev.stgi.scarpet.values.telegram.parameters;


import it.multicoredev.stgi.scarpet.values.telegram.ScTelegramValue;

public class ScTelegramParameter {
    private String key;
    private boolean required;
    private boolean list;
    private boolean bool;
    private Class<?> classType;

    public ScTelegramParameter(String key, Class<?> classType, boolean required, boolean list, boolean bool) {
        this.key = key;
        this.classType = classType;
        this.required = required;
        this.list = list;
        this.bool = bool;
    }

    public ScTelegramParameter(String key, Class<?> classType) {
        this(key, classType, true, false, false);
    }

    public ScTelegramParameter list(){
        list = true;
        return this;
    }

    public ScTelegramParameter optional(){
        required = false;
        return this;
    }

    public ScTelegramParameter bool(){
        bool = false;
        return this;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isList() {
        return list;
    }

    public Class<?> getClassType() {
        return classType;
    }

    public String getKey() {
        return key;
    }

    public boolean isBoolean() {
        return bool;
    }
}
