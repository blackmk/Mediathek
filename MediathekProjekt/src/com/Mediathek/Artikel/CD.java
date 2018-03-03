package com.Mediathek.Artikel;

import java.util.Date;

public class CD extends Artikel
{
	private String interpret;
	
	public CD(String bezeichnung, double preis, Date erscheinungsjahr, Date ausleihdatum, String interpret)
	{
		super(bezeichnung,preis,erscheinungsjahr,ausleihdatum,Type.CD);
		setInterpret(interpret);
	}
	@SuppressWarnings("unused")
	public String getInterpret()
	{
		return interpret;
	}

	private void setInterpret(String interpret)
	{
		this.interpret = interpret;
	}
}
