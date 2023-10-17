function ValidateAddFormNote() {
    var max = 2800;
    var count = CountCharacters();
    if (count > max) {
        alert("Введено максимальное количество символов (" + max + ")")
        return false;
    }

    if (document.addNoteForm.typeOfNote.selectedIndex == 0 ) {
        alert ( "Пожалуйста, выберите тип создаваемой заметки." );
        return false;
    }

    return;
}
