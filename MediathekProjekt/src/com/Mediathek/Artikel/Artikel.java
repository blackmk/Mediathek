package com.Mediathek.Artikel;
import java.io.Serializable;
import java.util.Date;

public abstract class Artikel implements Serializable
{

	private final int ID;
	private static int counter = 0;
	private String bezeichnung;
	private double preis;
	private Date erscheinungsjahr;
	private Date ausleihdatum;
	private boolean status;

	private Type type;



    public Artikel(String bezeichnung, double preis, Date erscheinungsjahr, Date ausleihdatum, Type type)
	{
		ID = ++counter;
		setBezeichnung(bezeichnung);
		setPreis(preis);
		setErscheinungsjahr(erscheinungsjahr);
		setAusleihdatum(ausleihdatum);
		setStatus(false);
        setType(type);
	}


	public int getID() { return ID; }
	@SuppressWarnings("unused")
    public Type getType() {
        return type;
    }

    private void setType(Type type) {
        this.type = type;
    }
	@SuppressWarnings("unused")
	public String getBezeichnung()
	{
		return bezeichnung;
	}

	private void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}
	@SuppressWarnings("unused")
	public double getPreis()
	{
		return preis;
	}

	public void setPreis(double preis)
	{
		this.preis = preis;
	}
	@SuppressWarnings("unused")
	public Date getErscheinungsjahr()
	{
		return erscheinungsjahr;
	}

	private void setErscheinungsjahr(Date erscheinungsjahr)
	{
		this.erscheinungsjahr = erscheinungsjahr;
	}

    public static void setCounter(int counter) {
        Artikel.counter = counter;
    }
	@SuppressWarnings("unused")
	public Date getAusleihdatum()
	{
		return ausleihdatum;
	}

	private void setAusleihdatum(Date ausleihdatum)
	{
		this.ausleihdatum = ausleihdatum;
	}

	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	@SuppressWarnings("unused")
	public String getAusgeliehen() {
        if(status)
        {
            return "Verliehen";
        }else
        {
            return "Frei";
        }
    }
}
