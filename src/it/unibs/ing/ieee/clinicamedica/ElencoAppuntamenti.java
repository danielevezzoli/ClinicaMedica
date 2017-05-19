package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ElencoAppuntamenti {
	private ArrayList <Appuntamento> appuntamenti = new ArrayList <>();
	
	
	public void addAppuntamento (Appuntamento a)
	{
		appuntamenti.add(a);
	}
	
	public void removeAppuntamento (Appuntamento a)
	{
		appuntamenti.remove(a);
	}
	
	public void modificaAppuntamento (Appuntamento a)
	{
		
	}
	
	public ArrayList<Appuntamento> stampaAppuntamenti ()
	{
		return appuntamenti;
	}
	
	public ArrayList<Appuntamento> stampaAppuntamentiDatoMedico (int id)
	{
		ArrayList<Appuntamento> ritorno = new ArrayList <> ();
		for (Appuntamento a: appuntamenti)
		{
			if (a.getId()==id)
				ritorno.add(a);
		}
		return ritorno;
		
	}
	
	public int numAppuntamentiDatoMedico (int id)
	{
		int ritorno=0;
		for (Appuntamento a: appuntamenti)
		{
			if (a.getId()==id)
				ritorno++;
		}
		return ritorno;
		
	}
	
	public ArrayList<Appuntamento> stampaAppuntamentiDatoInizioFine(GregorianCalendar inizio, GregorianCalendar fine)
	{
		ArrayList<Appuntamento> ritorno = new ArrayList <> ();
		for (Appuntamento a: appuntamenti)
		{
			if (a.getData().compareTo(fine)<0|| a.getData().compareTo(inizio)>0)
				ritorno.add(a);
		}
		return ritorno;
		
	}
	
	public ArrayList<Paziente> stampaPazientiConAlmeno1Appuntamento()
	{
		ArrayList<Paziente> ritorno = new ArrayList <> ();
		for (Appuntamento a: appuntamenti)
		{
			ritorno.add(a.getPaziente());
		}
		return ritorno;
		
	}

}
