package it.unibs.ing.ieee.clinicamedica;

import java.util.GregorianCalendar;

import it.unibs.fp.mylib.MyMenu;

public class MainClass {

	public static void main(String[] args) {
		Clinica clinica = new Clinica();
		boolean esci = false;
		final String[] vociMenu = {"Stampa tutti i pazienti", "Stampare lista pazienti con un appuntamento", "Stampa orario medico", "Stampare gli appuntamenti per giorno", "Prenota appuntamento", "Rimuovi appuntamento"};
		MyMenu menu = new MyMenu("Clinica Medica",vociMenu);
		
		clinica.addMedico();
		clinica.stampaMedici();
		clinica.stampaOrari(1735600054);
		
		while(esci) {
			switch (menu.scegli()) {
			case 1:
				clinica.stampaPazienti();
				break;
			case 2:
				//stampa paz con app
				break;
			case 3:
				clinica.stampaOrari(2);
				break;
			case 4:
				clinica.stampaOrari(new GregorianCalendar(2000, 2, 16));
				break;
			case 5:
//				clinica.aggiungiAppuntamento();
				break;
			case 6:
//				clinica.rimuoviAppuntamento();
				break;
			default:
				break;
			}
		}
	}

}
