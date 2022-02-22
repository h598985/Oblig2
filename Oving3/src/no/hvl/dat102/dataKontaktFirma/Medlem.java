package no.hvl.dat102.dataKontaktFirma;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
	
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem(String navn,MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		statusIndeks= -1;
	}
	
	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		
		if(this.hobbyer.equals(medlem2.hobbyer)) {
			passer = true;
		}
		return passer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	@Override
	public String toString() {
		
		String resultat = "Namn: " + this.navn + "\n" +  "Status: " + this.statusIndeks + "\n" + "Hobbyer: " + hobbyer.toString();
		
		return resultat;
	}
	
	

}
