package it.unibs.ing.ieee.clinicamedica;

import java.util.GregorianCalendar;

public class Appuntamento {
	private int id;
	private Paziente paziente;
	private Medico medico;
	private GregorianCalendar data;
	private int priorita;
	
	public Appuntamento(int id, Paziente paziente, Medico medico, GregorianCalendar data, int priorita) {
		super();
		this.id = id;
		this.paziente = paziente;
		this.medico = medico;
		this.data = data;
		this.priorita = priorita;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Paziente getPaziente() {
		return paziente;
	}
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public int getPriorita() {
		return priorita;
	}
	public void setPriorita(int priorita) {
		this.priorita = priorita;
	}
	
	@Override
	public String toString() {
		return String.format("Medico: %s %nPaziente: %s%nOrario: %s%n",medico, paziente,data);
	}
	

}
