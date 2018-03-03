package de.Mediathek.Artikel;

import java.util.Date;

public class Artikel {
    protected String bezeichnung;
    protected double preis;
    protected int erscheinungsjahr;
    protected Date ausleihdatum;
    protected boolean status;


    public Artikel(String bezeichnung, double preis, int erscheinungsjahr) {
        setBezeichnung(bezeichnung);
        setPreis(preis);
        setErscheinungsjahr(erscheinungsjahr);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public Date getAusleihdatum() {
        return ausleihdatum;
    }

    public void setAusleihdatum(Date ausleihdatum) {
        this.ausleihdatum = ausleihdatum;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
