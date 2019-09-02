package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPlateau = new Position(2,0);
	private Position positionRelative[] = new Position[4]; //positionRelative[0] = position principale de la piece
	
	public Piece() {
		this.forme = Forme.randomForme();
		positionRelative = forme.getPositionRelative();
	}
	
	public boolean rotationG() {
		for(int i = 0; i < 4; i++) {
			positionRelative[i].setPosition(positionRelative[i].getY(), positionRelative[i].getX()*-1);
		}
			return true;
		}
	public boolean rotationD() {
		for(int i = 0; i < 4; i++) {
			positionRelative[i].setPosition(positionRelative[i].getY()*-1, positionRelative[i].getX());
		}
		return true;
	}
	
	
	/*
	 * Ajouter conditions collision avec plateau et autres pieces
	 */
	public boolean translationGauche() {
		positionPlateau.setX(positionPlateau.getX() - 1);
		return true;
	}
	
	public boolean translationDroite() {
		positionPlateau.setX(positionPlateau.getX() + 1);
		return true;
	}
	
	public boolean translationBas() {
		positionPlateau.setY(positionPlateau.getY() - 1);
		return true;
	}
}
