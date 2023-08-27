package com.levdoc.medhapp.model.simplenote;

public enum TypeOfNote {

    MEDICAL_HISTORY("Фрагмент истории болезни"),
    DRUGS_INFO("Информация о лекарствах"),
    OTHER ("Прочее");


    private final String typeOfNoteTextDisplay;

    TypeOfNote(String text) {
        this.typeOfNoteTextDisplay = text;
    }

    public String getTypeOfNoteTextDisplay() {
        return this.typeOfNoteTextDisplay;
    }

}
