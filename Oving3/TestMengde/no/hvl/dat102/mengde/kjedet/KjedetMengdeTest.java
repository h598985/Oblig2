/**
 * 
 */
package no.hvl.dat102.mengde.kjedet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;

/**
 * @author hamidnazari
 *
 */
class KjedetMengdeTest {
	
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



		assertEquals(begge, (m1.snitt(m2)));

	}
	@Test	
	void differensTest() {
//		mengde 1
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		m1.leggTil(e5);
		m1.leggTil(e6);
		
//		mengde 2
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
//		mengde d = mengde 1-mengde 2
		
		begge.leggTil(e5);
		begge.leggTil(e6);
		



		assertEquals(begge, m1.differens(m2));


	}
	

	@Test
	
	void undermengdeTest() { // this method works as it is supposed to
		
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
	
		
		begge.leggTil(e0);
		begge.leggTil(e1);
		begge.leggTil(e2);
		begge.leggTil(e3);
		begge.leggTil(e4);


		assertEquals(true, m1.undermengde(m2));

	}

}
