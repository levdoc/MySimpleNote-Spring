function CountCharacters() {
    var body = tinymce.get("mainText").getBody();
    var content = tinymce.trim(body.innerText || body.textContent);
    return content.length;
}
