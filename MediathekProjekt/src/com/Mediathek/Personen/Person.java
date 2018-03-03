package com.Mediathek.Personen;

import java.io.Serializable;

public abstract class Person implements Serializable
{
	private String name;
	private String vorname;
	private String ort;
	private int plz;
	private String strasse;
	private String hausnummer;
	
	Person(String name, String vorname, String ort, int plz, String strasse, String hausnummer)
	{
		setName(name);
		setVorname(vorname);
		setOrt(ort);
		setPlz(plz);
		setStrasse(strasse);
		setHausnummer(hausnummer);
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getOrt()
	{
		return ort;
	}

	private void setOrt(String ort)
	{
		this.ort = ort;
	}

	public int getPlz()
	{
		return plz;
	}

	private void setPlz(int plz)
	{
		this.plz = plz;
	}

	public String getStrasse()
	{
		return strasse;
	}

	private void setStrasse(String strasse)
	{
		this.strasse = strasse;
	}

	public String getHausnummer()
	{
		return hausnummer;
	}

	private void setHausnummer(String hausnummer)
	{
		this.hausnummer = hausnummer;
	}


	public String getVorname() {
		return vorname;
	}

	private void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
}
