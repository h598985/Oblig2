package no.hvl.dat102.dataKontaktFirma;

import java.util.Objects;

public class Hobby {
	
	private String hobyyNavn;
	
	public Hobby(String hobyyNavn) {
		this.hobyyNavn = hobyyNavn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hobyyNavn);
	}

	@Override
	public boolean equals(Object hobby2) {
		if (this == hobby2)
			return true;
		if (hobby2 == null)
			return false;
		if (getClass() != hobby2.getClass())
			return false;
		Hobby other = (Hobby) hobby2;
		return Objects.equals(hobyyNavn, other.hobyyNavn);
	}
	
	@Override
	public String toString() {
		
		return  "<" + hobyyNavn + ">";
	}
	
	

}
