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
		return String.format("nome: %s\ncognome: %s\nid: %n\nanno di laurea: %s\nanno di assunzione: %s\n",this.getNome(),this.getCognome(),this.getId(),annoLaurea,annoAssunzione);
	}

	public GiornoLavorativo[] getGiorniLavorativi() {
		return giorniLavorativi;
	}

	public void setGiorniLavorativi(GiornoLavorativo[] giorniLavorativi) {
		this.giorniLavorativi = giorniLavorativi;
	}

	public GregorianCalendar getAnnoLaurea() {
		return annoLaurea;
	}
	
}
