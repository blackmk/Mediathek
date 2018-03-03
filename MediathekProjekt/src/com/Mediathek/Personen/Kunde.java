package com.Mediathek.Personen;

import com.Mediathek.Artikel.Artikel;

import java.util.LinkedList;

public class Kunde extends Person
{
	private int kundenNummer;
	private static int counter;
	private LinkedList<Artikel> ausgeliehenListe;

	private int anzahlAusgeliehen;
	public Kunde(String name,String vorname, String ort, int plz, String strasse, String hausnummer)
	{
		super(name,vorname, ort, plz, strasse, hausnummer);
		setKundenNummer(++counter);
		ausgeliehenListe = new LinkedList<>();
	}
	@SuppressWarnings("unused")
	public int getKundenNummer()
	{
		return kundenNummer;
	}

	private void setKundenNummer(int kundenNummer)
	{
		this.kundenNummer = kundenNummer;
	}

	public static void setCounter(int counter) {
		Kunde.counter = counter;
	}
	public LinkedList<Artikel> getAusgeliehenListe() {
		return ausgeliehenListe;
	}
	@SuppressWarnings("unused")
	public int getAnzahlAusgeliehen() {
		return anzahlAusgeliehen;
	}
	@SuppressWarnings("unused")
	public void setAnzahlAusgeliehen(int anzahlAusgeliehen) {
		this.anzahlAusgeliehen = anzahlAusgeliehen;
	}

	@SuppressWarnings("unused")
	public void ausleihen(Artikel a)
	{
		a.setStatus(true);
		ausgeliehenListe.add(a);
	}
	@SuppressWarnings("unused")
	public void zurueckgeben(Artikel a)
	{
		a.setStatus(false);
		ausgeliehenListe.remove(a);
	}

}
