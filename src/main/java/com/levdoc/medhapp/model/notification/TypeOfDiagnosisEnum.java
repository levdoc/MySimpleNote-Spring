package com.levdoc.medhapp.model.notification;

public enum TypeOfDiagnosisEnum {

    PROVISIONAL_DIAGNOSIS ("Предварительный"),
    FINAL_DIAGNOSIS ("Окончательный");

    private final String typeOfDiagnosis;

    TypeOfDiagnosisEnum(String typeOfDiagnosis) {
        this.typeOfDiagnosis = typeOfDiagnosis;
    }

    public String getTypeOfDiagnosis() {
        return this.typeOfDiagnosis;
    }
}
