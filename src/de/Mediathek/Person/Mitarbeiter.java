package de.Mediathek.Person;

public class Mitarbeiter extends Person {
    private String benutzername;
    private String passwort;

    public Mitarbeiter(String name, String ort, int plz, String strasse, String hausnummer, String benutzername, String passwort) {
        super(name, ort, plz, strasse, hausnummer);
        setBenutzername(benutzername);
        setPasswort(passwort);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
