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
	
	public boolean rotation() {
		return false;
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

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Position getPositionPlateau() {
		return positionPlateau;
	}

	public Forme getForme() {
		return forme;
	}

	public Position[] getPositionRelative() {
		return positionRelative;
	}
	
	
}
