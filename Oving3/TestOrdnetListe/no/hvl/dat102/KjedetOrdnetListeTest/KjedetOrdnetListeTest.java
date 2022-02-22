package no.hvl.dat102.KjedetOrdnetListeTest;

import no.hvl.dat102.adt.OrdnetListeADTTest;
import no.hvl.dat102.liste.adt.OrdnetListeADT;
import no.hvl.dat102.liste.kjedet.KjedetOrdnetListe;



public class KjedetOrdnetListeTest extends  OrdnetListeADTTest{
	   @Override
		protected OrdnetListeADT<Integer> reset() {
			return new KjedetOrdnetListe<Integer>();
		}		
}

