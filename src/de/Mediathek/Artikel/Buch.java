package de.Mediathek.Artikel;

public class Buch extends Artikel {
    private String verlag;

    public Buch(String bezeichnung, double preis, int erscheinungsjahr, String verlag) {
        super(bezeichnung, preis, erscheinungsjahr);
        setVerlag(verlag);
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }
}
