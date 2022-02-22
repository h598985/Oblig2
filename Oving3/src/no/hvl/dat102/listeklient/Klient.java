package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.liste.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.liste.tabell.TabellOrdnetListe;

public class Klient {
	
	
	public static void main(String[] args) {
		
		
		KjedetOrdnetListe<Person> kjedetListe = new KjedetOrdnetListe<>();
		TabellOrdnetListe<Person> tabelListe = new TabellOrdnetListe<>();
		
		Scanner scan = new Scanner(System.in); 
		
		

		Person person1 = new Person("karl","karlsen",1998);
		Person person2 = new Person("johan","johansen",1996);
		Person person3 = new Person("petter","carlsen",2000);
		Person person4 = new Person("june","solberg",2002);
		
//		Kjedet liste
		
		kjedetListe.leggTil(person1);
		kjedetListe.leggTil(person2);
		kjedetListe.leggTil(person3);
		kjedetListe.leggTil(person4);
		
//	tabell liste
		
		tabelListe.leggTil(person1);
		tabelListe.leggTil(person2);
		tabelListe.leggTil(person3);
		tabelListe.leggTil(person4);
	
		Person person;
		
		int alder = 0;
		String fornavn = null;
		String etternavn = null;
		
//		
//		for(int i = 1; i <= 3; i++) {
//		System.out.println("Skriv inn din alder");
//		 alder = scan.nextInt();
//		System.out.println("Ditt fornavn");
//		fornavn = scan.nextLine();
//		scan.nextLine();
//		System.out.println("Ditt etternavn");
//		etternavn = scan.nextLine();
//		
//		person = new Person(fornavn, etternavn, alder);
//		
//		kjedetListe.leggTil(person);
//		tabelListe .leggTil(person);
//	
//	}
		
		
//		System.out.println(kjedetListe.antall());
//		
//		while(!kjedetListe.erTom()) {
//			
//			Person p = kjedetListe.fjernFoerste();
//			
//			System.out.println(p.toString());
//		}
		
		System.out.println(tabelListe.antall());
		
		while(!tabelListe.erTom()) {
			
			Person p = tabelListe.fjernFoerste();
			
			System.out.println(p.toString());
		}
			
	}

}
