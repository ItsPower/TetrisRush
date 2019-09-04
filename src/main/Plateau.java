package main;

public class Plateau {
	
	private Color[][] plateau;
	private int x;
	private int y;
	
	public Plateau(int x, int y) {
		this.plateau = new Color[x][y];
		for(int i=0; i<x;i++)
			for(int j=0; j<y;j++) {
				plateau[i][j] = Color.NOCOLOR;
			}
		this.x = x;
		this.y = y;
	}

	public void setPlateau(Color[][] plateau) {
		this.plateau = plateau;
	}

	public Color[][] getPlateau() {
		return plateau;
	}
	
	public void eliminerLignes() {
		for(int i = plateau[0].length-1 ; i > 0 ; i--) {
			boolean lignePleine = true;
			for(int j = 0 ; j < plateau.length ; j++) {
				if(!plateau[j][i].isFull) lignePleine = false;
			}
			if(lignePleine) {
				for(int j = i ; j > 0 ; j--) {
					for(int k = 0 ; k < plateau.length ; k++) {
						plateau[k][j] = plateau[k][j-1];
					}
				}
				if(Main.getInstance().score < 300) {
					Main.getInstance().score += 50;
				}
				if(Main.getInstance().score >= 300 && Main.getInstance().score < 600) {
					Main.getInstance().score += 75;
				}
				if(Main.getInstance().score >= 600 && Main.getInstance().score < 1000) {
					Main.getInstance().score += 100;
				}
				if(Main.getInstance().score >= 1000 && Main.getInstance().score < 200) {
					Main.getInstance().score += 200;
				}
				Main.getInstance().max *= 0.95;
			}
		}
	}
	
	public void piece(Piece actuel) {
		Position temp = actuel.getPositionPlateau();
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			/*
			 * Modifie le plateau en X;Y pour afficher la piece et mettre la valeur VRAI dans le plateau
			 * Son ancienne position est supprimé et se met a faux
			 */
			if(actuel.getAnciennePosition() != null && actuel.getAnciennePositionRelative() != null && actuel.getAnciennePosition().getX() + actuel.getAnciennePositionRelative()[i].getX() >= 0 && actuel.getAnciennePosition().getY() + actuel.getAnciennePositionRelative()[i].getY() >= 0) {
				try {
					plateau[actuel.getAnciennePosition().getX() + actuel.getAnciennePositionRelative()[i].getX()][actuel.getAnciennePosition().getY() + actuel.getAnciennePositionRelative()[i].getY()] = Color.NOCOLOR;
				} catch(ArrayIndexOutOfBoundsException e) {
					//e.printStackTrace();
				}
				//plateau[temp.getX() + actuel.getAnciennePositionRelative()[i].getX()][temp.getY() + actuel.getAnciennePositionRelative()[i].getY()] = false;
				//plateau[temp.getX() + actuel.getPositionRelative()[i].getX()][temp.getY() + actuel.getPositionRelative()[i].getY()] = false;
			}
		}
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			/*
			 * Modifie le plateau en X;Y pour afficher la piece et mettre la valeur VRAI dans le plateau
			 * Son ancienne position est supprimé et se met a faux
			 */
			try {
				plateau[actuel.getPositionPlateau().getX() + actuel.getPositionRelative()[i].getX()][actuel.getPositionPlateau().getY() + actuel.getPositionRelative()[i].getY()] = actuel.getColor();
			} catch(ArrayIndexOutOfBoundsException e) {
				//e.printStackTrace();
			}
		}
		
		int yMax = 0;
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			if(actuel.getPositionRelative()[i].getY() > yMax) yMax = actuel.getPositionRelative()[i].getY();
		}
		if(actuel.getPositionPlateau().getY() + yMax >= 14 || collisionBas(Main.getInstance().pi)) {
			if(FinDePartie.fin(Main.getInstance().p)) System.exit(0);
			eliminerLignes();
			Main.getInstance().pi = new Piece();
		}
	} 
	/*
	 * Oui ça marche
	 */
	public boolean collisionBas(Piece actuel) {
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
				Position basse = actuel.getPositionRelative()[i];
				for(int j = 0 ; j < actuel.getPositionRelative().length ; j++) {
					if(i != j && basse.getX() == actuel.getPositionRelative()[j].getX()
							&& actuel.getPositionRelative()[j].getY() > basse.getY()) {
						basse = actuel.getPositionRelative()[j];
					}
				}
				if(basse.getX() >= 0 && basse.getY() >= 0 && this.plateau[actuel.getPositionPlateau().getX() + basse.getX()][actuel.getPositionPlateau().getY() + basse.getY()+1].isFull) return true;
		}
		return false;
	}
	
	public boolean collisionCote(Position temp) {
		Piece actuel = Main.getInstance().pi;
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
				boolean memePiece = false;
				for(int j = 0 ; j < actuel.getPositionRelative().length ; j++) {
					if((temp.getX() + actuel.getPositionRelative()[i].getX()) == (actuel.getPositionPlateau().getX() + actuel.getPositionRelative()[j].getX())
							&& (temp.getY() + actuel.getPositionRelative()[i].getY()) == (actuel.getPositionPlateau().getY() + actuel.getPositionRelative()[j].getY())) memePiece = true;
				}
				if(!memePiece && temp.getX() + actuel.getPositionRelative()[i].getX() >= 0 && temp.getX() + actuel.getPositionRelative()[i].getX() < 10 && plateau[temp.getX() + actuel.getPositionRelative()[i].getX()][temp.getY() + actuel.getPositionRelative()[i].getY()].isFull) return true;
		}
		return false;
	}
	
	public boolean collisionRotation(Position[] temp) {
		Piece actuel = Main.getInstance().pi;
		for(int i = 0 ; i < temp.length ; i++) {
				boolean memePiece = false;
				for(int j = 0 ; j < temp.length ; j++) {
					if((actuel.getPositionPlateau().getX() + temp[i].getX()) == (actuel.getPositionPlateau().getX() + actuel.getPositionRelative()[j].getX())
							&& (actuel.getPositionPlateau().getY() + temp[i].getY()) == (actuel.getPositionPlateau().getY() + actuel.getPositionRelative()[j].getY())) memePiece = true;
				}
				if(!memePiece && actuel.getPositionPlateau().getX() + temp[i].getX() >= 0 && actuel.getPositionPlateau().getX() + temp[i].getX() < 10 && actuel.getPositionPlateau().getY() + temp[i].getY() >= 0 && actuel.getPositionPlateau().getY() + temp[i].getY() < 15  && plateau[actuel.getPositionPlateau().getX() + temp[i].getX()][actuel.getPositionPlateau().getY() + temp[i].getY()].isFull) return true;
		}
		return false;
	}
}