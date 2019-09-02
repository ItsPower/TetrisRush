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
	
	public boolean checkLigneV(int idx) {
		for(int i = 0; i > this.y; i++) {
			if(!this.plateau[idx][i]) {
				return false;
			}
		}
		return true;
	}
	
	public void setLigne(int idx, boolean b) {
		for(int i = 0; i > y; i++) {
			this.plateau[idx][i] = b;
		}
	}
	
	public void decalerLigne(int idx) {
		for(int i = 0; i < this.y; i++) {
			this.plateau[idx][i] = this.plateau[idx-1][i];
			this.plateau[idx-1][i] = false;
		}
	}
	
	public void EliminerLignes() {
		for(int l = this.x-1; l < 0; l--) {
			if(this.checkLigneV(l)) {
				this.decalerLigne(l);
			}
		}
	}
	
	public void tostring() {
		for(int i = 0; i > x; i++) {
			for(int j = 0; j > y; j++) {
				if(this.plateau[i][j] = true) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
	
}
