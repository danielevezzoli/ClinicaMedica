package it.unibs.ing.ieee.clinicamedica;

public class GiornoLavorativo {
	private boolean lavoro = true;
	private Ora[] orario  = new Ora[4];
	
	public GiornoLavorativo(boolean lavoro, Ora[] orario) {
		this.lavoro = lavoro;
		this.orario = orario;
	}
	
	public GiornoLavorativo(boolean lavoro, Ora iMatt, Ora fMatt, Ora iPom, Ora fPom) {
		this.lavoro = lavoro;
		orario[0] = iMatt;
		orario[1] = fMatt;
		orario[2] = iPom;
		orario[3] = fPom;
	}

	public boolean isLavoro() {
		return lavoro;
	}

	public void setLavoro(boolean lavoro) {
		this.lavoro = lavoro;
	}

	public Ora[] getOrario() {
		return orario;
	}

	public void setOrario(Ora[] orario) {
		this.orario = orario;
	}
	
	public void setOrario(Ora iMatt, Ora fMatt, Ora iPom, Ora fPom){
		orario[0] = iMatt;
		orario[1] = fMatt;
		orario[2] = iPom;
		orario[3] = fPom;
	}
	
	public String toString(){
		return String.format("%d - %d \n %d - %d", orario[0],orario[1],orario[2],orario[3]);
	}

}
