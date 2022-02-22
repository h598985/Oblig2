package no.hvl.dat102.TabellOrdnetListeTest;

import no.hvl.dat102.adt.OrdnetListeADTTest;
import no.hvl.dat102.liste.adt.OrdnetListeADT;
import no.hvl.dat102.liste.tabell.TabellOrdnetListe;

public class TabellOrdnetListeTest extends OrdnetListeADTTest {
	@Override
	protected OrdnetListeADT<Integer> reset() {
		return new TabellOrdnetListe<Integer>();
	}
}
