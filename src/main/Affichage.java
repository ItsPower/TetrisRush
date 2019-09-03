package main;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Affichage {

	private static Affichage instance;
	
	private int term_height, term_width;
	private int base_x, base_y;
	
	private final int PLATEAU_WIDTH = 44, PLATEAU_HEIGHT = 30; // 40,30

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
		curseur(3, term_width / 2 - titre.length() / 2);
		syso(titre);

		base_x = term_width / 2 - PLATEAU_WIDTH / 2;
		base_y = 8;

		for (int x = base_x - 4; x < base_x + PLATEAU_WIDTH + 4; x++) {
			for (int y = 6; y < PLATEAU_HEIGHT + 10; y++) {
				curseur(y, x); syso("█");
			}
		}

		for(int x=base_x; x<base_x+PLATEAU_WIDTH; x++) {
			for (int y = base_y; y < PLATEAU_HEIGHT + base_y; y++) {
				curseur(y, x); syso(" ");
			}
		}
	}
	
	public void printPiece(Piece p) {
		Position base = p.getPositionPlateau();
		Position[] posis = p.getPositionRelative();

		for(Position tmp : posis)
			printCube(new Position(base.getX() + tmp.getX(), base.getY() + tmp.getY()));
	}

	private void printCube(Position pos) { //TODO COULEURS TO ADD
		curseur(base_y + pos.getY()*2, base_x + pos.getX()*4);
		syso("\033[91m████\033[37m");
		
		curseur(base_y + pos.getY()*2+1, base_x + pos.getX()*4);
		syso("\033[91m████\033[37m");
	}
	
	public void syso(String s) {System.out.print(s);}

	public void curseur(int lig, int col) {syso("\033[" + lig + ";" + col + "H");}
	
	public void clear() {syso("\033[2J");}

	public static Affichage getInstance() {
		if(instance == null)
			instance = new Affichage();

		return instance;
	}
}
