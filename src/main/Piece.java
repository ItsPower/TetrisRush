package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPlateau = new Position(2,0);
	private Position positionRelative[] = new Position[4]; //positionRelative[0] = position principale de la piece
	private Position anciennePosition = new Position(2, 0);
	private Position anciennePositionRelative [] = new Position[4];
	
	public Piece() {
		this.forme = Forme.randomForme();
		positionRelative = forme.getPositionRelative();
		anciennePositionRelative = positionRelative;
	}
	
	public Position[] rotationG() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			anciennePositionRelative[i] = positionRelative[i];
			positionRelative[i] = new Position(positionRelative[i].getY(), positionRelative[i].getX()*-1);
			positionTemp[i] = new Position(positionRelative[i].getY(), positionRelative[i].getX()*-1);
		}
			return positionTemp;
	}
	
	public Position[] rotationD() {
		Position[] positionTemp = new Position[4];
		for(int i = 0; i < 4; i++) {
			anciennePositionRelative[i] = positionRelative[i];
			positionRelative[i] = new Position(positionRelative[i].getY()*-1, positionRelative[i].getX());
			positionTemp[i] = new Position(positionRelative[i].getY()*-1, positionRelative[i].getX());
		}
		return positionTemp;
	}
	
	/*
	 * Ajouter conditions collision avec plateau et autres pieces
	 */
	
	public Position translationGauche() {
		anciennePosition.setPosition(positionPlateau.getX(), positionPlateau.getY());
		positionPlateau.setPosition(positionPlateau.getX() - 1, positionPlateau.getY());
		return new Position(positionPlateau.getX() -1, positionPlateau.getY());
	}
	
	public Position translationDroite() {
		anciennePosition.setPosition(positionPlateau.getX(), positionPlateau.getY());
		positionPlateau.setPosition(positionPlateau.getX() + 1, positionPlateau.getY());
		return new Position(positionPlateau.getX() + 1, positionPlateau.getY());
	}
	
	public Position translationBas() {
		anciennePosition.setPosition(positionPlateau.getX(), positionPlateau.getY());
		positionPlateau.setPosition(positionPlateau.getX(), positionPlateau.getY() + 1);
		return new Position(positionPlateau.getX(), positionPlateau.getY() + 1);
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

	public Position getAnciennePosition() {
		return anciennePosition;
	}

	public Position[] getAnciennePositionRelative() {
		return anciennePositionRelative;
	}
}
