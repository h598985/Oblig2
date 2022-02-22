package no.hvl.dat102.liste.tabell;

import no.hvl.dat102.liste.adt.OrdnetListeADT;
import no.hvl.dat102.liste.exceptions.EmptyCollectionException;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		T resultat = null;
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
		} else {
			for(int i = 0; i < bak-1; i++) {
				resultat = liste[i];
				liste[i] = null;
				bak--;
			}
		}
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		
		for(int i = 0; i < bak-1; i++) {
			liste[i] = liste[i+1];
		}
		bak--;
		
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		T resultat = null;
		
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
			} 
		resultat = liste[bak-1];
	
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if(bak >= liste.length) {
			utvid();
		}
		
		int i = 0;
		while(i < bak && element.compareTo(liste[i]) > 0 ) {
			i++;
		}
//		int j = bak;
//		while(j > i) {
//			liste[j] = liste[j-1];
//			j--;
//		}
		for(int j = i; j < bak +1; j++) {
			liste[j+1] = liste[j];
		}
		
		liste[i] = element;
		bak++;
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		int indeks = 0;
		
		if(inneholder(element)) {
			for(int i = 0; i < bak && !funnet; i++) {
				if(element.equals(liste[i])) {
					liste[i]= null;
					indeks = i;
					for(int posisjon = indeks; posisjon < bak-1; posisjon++) {
						liste[posisjon] = liste[posisjon+1];
						bak--;
						funnet = true;
					}
				}
			}
				
		}
		return element;

	}

	private int finn(T el) {
		boolean funnet = false;
		int i = 0, resultat = IKKE_FUNNET;
		
		while(i < bak && !funnet) {
			if(el.equals(liste[i])) {
				resultat = el.compareTo(liste[i]);
				funnet = true;
				}
			}
		
		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
