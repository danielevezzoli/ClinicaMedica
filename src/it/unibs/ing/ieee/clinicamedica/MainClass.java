package it.unibs.ing.ieee.clinicamedica;

import java.util.GregorianCalendar;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MainClass {

	public static void main(String[] args) {
		Clinica clinica = new Clinica();
		boolean esci = false;
		final String[] vociMenu = { "Stampa tutti i pazienti", "Stampare lista pazienti con un appuntamento",
				"Stampa orario medico", "Stampare gli appuntamenti per giorno", "Prenota appuntamento",
				"Rimuovi appuntamento", "Aggiungi medico", "Aggiungi paziente", "Stampa medici", "Stampa appuntamenti",
				"Stampa appuntamento per medico inserito", "Stampa appuntamenti per intervallo di date",
				"Stampa numero appuntamenti per medico", "Stampa appuntamenti per paziente in ordine di urgenza",
				"Stampa orario medico per anno laurea", "Stampa orario medico per id", "Stampa tempi" };
		MyMenu menu = new MyMenu("Clinica Medica", vociMenu);

		Medico m1 = clinica.addMedico("Carlo", "Ghitti", new GregorianCalendar(1998, 2, 4),
				new GregorianCalendar(2000, 5, 22));
		clinica.addMedico("Franco", "Pelizzari", new GregorianCalendar(1980, 2, 4), new GregorianCalendar(1990, 5, 22));

		clinica.addPaziente("Gianmaria", "Pola");
		Paziente p1 = clinica.addPaziente("Aldo", "Zanolla");

		clinica.addAppuntamento(p1, m1, new GregorianCalendar(1980, 5, 26, 10, 30), 1);
		clinica.addAppuntamento(p1, m1, new GregorianCalendar(1980, 2, 4, 14, 0), 8);

		while (!esci) {
			switch (menu.scegli()) {
			case 1:
				clinica.getTime();
				clinica.stampaPazienti();
				clinica.getTime();
				break;
			case 2:
				clinica.getTime();
				clinica.ordinaPazientiPerNumeroAppuntamenti();
				clinica.getTime();
				break;
			case 3:
				clinica.getTime();
				clinica.stampaOrari(InputDati.leggiStringaNonVuota("Inserisci il nome del medico: "));
				clinica.getTime();
				break;
			case 4:
				clinica.getTime();
				clinica.stampaAppuntamenti(new GregorianCalendar(1980, 2, 4, 0, 0));
				clinica.getTime();
				break;
			case 5:
				clinica.getTime();
				clinica.addAppuntamento();
				clinica.getTime();
				break;
			case 6:
				clinica.getTime();
				clinica.rimuoviAppuntamento();
				clinica.getTime();
				break;
			case 7:
				clinica.getTime();
				clinica.addMedico();
				clinica.getTime();
				break;
			case 8:
				clinica.getTime();
				clinica.addPaziente();
				clinica.getTime();
				break;
			case 9:
				clinica.getTime();
				clinica.stampaMedici();
				clinica.getTime();
				break;
			case 10:
				clinica.getTime();
				clinica.stampaAppuntamenti();
				clinica.getTime();
				break;
			case 11:
				clinica.getTime();
				clinica.stampaAppuntamenti(
						clinica.cercaIdDatoNomeCognome(InputDati.leggiStringaNonVuota("Inserisci il nome del medico: "),
								InputDati.leggiStringaNonVuota("Inserisci il cognome del medico: ")));
				clinica.getTime();
				break;
			case 12:
				clinica.getTime();
				clinica.stampaAppuntamenti(new GregorianCalendar(1980, 2, 3, 14, 0),
						new GregorianCalendar(1980, 5, 27, 10, 30));
				clinica.getTime();
				break;
			case 13:
				clinica.getTime();
				clinica.stampaNumAppuntamenti(589431969);
				clinica.getTime();
				break;
			case 14:
				clinica.getTime();
				clinica.stampaAppuntamentiPazientePerUrgenza(460141958);
				clinica.getTime();
				break;
			case 15:
				clinica.getTime();
				clinica.stampaOrari(
						new GregorianCalendar(InputDati.leggiInteroNonNegativo("Inserisci l'anno di laurea: "), 0, 0));
				clinica.getTime();
				break;
			case 16:
				clinica.getTime();
				clinica.stampaOrari(InputDati.leggiInteroNonNegativo("Inserisci l'id del medico: "));
				clinica.getTime();
				break;
			case 17:
				clinica.printTime();
			default:
				break;
			}
		}
	}

}
