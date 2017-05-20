package it.unibs.ing.ieee.clinicamedica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import it.unibs.fp.mylib.InputDati;

public class Clinica implements Interfaccia {

	private ArrayList<Paziente> pazienti = new ArrayList<>();
	private ArrayList<Medico> medici = new ArrayList<Medico>();
	private ElencoAppuntamenti appuntamenti;

	public Clinica() {
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

		medici.stream()
			  .filter(m -> m.getId() == check)
			  .map(m -> Arrays.asList(m.getGiorniLavorativi()))
			  .flatMap(gl -> gl.stream())
			  .forEach(g -> System.out.println(g));

		System.out.println(Arrays.asList(GiorniSettimana.values()));

		return null;
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
			// il +1 serve perche check.year viene decrementato di uno per
			// qualche strano motivo
			if (check.get(Calendar.YEAR) + 1 == (m.getAnnoLaurea().get(Calendar.YEAR))) {
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
		Collections.sort(app);
		for (Appuntamento b : app) {
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
		for (Appuntamento a : appuntamenti.getAppuntamenti()) {
			if (a.getData().compareTo(min) >= 0 || a.getData().compareTo(max) <= 0) {
				System.out.println(a);
				app.add(a);
			}
		}

		return app;

	}

	public Medico cercaMedicoDaId(int id) {
		for (Medico medico : medici) {
			if (medico.getId() == id)
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
		ArrayList<Appuntamento> app = new ArrayList<>(
				appuntamenti.stampaAppuntamentiDatoInizioFine(dataInizio, dataFine));

		for (Appuntamento a : app) {
			System.out.println(a);
		}

		return app;
	}

	@Override
	public String stampaNumAppuntamenti(int matricola) {
		String str = String.valueOf(appuntamenti.numAppuntamentiDatoMedico(matricola));
		System.out.println("Il dottor " + cercaMedicoDaId(matricola).getNome() + " "
				+ cercaMedicoDaId(matricola).getCognome() + " ha " + str + " Appuntamenti");
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

		ArrayList<GiorniSettimana> giorni = (ArrayList<GiorniSettimana>) Arrays.asList(GiorniSettimana.values());
		GiornoLavorativo[] gLav = new GiornoLavorativo[7];
		Ora o1 = new Ora(10, 0);
		Ora o2 = new Ora(12, 0);
		Ora o3 = new Ora(14, 0);
		Ora o4 = new Ora(20, 0);
		for (int i = 0; i < gLav.length; i++) {
			GiornoLavorativo g = new GiornoLavorativo(true, o1, o2, o3, o4, giorni.get(i));
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
		List<GiorniSettimana> giorni = Arrays.asList(GiorniSettimana.values());

		GiornoLavorativo[] gLav = new GiornoLavorativo[7];
		Ora o1 = new Ora(10, 0);
		Ora o2 = new Ora(12, 0);
		Ora o3 = new Ora(14, 0);
		Ora o4 = new Ora(20, 0);
		for (int i = 0; i < gLav.length; i++) {
			GiornoLavorativo g = new GiornoLavorativo(true, o1, o2, o3, o4, giorni.get(i));
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
		Medico m = null;
		Paziente p = null;
		GregorianCalendar data = null;

		
		do {
			int idM = InputDati.leggiIntero("Inserisci l'id del medico: ");

			for (Medico medico : medici) {
				if (idM == medico.getId()) {
					m = medico;
				}
			}
			if (m == null)
				System.out.println("Id sbagliato");
		} while (m == null);

		do {
			int idP = InputDati.leggiIntero("Inserisci l'id del paziente: ");

			for (Paziente paziente : pazienti) {
				if (idP == paziente.getId()) {
					p = paziente;
				}
			}
			if (p == null)
				System.out.println("Id sbagliato");
		} while (p == null);
		
		if(p.getPriorita() == Allarme.NERO){
			System.out.println("Il paziente è morto, non puoi prenotare un appuntamento :(");
			return;
		}
		
		int annoA = InputDati.leggiInteroNonNegativo("Anno appuntamento: ");
		int meseA = InputDati.leggiInteroNonNegativo("Mese appuntamento: ");
		int giornoA = InputDati.leggiInteroNonNegativo("Giorno appuntamento: ");
			
		do {
			int oraA = InputDati.leggiInteroNonNegativo("Ora appuntamento: ");
			GregorianCalendar tmp = new GregorianCalendar(annoA, meseA, giornoA, oraA, 0);
			int giornoDellaSettimana = tmp.get(Calendar.DAY_OF_WEEK);
			GiornoLavorativo g = m.getGiorniLavorativi()[giornoDellaSettimana];
			Ora[] ore = g.getOrario();
			
			if(oraA >= ore[0].getOra() && oraA <= ore[1].getOra() || oraA >= ore[2].getOra() && oraA <= ore[3].getOra())
				data = new GregorianCalendar(annoA, meseA, giornoA, oraA, 0);
			else
				System.out.println("L'orario inserito non è corretto");
		}while(data==null);
		

		int priorita = InputDati.leggiIntero("Priorità appuntamento: ", 0, 10);

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
		for (Medico m : medici) {
			if (m.getNome().equalsIgnoreCase(nome) && m.getCognome().equalsIgnoreCase(cognome))
				return m.getId();
		}
		return 0;
	}

	public void rimuoviAppuntamento() {
		int id = InputDati.leggiIntero("Inserisci l'id dell'appuntamento: ");
		for (Appuntamento a : appuntamenti.getAppuntamenti()) {
			if (id == a.getId()) {
				appuntamenti.removeAppuntamento(a);
				System.out.println("Rimosso :D");
				break;
			}
		}
	}

	public void ordinaPazientiPerNumeroAppuntamenti() {
		appuntamenti.aggiornaNumeroAppuntamenti();

		// IT'S STREAM TIMEEEE
		/**
		 * Breve spiegazione
		 * Creo uno stream di pazienti e ci applico un filtro
		 * secondo il quale seleziono solo i pazienti con appuntamenti (getNumApp > 0).
		 * Li riordino secondo il maggior numero di appuntamenti e
		 * infine li raggruppo per numero di appuntamenti
		 * 
		 * poi stampo
		 */
		Map<Integer, List<Paziente>> map = pazienti.stream()
				.filter(p -> p.getNumeroAppuntamenti() > 0)
				.sorted()
				.collect(Collectors.groupingBy(p -> p.getNumeroAppuntamenti()));

		map.forEach((k, v) -> System.out.printf("Numero appuntamenti: %d %n%s%n%n%n", k, v));

	}

	@Override
	public void getTime() {

	}
	
	
	/**
	 * Breve spiegazione
	 * Creo uno stream di appuntamenti e ci applico un filtro
	 * per selezionare il paziente con un certo id
	 * riordino gli appuntamenti secondo la priorità ( secondo la data sono già ordinati )
	 * infine stampo
	 */
	public void stampaAppuntamentiPazientePerUrgenza(int id) {
		ArrayList<Appuntamento> tmp = new ArrayList<>(appuntamenti.getAppuntamenti());

		tmp.stream()
		   .filter(p -> p.getPaziente().getId() == id)
		   .sorted((a1, a2) -> -Integer.compare(a1.getPriorita(), a2.getPriorita()))
		   .forEach(System.out::println);

	}

}
