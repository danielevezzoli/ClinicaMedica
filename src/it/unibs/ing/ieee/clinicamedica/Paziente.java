package it.unibs.ing.ieee.clinicamedica;

public class Paziente extends Persona{

	private Allarme priorita;
	private int numeroAppuntamenti;
	
	public Paziente(String _nome, String _cognome) {
		super(_nome, _cognome);
		this.setId(this.hashCode());
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
	
	public String toString(){
		return String.format("nome: %s\ncognome: %s\nid: %id\npriorita': %s\nnumero di appuntamenti: %d\n",this.getNome(),this.getCognome(),this.getId(),priorita,numeroAppuntamenti);
	}

}
