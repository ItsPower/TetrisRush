package main;

public enum Forme {
	
	CARRE(new Position[] {
			new Position(0,0),
			new Position(1,0),
			new Position(-1,1),
			new Position(0,-1)
	}),
	LIGNE(new Position[] {
			new Position(0,0),
			new Position(0,1),
			new Position(0,2),
			new Position(0,3)
	}),
	ESCD(new Position[] {
			new Position(0,0),
			new Position(1,0),
			new Position(-1,-1),
			new Position(0,-1)
	}),
	ESCG(new Position[] {
			new Position(0,0),
			new Position(-1,0),
			new Position(0,1),
			new Position(1,-1)
	}),
	T(new Position[] {
			new Position(0,0),
			new Position(-1,0),
			new Position(1,0),
			new Position(0,-1)
	}),
	LG(new Position[] {
			new Position(0,0),
			new Position(0,1),
			new Position(0,2),
			new Position(-1,2)
	}),
	LD(new Position[] {
			new Position(0,0),
			new Position(0,1),
			new Position(0,2),
			new Position(1,2)
	});

	private Position[] positionRelative;
	
	private Forme(Position[] positionRelative) {
		this.positionRelative = positionRelative;
	}
	
	public Position[] getPositionRelative() {
		return positionRelative;
	}
	
}
