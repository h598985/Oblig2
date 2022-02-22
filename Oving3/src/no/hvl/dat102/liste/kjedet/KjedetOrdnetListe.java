package no.hvl.dat102.liste.kjedet;

import no.hvl.dat102.liste.adt.OrdnetListeADT;
import no.hvl.dat102.liste.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		T resultat = foerste.getElement();
		
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
			} else {
				foerste = foerste.getNeste();
				if(antall == 1) {
					siste = null;
				}
				antall--;
			}

		return resultat;
	}

	@Override
	public T fjernSiste() {
		T resultat = siste.getElement();
		LinearNode<T> nesteSiste = foerste;
		if (erTom()) {
			throw new EmptyCollectionException("ordnet liste");
			} 
		else if(antall == 1) {
			foerste = null;
			siste = null;
			antall--;
		} else {
			for(int i = 1; i < antall; i++) {
				nesteSiste = foerste.getNeste();
				siste = null;
				siste = nesteSiste;	
				antall--;
			}
		}
		

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		
		LinearNode<T> nyNode = new LinearNode<>(element);
		LinearNode<T> aktuelle = foerste;
		LinearNode<T> forrige = null;
		
		if(erTom()) {
			foerste = nyNode;
			siste = nyNode;
		}
		
		while(aktuelle != null && element.compareTo(aktuelle.getElement())>0) {
			forrige = aktuelle;
			aktuelle = aktuelle.getNeste();
		}
		
//		if(aktuelle == null) {
//			forrige.setNeste(nyNode);
//			siste = nyNode;
//		}
//		else {
//			forrige.setNeste(nyNode);
//			nyNode.setNeste(aktuelle);
//		}
		
		if(forrige == null) {
			foerste = nyNode;
			nyNode.setNeste(aktuelle);
		}
		else {
			forrige.setNeste(nyNode);
			nyNode.setNeste(aktuelle);	
		}
		
		if(aktuelle == null) {
			siste = nyNode;
		}

		antall++;

	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // F�rste element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
