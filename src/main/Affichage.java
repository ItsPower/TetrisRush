package main;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Affichage {

	private static Affichage instance;
	
	private int height, width;

	public Affichage() {
		Terminal term;
		try {
			term = TerminalBuilder.terminal();
			height = term.getHeight();
			width = term.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clear();
		String titre = "TETRIS S3 - Projet AGILE";
		curseur(2, width/2-titre.length()/2);
		syso(titre);
		
		
	}
	
	public void syso(String s) {
		System.out.print(s);
	}

	public void curseur(int lig, int col) {
		syso("\033[" + lig + ";" + col + "H");
	}
	
	public void clear() {
		syso("\033[2J");
	}

	public static Affichage getInstance() {
		if(instance == null) {
			instance = new Affichage();
		}
		return instance;
	}

}
