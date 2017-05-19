package it.unibs.ing.ieee.clinicamedica;

public class Ora implements Comparable<Ora>{
	private int ora;
	private int minuti;

	public int getOra() {
		return ora;
	}

	public void setOra(int ora) {
		this.ora = ora;
	}

	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	public Ora(int _ora, int _minuti) {

		if (ora < 0)
			ora = Math.abs(_ora);

		if (ora > 23)
			ora %= 24;

		this.ora = _ora;
		this.minuti = _minuti;
	}

	@Override
	public String toString() {
		return String.format("%d:%d", ora, minuti);
	}
	
	@Override
	public boolean equals(Object obj) {
		Ora o1 = (Ora) obj;
		if(o1.ora == this.ora && o1.minuti == this.minuti)
			return true;
		return false;
	}

	@Override
	public int compareTo(Ora o1) {
		int c;
		c = Integer.compare(this.ora, o1.ora);
		if (c == 0)
			c = Integer.compare(this.minuti, o1.minuti);
		return c;
	}
	
	

}
