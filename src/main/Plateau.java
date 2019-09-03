package main;

public class Plateau {
	
	private boolean[][] plateau;
	private int x;
	private int y;
	
	public Plateau(int x, int y) {
		this.plateau = new boolean[x][y];
		this.x = x;
		this.y = y;
	}

	public void setPlateau(boolean[][] plateau) {
		this.plateau = plateau;
	}

	public boolean[][] getPlateau() {
		return plateau;
	}
	
	public void changerCase(int x, int y) {
		this.plateau[x][y] = !this.plateau[x][y];
	}
	
	public void eliminerLignes() {
		boolean lignePleine = true;
		for(int i = plateau[0].length-1 ; i > 0 ; i--) {
			for(int j = 0 ; j < plateau.length ; j++) {
				if(!plateau[j][i]) lignePleine = false;
			}
			if(lignePleine) {
				for(int j = i ; j > 0 ; j--) {
					for(int k = 0 ; k < plateau.length ; k++) {
						plateau[k][j] = plateau[k][j-1];
					}
				}
				Main.getInstance().score += 50;
			}
		}
	}
	
	public void tostring() {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(this.plateau[i][j] == true) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
	public void piece(Piece actuel) {
		Position temp = actuel.getPositionPlateau();
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			/*
			 * Modifie le plateau en X;Y pour afficher la piece et mettre la valeur VRAI dans le plateau
			 * Son ancienne position est supprimé et se met a faux
			 */
			if(actuel.getAnciennePosition() != null && actuel.getAnciennePositionRelative() != null) {
				plateau[actuel.getAnciennePosition().getX() + actuel.getAnciennePositionRelative()[i].getX()][actuel.getAnciennePosition().getY() + actuel.getAnciennePositionRelative()[i].getY()] = false;
				plateau[temp.getX() + actuel.getAnciennePositionRelative()[i].getX()][temp.getY() + actuel.getAnciennePositionRelative()[i].getY()] = false;
				plateau[temp.getX() + actuel.getPositionRelative()[i].getX()][temp.getY() + actuel.getPositionRelative()[i].getY()] = false;
			}
		}
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			/*
			 * Modifie le plateau en X;Y pour afficher la piece et mettre la valeur VRAI dans le plateau
			 * Son ancienne position est supprimé et se met a faux
			 */
			plateau[temp.getX() + actuel.getPositionRelative()[i].getX()][temp.getY() + actuel.getPositionRelative()[i].getY()] = true;
		}
		
		int yMax = 0;
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			if(actuel.getPositionRelative()[i].getY() > yMax) yMax = actuel.getPositionRelative()[i].getY();
		}
		if(actuel.getPositionPlateau().getY() + yMax >= 14 || collisionBas(Main.getInstance().pi)) {
			Main.getInstance().pi = new Piece();
		}
		eliminerLignes();
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
				if(basse.getX() >= 0 && basse.getY() >= 0 && this.plateau[actuel.getPositionPlateau().getX() + basse.getX()][actuel.getPositionPlateau().getY() + basse.getY()+1]) return true;
		}
		return false;
	}
}
