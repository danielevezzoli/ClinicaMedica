package it.unibs.ing.ieee.clinicamedica;

import java.util.GregorianCalendar;

public class Medico extends Persona{

	private GregorianCalendar annoLaurea;
	private GregorianCalendar annoAssunzione;
	private GiornoLavorativo[] giorniLavorativi = new GiornoLavorativo[7];
	private int numeroAppuntamenti;
	
	public Medico(String _nome, String _cognome, GregorianCalendar _annoLaurea, GregorianCalendar _annoAssunzione) {
		super(_nome, _cognome);
		annoLaurea = _annoLaurea;
		annoAssunzione = _annoAssunzione;
	}
	
//	public String stampaOrari(){
//		
//	}

	public String toString(){
		return String.format(" ");
	}
	
}
