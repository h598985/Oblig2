package no.hvl.dat102.dataKontaktFirma;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class MedlemKlient {

	public static void main(String[] args) {
		
		Hobby hobby = new Hobby("football");
		Hobby hobb1 = new Hobby("tennis");
		Hobby hobb3 = new Hobby("tekning");
		
		MengdeADT<Hobby> liste1 = new KjedetMengde<>();
		liste1.leggTil(hobby);
		liste1.leggTil(hobb1);
		
		MengdeADT<Hobby> liste2 = new KjedetMengde<>();
		liste2.leggTil(hobb3);
		
		Medlem medlem1 = new Medlem("Maria",liste2);
		Medlem medlem2 = new Medlem("Marie",liste2);
		Medlem medlem3 = new Medlem("Jonas",liste1);
		
		
		DataKontakt  data = new DataKontakt(100);
		
		
		data.leggTilMedlem(medlem1);
		data.leggTilMedlem(medlem2);
		data.leggTilMedlem(medlem3);
		
		 skrivUtData( data);
		
	}
	
	public static void skrivUtData( DataKontakt data) {
		
		
		
	     System.out.println(data.toString());
	    
		
	
		
	}

}
