package com.Mediathek.Personen;

public class Mitarbeiter extends Person
{
	private String benutzername;
	private String passwort;
	private int ID;
	private static int counter;

	public Mitarbeiter(String name,String vorname, String ort, int plz, String strasse, String hausnummer,String benutzername,String passwort)
	{
		super(name,vorname, ort, plz, strasse, hausnummer);
		setBenutzername(benutzername);
		setPasswort(passwort);
		setID(++counter);
	}
	
	public String getBenutzername()
	{
		return benutzername;
	}
	private void setBenutzername(String benutzername)
	{
		this.benutzername = benutzername;
	}
	public String getPasswort()
	{
		return passwort;
	}
	private void setPasswort(String passwort)
	{
		this.passwort = passwort;
	}
	@SuppressWarnings("unused")
	public int getID() {
		return ID;
	}

	private void setID(int ID) {
		this.ID = ID;
	}
	public static void setCounter(int i)
	{
		counter=i;
	}

}
