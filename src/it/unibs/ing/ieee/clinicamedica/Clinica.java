package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

import it.unibs.fp.mylib.InputDati;

public class Clinica implements Interfaccia {

	private ArrayList<Paziente> pazienti = new ArrayList<>();
	private ArrayList<Medico> medici = new ArrayList<Medico>();
	private ElencoAppuntamenti appuntamenti;

	public Clinica() {
		// ArrayList<Paziente> pazienti = new ArrayList<>();
		// ArrayList<Medico> medici = new ArrayList<Medico>();
		appuntamenti = new ElencoAppuntamenti();
	}

	// toString di tutti i medici visualizzando ID univoco, Cognome, Nome, Anno
	// Laurea, Anno Assunzione
	@Override
	public String stampaMedici() {
		StringBuffer s = new StringBuffer();
		for (Medico m : medici) {
			System.out.println(m);
			s.append(m);
		}
		return s.toString();
	}

	// check = id
	@Override
	public ArrayList<GiornoLavorativo> stampaOrari(int check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for (Medico m : medici) {
			if (check == m.getId()) {
				for (GiornoLavorativo g : m.getGiorniLavorativi()) {
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}

	// check = nome
	public ArrayList<GiornoLavorativo> stampaOrari(String check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for (Medico m : medici) {
			int i = 0;
			if (check.equals(m.getNome())) {
				System.out.println(check + " " + m.getCognome());
				for (GiornoLavorativo g : medici.get(i).getGiorniLavorativi()) {
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}

	// check = anno di laurea
	public ArrayList<GiornoLavorativo> stampaOrari(GregorianCalendar check) {
		ArrayList<GiornoLavorativo> s = new ArrayList<GiornoLavorativo>();
		for (Medico m : medici) {
			int i = 0;
			// il +1 serve perche check year viene decrementato di uno per qualche strano motivo
			if (check.get(Calendar.YEAR) +1 == (m.getAnnoLaurea().get(Calendar.YEAR))) {
				for (GiornoLavorativo g : medici.get(i).getGiorniLavorativi()) {
					System.out.println(g);
					s.add(g);
				}
			}
			System.out.println("\n");
		}
		return s;
	}

	// Stampa tutti gli appuntamenti del Medico Inserito
	@Override
	public ArrayList<Appuntamento> stampaAppuntamenti(int matricola) {
		ArrayList<Appuntamento> app = new ArrayList<>(appuntamenti.stampaAppuntamentiDatoMedico(matricola));
				
		for(Appuntamento b : app) {
			System.out.println(b);
		}
		
		return app;
		
	}
	
	public ArrayList<Appuntamento> stampaAppuntamenti(GregorianCalendar data) {
		
		GregorianCalendar min = new GregorianCalendar();
		GregorianCalendar max = new GregorianCalendar();
		min = max = data;
		min.set(Calendar.HOUR, 0);
		min.set(Calendar.MINUTE, 0);
		max.set(Calendar.HOUR, 23);
		max.set(Calendar.MINUTE, 59);
				
		ArrayList<Appuntamento> app = new ArrayList<>();
		for(Appuntamento a : appuntamenti.getAppuntamenti()) {	
			if(a.getData().compareTo(min) >=  0 || a.getData().compareTo(max) <=0 ) {
				System.out.println(a);
				app.add(a);
			}
		}
		
		return app;
		
	}
	
	
	public Medico cercaMedicoDaId(int id) {
		for (Medico medico : medici) {
			if(medico.getId() == id)
				return medico;
		}
		return null;
	}

	@Override
	public String stampaPazienti() {
		appuntamenti.aggiornaNumeroAppuntamenti();
		StringBuffer ritorno = new StringBuffer();
		for (Paziente p : pazienti) {
			System.out.println(p);
			ritorno.append(p.getNome());
		}
		return ritorno.toString();
	}

	@Override
	public ArrayList<Appuntamento> stampaAppuntamenti(GregorianCalendar dataInizio, GregorianCalendar dataFine) {
		ArrayList<Appuntamento> app = new ArrayList<>(appuntamenti.stampaAppuntamentiDatoInizioFine(dataInizio, dataFine));
		
		for (Appuntamento a : app) {
			System.out.println(a);
		}
		
		return app;
	}

	@Override
	public String stampaNumAppuntamenti(int matricola) {
		String str = String.valueOf(appuntamenti.numAppuntamentiDatoMedico(matricola));
		System.out.println("Il dottor " + cercaMedicoDaId(matricola).getNome() + " " + cercaMedicoDaId(matricola).getCognome() + " ha " + str + " Appuntamenti");
		return str;
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

		Medico m = new Medico(nome, cognome, annoLaurea, annoAssunzione);

		GiornoLavorativo[] gLav = new GiornoLavorativo[7];
		Ora o1 = new Ora(10, 0);
		Ora o2 = new Ora(12, 0);
		Ora o3 = new Ora(14, 0);
		Ora o4 = new Ora(20, 0);
		for (int i = 0; i < gLav.length; i++) {
			GiornoLavorativo g = new GiornoLavorativo(true, o1, o2, o3, o4);
			gLav[i] = g;
		}

		m.setGiorniLavorativi(gLav);

		medici.add(m);
		return m;
	}

	public Medico addMedico(String _nome, String _cognome, GregorianCalendar _annoLaurea,
			GregorianCalendar _annoAssunzione) {
		Medico m = new Medico(_nome, _cognome, _annoLaurea, _annoAssunzione);

		medici.add(m);

		GiornoLavorativo[] gLav = new GiornoLavorativo[7];
		Ora o1 = new Ora(10, 0);
		Ora o2 = new Ora(12, 0);
		Ora o3 = new Ora(14, 0);
		Ora o4 = new Ora(20, 0);
		for (int i = 0; i < gLav.length; i++) {
			GiornoLavorativo g = new GiornoLavorativo(true, o1, o2, o3, o4);
			gLav[i] = g;
		}

		m.setGiorniLavorativi(gLav);

		return m;
		
	}

	public Paziente addPaziente(String nome, String cognome) {
		Paziente p = new Paziente(nome, cognome);
		
		pazienti.add(p);
		
		return p;
	}

	public void addPaziente() {
		String nome = InputDati.leggiStringaNonVuota("Inserisci il nome del paziente: ");
		String cognome = InputDati.leggiStringaNonVuota("Inserisci il cognome del paziente: ");

		pazienti.add(new Paziente(nome, cognome));
	}

	public void addAppuntamento() {
		Appuntamento app;
		Medico m = null;
		Paziente p = null;
		GregorianCalendar data = null;

		int idM = InputDati.leggiIntero("Inserisci l'id del medico: ");

		for (Medico medico : medici) {
			if (idM == medico.getId()) {
				m = medico;
			}
		}

		int idP = InputDati.leggiIntero("Inserisci l'id del paziente: ");

		for (Paziente paziente : pazienti) {
			if (idP == paziente.getId()) {
				p = paziente;
			}
		}

		int annoA = InputDati.leggiInteroNonNegativo("Anno appuntamento: ");
		int meseA = InputDati.leggiInteroNonNegativo("Mese appuntamento: ");
		int giornoA = InputDati.leggiInteroNonNegativo("Giorno appuntamento: ");
		int oraA = InputDati.leggiInteroNonNegativo("Ora appuntamento: ");
		data = new GregorianCalendar(annoA, meseA, giornoA, oraA, 0);
		
		int priorita = InputDati.leggiInteroNonNegativo("Priorità appuntamento: ");

		

		appuntamenti.addAppuntamento(new Appuntamento(p, m, data, priorita));
	}
	
	public void addAppuntamento(Paziente paziente, Medico medico, GregorianCalendar data, int priorita) {
		appuntamenti.addAppuntamento(new Appuntamento(paziente, medico, data, priorita));
	}
	
	
	public void stampaAppuntamenti() {
		for (Appuntamento a : appuntamenti.getAppuntamenti()) {
			System.out.println(a);
		}
	}
	
	public int cercaIdDatoNomeCognome(String nome, String cognome) {
		for(Medico m : medici) {
			if(m.getNome().equalsIgnoreCase(nome) && m.getCognome().equalsIgnoreCase(cognome))
				return m.getId();
		}
		return 0;
	}
	
	public void rimuoviAppuntamento() {
		int id = InputDati.leggiIntero("Inserisci l'id dell'appuntamento: ");
		for(Appuntamento a : appuntamenti.getAppuntamenti()) {
			if(id == a.getId()) {
				appuntamenti.removeAppuntamento(a);
				System.out.println("Rimosso :D");
				break;
			}
		}
	}
	
	public ArrayList<Paziente> ordinaPazientiPerNumeroAppuntamenti() {
		appuntamenti.aggiornaNumeroAppuntamenti();
		ArrayList<Paziente> tmp = new ArrayList<>(pazienti);
		for(Paziente p : tmp)
			if(p.getNumeroAppuntamenti() == 0)
				tmp.remove(p);
		
		Collections.sort(tmp);
		for(Paziente p : tmp)
			System.out.println(p);
//		stampaPazienti();
		return pazienti;
	}

	@Override
	public void getTime() {

	}

}
