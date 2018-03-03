package de.Mediathek.Artikel;

public class CD extends Artikel {
    private String interpret;

    public CD(String bezeichnung, double preis, int erscheinungsjahr, String interpret) {
        super(bezeichnung, preis, erscheinungsjahr);
        setInterpret(interpret);
    }
    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }
}
