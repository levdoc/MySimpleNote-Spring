package com.levdoc.medhapp.model.notification;

public enum SexEnum {

    MALE ("Мужской"),
    FEMALE ("Женский");

    private final String sex;

    SexEnum(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }
}
