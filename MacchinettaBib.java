package application;

import java.util.ArrayList;

public class MacchinettaBib {
	
	ArrayList <chiavetta> lista;

	public MacchinettaBib() {
		lista = new ArrayList <>();
	}
	
	public void addChiavetta(chiavetta c1) {
		
		lista.add(c1);
	}
	
	public boolean erogaC(String codice) {
		boolean ok = false;
		for (chiavetta c1: lista) {
			
			if (c1.codice.equalsIgnoreCase(codice)) {
				
				if (c1.credito >= 2) {
					
					ok = true;
				
				c1.credito -= 2;
			}
		}}
		return ok;
	
	}
			
			public boolean erogaT(String codice) {
				boolean ok = false;
				for (chiavetta c1: lista) {
					
					if (c1.codice.equalsIgnoreCase(codice)) {
						
						if (c1.credito >= 3) {
							

						c1.credito -= 3;
						ok = true;
					}
				}		
	}
				return ok;
			
			}
	public  boolean erogaA(String codice) {
		boolean ok = false;
				for (chiavetta c1: lista) {
					
					if (c1.codice.equalsIgnoreCase(codice)) {
						
						if (c1.credito >= 1) {
						
						c1.credito -= 1;
						ok = true;
					}
				}		
	}
				
				return ok;
				
	
	
	}
	
	public int getCredito(String codice) {
		int cred = 0;
		for (chiavetta c1: lista) {
			
			if (c1.codice.equalsIgnoreCase(codice)) {
				
				cred = c1.credito;
				
			}
	}
	
	return cred;

}
	public boolean getAccesso(String codice) {
		boolean ok = false;
		for (chiavetta c1: lista) {
			
			if (c1.codice.equalsIgnoreCase(codice)) {
				
				ok = true;
				
			}
	}
	
	return ok;
	}



}
