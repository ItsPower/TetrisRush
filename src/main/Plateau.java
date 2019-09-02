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
	
}
