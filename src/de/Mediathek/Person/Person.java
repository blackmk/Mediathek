package de.Mediathek.Person;

public class Person {
    protected String name;
    protected String ort;
    protected int plz;
    protected String strasse;
    protected String hausnummer;

    public Person(String name, String ort, int plz, String strasse, String hausnummer) {
        setName(name);
        setOrt(ort);
        setStrasse(strasse);
        setHausnummer(hausnummer);
        setPlz(plz);
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }
}
