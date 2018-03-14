package com.jsfsi.sample.extensibility.enums;

public enum Gender implements BaseEnum<String> {
    // NOTE: Only used to specify an empty Gender
    E("E"),
    M("M"),
    F("F");

    private String value;
    private String empty;

    Gender(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value == null || value.isEmpty() ? empty : this.value;
    }

    public static Gender getEmptyGender(String empty){
        Gender gender = Gender.E;
        gender.empty = empty;
        return gender;
    }
}

