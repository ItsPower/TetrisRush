package main;

public class Piece {
	
	private Orientation orientation = Orientation.BAS;
	private Forme forme;
	private Position positionPlateau = new Position(2,0);
	private Position positionRelative[] = new Position[4]; //positionRelative[0] = position principale de la piece
	
	public Piece(Forme forme) {
		this.forme = forme;
		positionRelative = forme.getPositionRelative();
	}
	
	public boolean rotation() {
		return false;
	}
	
	public boolean translation() {
		return false;
	}
	
}
