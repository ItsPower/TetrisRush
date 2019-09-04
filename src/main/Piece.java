package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPlateau = new Position(4,0);
	private Position positionRelative[] = new Position[4]; //positionRelative[0] = position principale de la piece
	private Position anciennePosition = new Position(4, 0);
	private Position anciennePositionRelative[] = new Position[4];
	
	public Piece() {
		this.forme = Forme.randomForme();
		for(int i = 0 ; i < 4 ; i++) {
			positionRelative[i] = new Position(forme.getPositionRelative()[i]);
		}
		anciennePositionRelative = positionRelative;
	}
	
	public Position[] rotationG() {
		Position[] positionTemp = new Position[4];
		for(int i = 0 ; i < 4 ; i++) {
			positionTemp[i] = new Position(positionRelative[i].getY(), positionRelative[i].getX()*-1);
		}
		if(!collisionRotation(positionTemp)) {
			for(int i = 0; i < 4; i++) {
				Main.getInstance().p.getPlateau()[positionPlateau.getX() + positionRelative[i].getX()][positionPlateau.getY() + positionRelative[i].getY()] = false;
				anciennePositionRelative[i] = new Position(positionRelative[i]);
				positionRelative[i].setPosition(positionRelative[i].getY(), positionRelative[i].getX()*-1);
				positionTemp[i] = new Position(positionRelative[i].getY(), positionRelative[i].getX()*-1);
			}
		}
		return positionTemp;
	}
	
	public Position[] rotationD() {
		Position[] positionTemp = new Position[4];
		for(int i = 0 ; i < 4 ; i++) {
			positionTemp[i] = new Position(positionRelative[i].getY()*-1, positionRelative[i].getX());
		}
		if(!collisionRotation(positionTemp)) {
			for(int i = 0; i < 4; i++) {
				Main.getInstance().p.getPlateau()[positionPlateau.getX() + positionRelative[i].getX()][positionPlateau.getY() + positionRelative[i].getY()] = false;
				anciennePositionRelative[i] = new Position(positionRelative[i]);
				positionRelative[i].setPosition(positionRelative[i].getY()*-1, positionRelative[i].getX());
				positionTemp[i] = new Position(positionRelative[i].getY()*-1, positionRelative[i].getX());
			}
		}
		
		return positionTemp;
	}
	
	/*
	 * Ajouter conditions collision avec plateau et autres pieces
	 */
	
	public void translationGauche() {
		if(!collisionCoter(new Position(positionPlateau.getX() - 1, positionPlateau.getY()))) {
			anciennePosition.setPosition(positionPlateau.getX(), positionPlateau.getY());
			positionPlateau.setPosition(positionPlateau.getX() - 1, positionPlateau.getY());
		}
	}
	
	public void translationDroite() {
		if(!collisionCoter(new Position(positionPlateau.getX() + 1, positionPlateau.getY()))) {
			anciennePosition.setPosition(positionPlateau.getX(), positionPlateau.getY());
			positionPlateau.setPosition(positionPlateau.getX() + 1, positionPlateau.getY());
		}
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
	
	private boolean collisionCoter(Position temp) {
		for(int i = 0 ; i < positionRelative.length ; i++) {
			if(temp.getX() + positionRelative[i].getX() < 0 || temp.getX() + positionRelative[i].getX() > 10) 
				return true;
			if(Main.getInstance().p.collisionCote(temp))
				return true;
		}
		return false;
	}
	
	private boolean collisionRotation(Position[] temp) {
		for(int i = 0 ; i < positionRelative.length ; i++) {
			if(positionPlateau.getX() + temp[i].getX() < 0 || positionPlateau.getX() + temp[i].getX() > 10) 
				return true;
			if(positionPlateau.getY() + temp[i].getY() < 0 || positionPlateau.getY() + temp[i].getY() > 15) 
				return true;
			if(Main.getInstance().p.collisionRotation(temp))
				return true;
		}
		return false;
	}
}
