package no.hvl.dat102.dataKontaktFirma;

import java.util.Arrays;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class DataKontakt {
	
	private Medlem[] medlem;
	private int antallMedlemmer;
	
	public DataKontakt(int kapasitet) {
		medlem = new Medlem[kapasitet];
		antallMedlemmer = 0;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}
	
	public boolean leggTilMedlem(Medlem person) {
	
		if (antallMedlemmer < medlem.length) {

			medlem[antallMedlemmer] = person;
			antallMedlemmer++;
			return true;
		} else {
			return false;
		}
	}
	
	public int finnMedlemsIndeks(String medlemsNavn) {
		int indeks = -1;
		for(int i = 0; i <  antallMedlemmer; i++) {
			if(medlem[i].getNavn().equals(medlemsNavn)) {
				
				indeks = medlem[i].getStatusIndeks();
			}
		}
		 return indeks;
		
		
	}
	
	public int finnPartnerFor(String medlemNavn) {
		
		Medlem medlemen = null;
		int indeks = -1;
		boolean finnes = false;
		int posisjon = 0;

		for (int i = 0; i < antallMedlemmer; i++) {

			if (medlem[i].getNavn().equals(medlemNavn)) {

				medlemen = medlem[i];
				
				posisjon = i; // posisjonen til medlemmet som vil ha partner

				finnes = true;
			}
		}
		if (finnes) {
			for (int i = 0; i < antallMedlemmer; i++) {

				if (medlemen.passerTil(medlem[i]) && !(medlemen.equals(medlem[posisjon]))) {

					if (indeks == medlem[i].getStatusIndeks()) {
						medlemen.setStatusIndeks(i);
						medlem[i].setStatusIndeks(posisjon);
						indeks = medlem[i].getStatusIndeks();
					}
				}
			}
		}
		
		return indeks;
	}
	
	public void tilbakestillStatusIndeks(String medlemsNavn) {
		boolean finnes = false;
		int status = 0;
		int indeks = -1;
		Medlem m = null;
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlem[i].getNavn().equals(medlemsNavn)) {
				m = medlem[i];
				status = medlem[i].getStatusIndeks();
				if(m.getStatusIndeks() != indeks) {
					m.setStatusIndeks(indeks);
					medlem[status].setStatusIndeks(indeks);
				}
			}
		}
		
	}
	
//	public [] skrivUtMedlemmer() {
//		Medlem[] retur = new Medlem[this.antallMedlemmer];
//		for
//	}

	@Override
	public String toString() {

		String resultat = " ";

		for (int i = 0; i < this.antallMedlemmer; i++) {

			resultat += medlem[i].toString() +"\n" ;
		
		}

		return resultat;
	}
	
	
	

}
