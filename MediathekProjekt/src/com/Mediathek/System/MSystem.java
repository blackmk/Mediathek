package com.Mediathek.System;

import com.Mediathek.Artikel.Artikel;
import com.Mediathek.Personen.Kunde;
import com.Mediathek.Personen.Mitarbeiter;

import java.util.LinkedList;

public class MSystem
{
    private Mitarbeiter currentUser;
    private static boolean admin;

    private LinkedList<Mitarbeiter> mitarbeiterListe;
    private LinkedList<Artikel> artikelListe;
    private LinkedList<Kunde> kundenListe;


    public MSystem()
    {
        //noinspection unchecked
        mitarbeiterListe = DateiManager.dateiLaden("Mitarbeiter");
        //noinspection unchecked
        artikelListe = DateiManager.dateiLaden("Artikel");
        //noinspection unchecked
        kundenListe =  DateiManager.dateiLaden("Kunden");
        int tmp = 0;

        for (Artikel anArtikelListe : artikelListe) {
            if (tmp < anArtikelListe.getID())
                tmp = anArtikelListe.getID();
        }
        tmp = 0;
        Kunde.setCounter(tmp);
        for (Kunde anKundenListe : kundenListe) {
            if (tmp < anKundenListe.getKundenNummer())
                tmp = anKundenListe.getKundenNummer();
        }
        Kunde.setCounter(tmp);
        tmp=0;
        for (Mitarbeiter anMitarbeiterListe : mitarbeiterListe) {
            if (tmp < anMitarbeiterListe.getID())
                tmp = anMitarbeiterListe.getID();
        }
        Mitarbeiter.setCounter(tmp);
    }

    public Mitarbeiter getCurrentUser() {
        return currentUser;
    }

    public LinkedList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public LinkedList<Artikel> getArtikelListe() {
        return artikelListe;
    }

    public LinkedList<Kunde> getKundenListe() {
        return kundenListe;
    }

    public boolean anmeldenGUI(String benutzername, String passwort)
    {
        Mitarbeiter tmp;
        tmp = findUser(benutzername);
        if(tmp == null)
            return false;
        if(passwort.equals(tmp.getPasswort()))
        {
            currentUser=tmp;
            if(currentUser.getBenutzername().equals("admin"))
                setAdmin();
            return true;
        }
        return false;
    }


    private Mitarbeiter findUser(String user)
    {
        if(user.equals("admin"))
            return new Mitarbeiter("admin","Gott","127.0.0.1",0x00000000,"x64_x86","0x0","admin","12345");
        else
            for (Mitarbeiter aMitarbeiterListe : mitarbeiterListe) {
                if (aMitarbeiterListe.getBenutzername().equals(user))
                    return aMitarbeiterListe;
            }
        return null;
    }


    public static boolean isAdmin() {
        return admin;
    }

    private static void setAdmin() {
        admin = true;
    }

}
