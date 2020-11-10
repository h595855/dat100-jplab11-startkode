package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	
	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		innleggstabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];

	}

	public int getAntall() {
		return nesteledig;
	}
	
	
	public Innlegg[] getSamling() {
		return innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		for(int i = 0; i < nesteledig; i++) {
			
			if(innleggstabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if(finnInnlegg(innlegg) != -1) {
			return true;
			}
		return false;
	}

	public boolean ledigPlass() {
		for(int i = 0; i < innleggstabell.length; i++) {
			if(innleggstabell[i] == null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		
			if(!finnes(innlegg) && ledigPlass()) {
				innleggstabell[nesteledig] = innlegg;
				nesteledig++;
				return true;
			
		}
		return false;
	}
	
	public String toString() {
		
		String str = getAntall() + "\n"; 
		
		for(int i = 0; i < nesteledig; i++) {
			str += innleggstabell[i].toString();
		}
		System.out.println(str);
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utv = new Innlegg[innleggstabell.length*2];
		
		for(int i = 0; i < innleggstabell.length;i++) {
			
			utv[i] = innleggstabell[i];
		}
		innleggstabell = utv;

	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if(!finnes(innlegg) && ledigPlass()) {
			leggTil(innlegg);
			return true;
		}else if(!ledigPlass() && !finnes(innlegg)){
			utvid();
			leggTil(innlegg);
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean slett(Innlegg innlegg) {
		// finner innlegget og setter den til null og går tilbake eit hakk 
		if(finnes(innlegg)) {
			innlegg = null;
			nesteledig--;
			return true;
		}
		return false;
	}
	
//	public int[] search(String keyword) {
//		
//		
//		
//
//	}
}