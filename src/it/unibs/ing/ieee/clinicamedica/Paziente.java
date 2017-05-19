package it.unibs.ing.ieee.clinicamedica;

public class Paziente extends Persona{

	private Allarme priorita;
	private int numeroAppuntamenti;
	
	public Paziente(String _nome, String _cognome) {
		super(_nome, _cognome);
	}

	public Allarme getPriorita() {
		return priorita;
	}

	public void setPriorita(Allarme priorita) {
		this.priorita = priorita;
	}

	public int getNumeroAppuntamenti() {
		return numeroAppuntamenti;
	}

	public void setNumeroAppuntamenti(int numeroAppuntamenti) {
		this.numeroAppuntamenti = numeroAppuntamenti;
	}

}
