package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPlateau = new Position(2,0);
	private Position positionRelative[] = new Position[4]; //positionRelative[0] = position principale de la piece
	private Position anciennePosition;
	private Position anciennePositionRelative [] = new Position[4];
	private Plateau plateau;
	
	public Piece(Plateau plateau) {
		this.forme = Forme.randomForme();
		positionRelative = forme.getPositionRelative();
		
	}
	
	public Position[] rotationG() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			positionTemp[i] = new Position(positionRelative[i].getY(), positionRelative[i].getX()*-1);
		}
			return positionTemp;
	}
	
	public Position[] rotationD() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			positionTemp[i] = new Position(positionRelative[i].getY()*-1, positionRelative[i].getX());
		}
		return positionTemp;
	}
	
	/*
	 * Ajouter conditions collision avec plateau et autres pieces
	 */
	
	public Position[] translationGauche() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			positionTemp[i] = new Position(positionRelative[i].getX() - 1, positionRelative[i].getY());
		}
		return positionTemp;
	}
	
	public Position[] translationDroite() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			positionTemp[i] = new Position(positionRelative[i].getX() + 1, positionRelative[i].getY());
		}
		return positionTemp;
	}
	
	public Position[] translationBas() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			positionTemp[i] = new Position(positionRelative[i].getX(), positionRelative[i].getY() + 1);
		}
		return positionTemp;
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
