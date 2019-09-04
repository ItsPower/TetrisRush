package main;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Affichage{

	private static Affichage instance;

	public int term_height, term_width;
	public int base_x, base_y;

	public final int PLATEAU_WIDTH = 44, PLATEAU_HEIGHT = 30; // 40,30

	public Affichage() {
		Terminal term;
		try {
			term = TerminalBuilder.terminal();
			term_height = term.getHeight();
			term_width = term.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}
		update();
	}

	public void update() {
		clear();
		syso("\033[?25l");
		String titre = "TETRIS - Projet AGILE S3";
		curseur(3, term_width/2-titre.length()/2);
		syso(titre);

		base_x = term_width/2-PLATEAU_WIDTH/2;
		base_y = 8;

		for(int x=base_x-4; x<base_x+PLATEAU_WIDTH+4; x++)
			for(int y=6; y<PLATEAU_HEIGHT+10; y++) {
				
				if(x > base_x-1 && x < base_x+PLATEAU_WIDTH 
						&& y > 7 && y < PLATEAU_HEIGHT+8) continue;
				
				
				curseur(y, x);
				syso("█");
			}
		/*for(int x=base_x; x<base_x+PLATEAU_WIDTH; x++) {
			for(int y=base_y; y<PLATEAU_HEIGHT+base_y; y++) {
				curseur(y, x);
				syso(" ");
			}
			
		}*/

		Color[][] plateau = Main.getInstance().p.getPlateau();
		for(int x=0;x<plateau.length;x++)
			for(int y=0;y<plateau[0].length;y++) {
				if(plateau[x][y].isFull) {
					printCube(new Position(x,y), plateau[x][y]);
				}
			}
		if(!Main.getInstance().isInMenu) {
			
			curseur(16, base_x-15);
			syso(Main.getInstance().score+"");
		}
	}

	public void printPiece(Piece p) {
		Position base = p.getPositionPlateau();
		Position[] posis = p.getPositionRelative();
		for(Position tmp : posis) {
			Position pos = new Position(base.getX() + tmp.getX(), base.getY() + tmp.getY());
			printCube(pos, Main.getInstance().p.getPlateau()[pos.getX()][pos.getY()]);
		}
	}

	public void printCube(Position pos, Color c) {

		curseur(base_y + pos.getY()*2, base_x + pos.getX()*4);
		syso(c.color+"████"+Color.WHITE.color);

		curseur(base_y + pos.getY()*2+1, base_x + pos.getX()*4);
		syso(c.color+"████"+Color.WHITE.color);
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
