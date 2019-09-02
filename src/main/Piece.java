package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPrincipale = new Position(0,0); //Fixe au centre du plateau
	
	public Piece(Forme forme) {
		this.forme = forme;
	}
	
	public boolean rotation() {
		return false;
	}
	
}
