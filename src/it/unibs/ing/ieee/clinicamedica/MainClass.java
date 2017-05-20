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
				"Stampa numero appuntamenti per medico", "Stampa appuntamenti per paziente in ordine di urgenza","Stampa orario medico per anno laurea", "Stampa orario medico per id" };
		MyMenu menu = new MyMenu("Clinica Medica", vociMenu);

		Medico m1 = clinica.addMedico("Carlo", "Ghitti", new GregorianCalendar(1998, 2, 4),
				new GregorianCalendar(2000, 5, 22));
		clinica.addMedico("Franco", "Pelizzari", new GregorianCalendar(1980, 2, 4), new GregorianCalendar(1990, 5, 22));

		clinica.addPaziente("Gianmaria", "Pola");
		Paziente p1 = clinica.addPaziente("Aldo", "Zanolla");

		clinica.addAppuntamento(p1, m1, new GregorianCalendar(1980, 2, 4, 14, 0), 8);
		clinica.addAppuntamento(p1, m1, new GregorianCalendar(1980, 5, 26, 10, 30), 1);

		while (!esci) {
			switch (menu.scegli()) {
			case 1:
				clinica.stampaPazienti();
				break;
			case 2:
				clinica.ordinaPazientiPerNumeroAppuntamenti();
				break;
			case 3:
				clinica.stampaOrari(InputDati.leggiStringaNonVuota("Inserisci il nome del medico: "));
				break;
			case 4:
				clinica.stampaAppuntamenti(new GregorianCalendar(1980, 2, 4, 0, 0));
				break;
			case 5:
				clinica.addAppuntamento();
				break;
			case 6:
				clinica.rimuoviAppuntamento();
				break;
			case 7:
				clinica.addMedico();
				break;
			case 8:
				clinica.addPaziente();
				break;
			case 9:
				clinica.stampaMedici();
				break;
			case 10:
				clinica.stampaAppuntamenti();
				break;
			case 11:
				clinica.stampaAppuntamenti(clinica.cercaIdDatoNomeCognome(InputDati.leggiStringaNonVuota("Inserisci il nome del medico: "), InputDati.leggiStringaNonVuota("Inserisci il cognome del medico: ")));
				break;
			case 12:
				clinica.stampaAppuntamenti(new GregorianCalendar(1980, 2, 3, 14, 0),
						new GregorianCalendar(1980, 5, 27, 10, 30));
				break;
			case 13:
				clinica.stampaNumAppuntamenti(589431969);
				break;
			case 14:
				break;
			case 15:
				clinica.stampaOrari(new GregorianCalendar(InputDati.leggiInteroNonNegativo("Inserisci l'anno di laurea: "),0,0));
				break;
			case 16:
				clinica.stampaOrari(InputDati.leggiInteroNonNegativo("Inserisci l'id del medico: "));
			default:
				break;
			}
		}
	}

}
