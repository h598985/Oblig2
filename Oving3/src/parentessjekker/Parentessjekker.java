package parentessjekker;

import no.hvl.dat102.stabel.kjedet.KjedetStabel;
import no.hvl.dat102.stabel.kjedet.StabelADT;

public class Parentessjekker implements ParentessjekkerADT {

	@Override
	public boolean erVenstreparentes(char p) {
	
		return (p =='(' || p == '[' || p == '{');
	}

	@Override
	public boolean erHogreparentes(char p) {
		
		return (p ==')' || p == ']' || p == '}');
	}

	@Override
	public boolean erParentes(char p) {
		
		return (erVenstreparentes( p) || erHogreparentes( p));
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		
		return ((venstre == '(' && hogre == ')') ||
				(venstre == '[' && hogre == ']')||
				(venstre == '{' && hogre == '}')
				);

	}

	@Override
	public boolean erBalansert(String s) {
		
		StabelADT<Character> stabel = new  KjedetStabel<>();
		
		int tegnLengde = s.length();
		
		boolean erBalansert = true;
		int i = 0;
		char nesteTegn = ' ';
		
		while(erBalansert && i < tegnLengde ) {
			
			nesteTegn = s.charAt(i);
			
			switch(nesteTegn) {
			case '(': case '[': case '{':
				stabel.push(nesteTegn);
				break;
			case ')': case ']': case '}':
				if(stabel.erTom()) {
					erBalansert = false;
				} else {
					char venstre = stabel.pop();
					erBalansert = erPar(venstre, nesteTegn);
				}
				break;
				default: break;
			}
			
			i++;
		}
	if(!stabel.erTom()) {
		erBalansert = false;
	}
		
		return erBalansert;
	}

}
