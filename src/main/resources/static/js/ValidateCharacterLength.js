function ValidateCharacterLength() {
    var max = 2800;
    var count = CountCharacters();
    if (count > max) {
        alert("Введено максимальное количество символов (" + max + ")")
        return false;
    }
    return;
}
