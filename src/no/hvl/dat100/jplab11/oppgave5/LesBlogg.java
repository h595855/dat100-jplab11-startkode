package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;
import sun.nio.cs.ext.ISCII91;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		int id, likes;
		String bruker, dato , tekst, url, type;
		
	try {
		File file = new File(mappe + filnavn);
		Scanner reader = new Scanner(file);
		
		int antallInnlegg = Integer.parseInt(reader.nextLine());
		Blogg samling = new Blogg(antallInnlegg);
		
		while(reader.hasNextLine()) {
					
			 type = reader.nextLine();
			 id = Integer.parseInt(reader.nextLine());
			 bruker = reader.nextLine();
			 dato = reader.nextLine();
			 likes = Integer.parseInt(reader.nextLine());
			 tekst = reader.nextLine();
				
				
			 	if(type.equals(BILDE)){
			 		url = reader.nextLine();
					Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(bildeInnlegg);
			 	}
			 	else if(type.equals(TEKST)) {
			 		Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
			 			samling.leggTil(tekstInnlegg);
			 	}
		}
		reader.close();
		return samling;
			  
		
		
			}catch(FileNotFoundException e) {
				System.out.println("piss on ur grave");
		}
	return null;
	}
  }
