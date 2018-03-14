package com.jsfsi.sample.extensibility.enums;

public class Enums {
    public static <T extends Enum<T>> boolean contains(Class<T> enumType,String value){

        for (T constant : enumType.getEnumConstants()) {
            if(constant.name().equals(value)){
                return true;
            }
        }

        return false;
    }
}
