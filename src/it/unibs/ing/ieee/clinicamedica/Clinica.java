package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Clinica implements Interfaccia{
	
	private ArrayList<Paziente> pazienti;
	private ArrayList<Medico> medici;
	private ElencoAppuntamenti appuntamenti;
	
	public Clinica() {
		pazienti = new ArrayList<>();
		medici = new ArrayList<>();
		appuntamenti = new ElencoAppuntamenti();
	}
	
	
	
	
}
