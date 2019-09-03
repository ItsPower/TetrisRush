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
	
	public boolean checkAllLignes() {
		for(int i = 0; i < x; i++) {
			if(checkLigneV(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkLigneV(int idx) {
		for(int i = 0; i < this.y; i++) {
			if(!this.plateau[idx][i]) {
				return false;
			}
		}
		return true;
	}
	
	public void setLigne(int idx, boolean b) {
		for(int i = 0; i < y; i++) {
			this.plateau[idx][i] = b;
		}
	}
	
	public void EliminerLignes() {
		while(checkAllLignes()) {
			for(int l = this.x-1; l > 0; l--) {
				if(this.checkLigneV(l)) {
					for(int i = l; i>0; i--){
						plateau[i] = plateau [i-1];
					}
				}
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
				plateau[actuel.getPositionPlateau().getX() + actuel.getAnciennePositionRelative()[i].getX()][actuel.getPositionPlateau().getY() + actuel.getAnciennePositionRelative()[i].getY()] = false;
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
	}
	
	public boolean collisionBas(Piece actuel) {
		for(int i = 0 ; i < actuel.getPositionRelative().length ; i++) {
			
		}
		return false;
	}
}
