package br.com.alura.literalura.model;

public enum Idioma {

    PT("pt", "Português"),
    EN("en", "Inglês"),
    ES("es", "Espanhol"),
    FR("fr", "Francês"),
    DE("de", "Alemão"),
    IT("it", "Italiano"),
    NL("nl", "Holandês"),
    EO("eo", "Esperanto"),
    RU("ru", "Russo"),
    JA("ja", "Japonês"),
    KO("ko", "Coreano"),
    CH("ch", "Chinês"),
    AR("ar", "Arábico"),
    HI("hi", "Hindi"),
    UR("ur", "Urdu"),
    FA("fa", "Persa"),
    GU("gu", "Gujarárati"),
    KN("kn", "Canarinho"),
    ML("ml", "Malaiala"),
    OR("or", "Oriya"),
    TE("te", "Telugu"),
    TA("ta", "Tâmil");

    private String idioma;

    private String idiomaPortugues;

    Idioma(String idioma, String idiomaPortugues) {
        this.idioma = idioma;
        this.idiomaPortugues = idiomaPortugues;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getIdiomaPortugues() {
        return idiomaPortugues;
    }

    public void setIdiomaPortugues(String idiomaPortugues) {
        this.idiomaPortugues = idiomaPortugues;
    }

    public static Idioma fromString(String text) {
        for (Idioma idiomas : Idioma.values()) {
            if (idiomas.idioma.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }

        throw new IllegalArgumentException("Nenhum idioma encontrado para string fornecida " + text);
    }

    public static Idioma fromPortugues(String text) {
        for (Idioma idiomas : Idioma.values()) {
            if (idiomas.idiomaPortugues.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }

        throw new IllegalArgumentException("Nenhum idioma encontrado para string fornecida " + text);
    }
}
