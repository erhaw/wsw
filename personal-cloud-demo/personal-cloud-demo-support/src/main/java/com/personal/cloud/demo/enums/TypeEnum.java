package com.personal.cloud.demo.enums;

/**
 * Created by Administrator on 2019-09-17.
 */
public enum TypeEnum {

    STUDENT("1","学生"),
    OTHER("2","其他");


    private String key;
    private String value;

    TypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TypeEnum getEnumByKey(String key) {
        if (null == key) {
            return null;
        }
        for (TypeEnum e : TypeEnum.values()) {
            if (e.getKey().equals(key)) {
                return e;
            }
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
