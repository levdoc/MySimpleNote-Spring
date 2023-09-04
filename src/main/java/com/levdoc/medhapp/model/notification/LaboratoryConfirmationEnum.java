package com.levdoc.medhapp.model.notification;

public enum LaboratoryConfirmationEnum {

    DEFAULT (""),
    YES ("Да"),
    NO ("Нет");

    private final String LaboratoryConfirmation;

    LaboratoryConfirmationEnum(String LaboratoryConfirmation) {
        this.LaboratoryConfirmation = LaboratoryConfirmation;
    }

    public String getLaboratoryConfirmation() {
        return this.LaboratoryConfirmation;
    }
}
