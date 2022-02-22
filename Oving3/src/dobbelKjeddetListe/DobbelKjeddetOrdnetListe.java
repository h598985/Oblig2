package dobbelKjeddetListe;

import no.hvl.dat102.dobbelListe.adt.DobbelKjedetOrdnetListeMADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class DobbelKjeddetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeMADT<T> {

	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjeddetOrdnetListe(T minVerdi, T maksVerdi) {
		// Første node
		DobbelNode<T> node1 = new DobbelNode<>(minVerdi);
		foerste = node1;
		// Siste node
		DobbelNode<T> sisteNode = new DobbelNode<>(minVerdi);
		// Kjeding
		node1.setNeste(sisteNode);
		sisteNode.setForrige(sisteNode);
		siste = sisteNode;

		antall = 0;
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();
		while ((el.compareTo(aktuell.getElement()) > 0)) {
			aktuell = aktuell.getNeste();
		}
		// Legg inn foran aktuell
		nyNode.setNeste(aktuell);
		nyNode.setForrige(aktuell.getForrige());
		aktuell.getForrige().setNeste(nyNode);
		aktuell.setForrige(nyNode);
		antall++;

	}

	@Override
	public T fjern(T el) {
		T resultat = null;
		if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");
		DobbelNode<T> aktuell = finn(el);
		if (aktuell != null) {// returner og slett
			resultat = aktuell.getElement();
			aktuell.getForrige().setNeste(aktuell.getNeste());
			aktuell.getNeste().setForrige(aktuell.getForrige());

		}

		return resultat;

	}

	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		DobbelNode<T> aktuelle = foerste;
		DobbelNode<T> node = null;
		boolean funnet = false;

		while (aktuelle != null && !funnet) {

			if (el.compareTo(aktuelle.getElement()) == 0) {
				node = aktuelle;

				funnet = true;
			}

			aktuelle = aktuelle.getNeste();
		}
		return node;
		// TODO

	}

	public boolean erTom() {
		return (antall == 0);
	}

	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

	@Override
	public boolean fins(T el) {
		return finn(el) != null;
	}

	public void visListe() {
		
		DobbelNode<T> p = foerste;
		
		while(p != null) {
			
			System.out.println(p.getElement().toString() + " ");
			
			p = p.getNeste();
		}

	}

}
