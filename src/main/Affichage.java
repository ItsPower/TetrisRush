package main;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Affichage implements KeyListener {

	private static Affichage instance;
	
	private int term_height, term_width;
	private int base_x, base_y;
	
	private final int TAILLE_X_CUBE = 4, TAILLE_Y_CUBE = 2;
	private final int PLATEAU_WIDTH = 40, PLATEAU_HEIGHT = 30;

	public Affichage() {
		Terminal term;
		try {
			term = TerminalBuilder.terminal();
			term_height = term.getHeight();
			term_width = term.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clear();
		String titre = "TETRIS S3 - Projet AGILE";
		curseur(3, term_width/2-titre.length()/2);
		syso(titre);
		
		base_x = term_width/2-PLATEAU_WIDTH/2;
		base_y = 8;
		
		for(int x=base_x-4; x<base_x+PLATEAU_WIDTH+4; x++)
			for(int y=6; y<PLATEAU_HEIGHT+10; y++) {
				curseur(y, x);
				syso("█");
			}
		for(int x=base_x; x<base_x+PLATEAU_WIDTH; x++)
			for(int y=base_y; y<PLATEAU_HEIGHT+base_y; y++) {
				curseur(y, x);
				syso(" ");
			}
	}
	
	public void printPiece(Piece p) {
		
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

	@Override
	public void keyTyped(KeyEvent e) {
		syso("COUCOU");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		syso("COUCOU");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
