package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

public class ElencoAppuntamenti {
	private ArrayList<Appuntamento> appuntamenti = new ArrayList<>();

	public void addAppuntamento(Appuntamento a) {
		appuntamenti.add(a);
	}

	public void removeAppuntamento(Appuntamento a) {
		appuntamenti.remove(a);
	}

	public void modificaAppuntamento(Appuntamento a) {

	}

	public ArrayList<Appuntamento> stampaAppuntamenti() {
		return appuntamenti;
	}

	public ArrayList<Appuntamento> stampaAppuntamentiDatoMedico(int id) {
		ArrayList<Appuntamento> ritorno = new ArrayList<>();
		for (Appuntamento a : appuntamenti) {
			if (a.getId() == id)
				ritorno.add(a);
		}		
		return ritorno;

	}

	public ArrayList<Appuntamento> stampaAppuntamentiDatoInizioFine(GregorianCalendar inizio, GregorianCalendar fine) {
		ArrayList<Appuntamento> ritorno = new ArrayList<>();
		
		ritorno = (ArrayList<Appuntamento>) appuntamenti.stream().filter(a -> a.getData().compareTo(fine) < 0 || a.getData().compareTo(inizio) > 0).collect(Collectors.toList());
		return ritorno;

	}

	public ArrayList<Paziente> stampaPazientiConAppuntamento() {
		ArrayList<Paziente> ritorno = new ArrayList<>();
		
		
		for (Appuntamento a : appuntamenti) {
			ritorno.add(a.getPaziente());
		}
		return ritorno;

	}

	public int numAppuntamentiDatoMedico(int id) {
		int c=0;
		for (Appuntamento appuntamento : appuntamenti) {
			if(appuntamento.getMedico().getId() == id)
				c++;
		}
		return c;
	}
	
	public int numAppuntamentiDatoPaziente(int id) {
		int c=0;
		for (Appuntamento appuntamento : appuntamenti) {
			if(appuntamento.getPaziente().getId() == id)
				c++;
		}
		return c;
	}
}
