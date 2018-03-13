package de.Mediathek.Person;

public class Kunde extends Person {
    private int knr;
    private static int c=0;
    public Kunde(String name, String ort, int plz, String strasse, String hausnummer) {
        super(name, ort, plz, strasse, hausnummer);
        setKnr(++c);
    }

    public void setKnr(int knr) {
        this.knr = knr;
    }
    public int getKnr() {
        return knr;
    }
}
