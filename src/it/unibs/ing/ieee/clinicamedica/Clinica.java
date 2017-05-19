package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import it.unibs.fp.mylib.InputDati;

public class Clinica implements Interfaccia{
	
	private ArrayList<Paziente> pazienti= new ArrayList<>();
	private ArrayList<Medico> medici=new ArrayList<Medico>();
	private ElencoAppuntamenti appuntamenti;
	
	public Clinica() {
//		ArrayList<Paziente> pazienti = new ArrayList<>();
//		ArrayList<Medico> medici = new ArrayList<Medico>();
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

	//check = id
	@Override
	public ArrayList<GiornoLavorativo> stampaOrari(int check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for(Medico m : medici){
			if(check == m.getId()){
				for(GiornoLavorativo g : m.getGiorniLavorativi()){
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
	
	public Medico addMedico() {
		String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del medico: ");
		String cognome = InputDati.leggiStringaNonVuota("Inserisci il cognome del medico: ");
		int anno = InputDati.leggiInteroNonNegativo("Anno laurea: ");
		int mese = InputDati.leggiInteroNonNegativo("Mese laurea: ");
		int giorno = InputDati.leggiInteroNonNegativo("Giorno laurea: ");
		GregorianCalendar annoLaurea = new GregorianCalendar(anno, mese, giorno);
		int annoA = InputDati.leggiInteroNonNegativo("Anno assunzione: ");
		int meseA = InputDati.leggiInteroNonNegativo("Mese assunzione: ");
		int giornoA = InputDati.leggiInteroNonNegativo("Giorno assunzione: ");
		GregorianCalendar annoAssunzione = new GregorianCalendar(annoA, meseA, giornoA);
		
		Medico m= new Medico(nome,cognome,annoLaurea,annoAssunzione);
		
		GiornoLavorativo[] gLav = new GiornoLavorativo[7];
		Ora o1 = new Ora(10, 0);
		Ora o2 = new Ora(12, 0);
		Ora o3 = new Ora(14, 0);
		Ora o4 = new Ora(20, 0);
		for(int i=0;i<gLav.length;i++) {
			GiornoLavorativo g = new GiornoLavorativo(true,o1,o2,o3,o4);
			gLav[i] = g;
		}
		
		m.setGiorniLavorativi(gLav);
		
		medici.add(m);
		return m;
	}
	
	public void addPaziente() {
		String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del paziente: ");
		String cognome = InputDati.leggiStringaNonVuota("Inserisci il cognome del paziente: ");
//		Allarme priorita = InputDati.leggiStringaNonVuota("Inserisci la gravità[ROSSO, GIALLO, NERO, MARRONE]: ");
		
		pazienti.add(new Paziente(nome, cognome));
	}
	
	public void addAppuntamento() {
		Appuntamento app;
		Medico m = null;
		Paziente p = null;
		GregorianCalendar data = null;
		
		int idM = InputDati.leggiIntero("Inserisci l'id del medico: ");
		
		for (Medico medico : medici) {
			if(idM == medico.getId()) {
				m=medico;
			}	
		}
		
		int idP = InputDati.leggiIntero("Inserisci l'id del medico: ");
		
		for (Paziente paziente : pazienti) {
			if(idP == paziente.getId()) {
				p=paziente;
			}	
		}
		
		int annoA = InputDati.leggiInteroNonNegativo("Anno appuntamento: ");
		int meseA = InputDati.leggiInteroNonNegativo("Mese appuntamento: ");
		int giornoA = InputDati.leggiInteroNonNegativo("Giorno appuntamento: ");
		int oraA = InputDati.leggiInteroNonNegativo("Ora appuntamento: ");
		data = new GregorianCalendar(annoA, meseA, giornoA, oraA, 0);

		appuntamenti.addAppuntamento(app);
	}
	
	

	@Override
	public void getTime() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
