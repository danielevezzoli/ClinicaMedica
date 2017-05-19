package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Clinica implements Interfaccia{
	
	private ArrayList<Paziente> pazienti;
	private ArrayList<Medico> medici;
	private ElencoAppuntamenti appuntamenti;
	
	public Clinica() {
		ArrayList<Paziente> pazienti = new ArrayList<>();
		ArrayList<Medico> medici = new ArrayList<Medico>();
		appuntamenti = new ElencoAppuntamenti();
	}
	
	//toString di tutti i medici visualizzando ID univoco, Cognome, Nome, Anno Laurea, Anno Assunzione
	@Override
	public String stampaMedici(){
		StringBuffer s = new StringBuffer();
		for(Medico m: medici){
			System.out.println(m);
			s.append(m);
		}
		return s.toString();
	}

	//chech = id
	@Override
	public ArrayList<GiornoLavorativo> stampaOrari(int check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for(Medico m : medici){
			int i = 0;
			if(check == m.getId()){
				for(GiornoLavorativo g : medici.get(i).getGiorniLavorativi()){
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}
	
	//check = nome
	public ArrayList<GiornoLavorativo> stampaOrari(String check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for(Medico m : medici){
			int i = 0;
			if(check == m.getNome()){
				for(GiornoLavorativo g : medici.get(i).getGiorniLavorativi()){
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}
	
	//check = anno di laurea
	public ArrayList<GiornoLavorativo> stampaOrari(GregorianCalendar check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for(Medico m : medici){
			int i = 0;
			if(check == m.getAnnoLaurea()){
				for(GiornoLavorativo g : medici.get(i).getGiorniLavorativi()){
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}

	//Stampa tutti gli appuntamenti del Medico Inserito
	@Override
	public ArrayList<Appuntamento> stampaAppuntamenti(int matricola) {
		return appuntamenti.stampaAppuntamentiDatoMedico(matricola);
	}

	@Override
	public String stampaPazienti() {
		StringBuffer ritorno = new StringBuffer();
		for(Paziente p : pazienti){
			System.out.println(p);
			ritorno.append(p.getNome());
		}
		return ritorno.toString();
	}

	@Override
	public ArrayList<Appuntamento> stampaAppuntamenti(GregorianCalendar dataInizio, GregorianCalendar dataFine) {
		return appuntamenti.stampaAppuntamentiDatoInizioFine(dataInizio, dataFine);
	}

	@Override
	public String stampaNumAppuntamenti(int matricola) {
		return String.valueOf(appuntamenti.numAppuntamentiDatoMedico(matricola));
	}

	@Override
	public void getTime() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
