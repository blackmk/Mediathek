package com.Mediathek.Artikel;

import java.util.Date;

public class Buch extends Artikel
{
	private String verlag;
	public Buch(String bezeichnung, double preis, Date erscheinungsjahr, Date ausleihdatum, String verlag)
	{
		super(bezeichnung,preis,erscheinungsjahr, ausleihdatum,Type.Buch);
		setVerlag(verlag);
	}
	@SuppressWarnings("unused")
	public String getVerlag()
	{
		return verlag;
	}
	private void setVerlag(String verlag)
	{
		this.verlag = verlag;
	}
}
