package no.hvl.dat102.mengde.tabell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

class TabellMengdeTest {
	
	MengdeADT<Integer> m1;
	MengdeADT<Integer> m2;
	MengdeADT<Integer> begge;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;
	
	
	@BeforeEach
	public void setUp() {
		
		 m1 = new KjedetMengde();
		 m2 = new KjedetMengde();
		 begge = new KjedetMengde();
	}

	@Test
	
	void unionTest() {
		
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);
	
		assertEquals(begge,(m1.union(m2)));
	}
	@Test
	void snittTest() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);
	
		assertEquals(begge,(m1.snitt(m2)));
	}

	@Test
	void differensTest() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m1.leggTil(e5);
		m1.leggTil(e6);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
	
		begge.leggTil(e5);
		begge.leggTil(e6);
	
		assertEquals(begge,(m1.differens(m2)));
	}


}
