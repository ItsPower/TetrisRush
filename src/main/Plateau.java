package main;

public class Plateau {
	
	private boolean[][] plateau;

	public boolean[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(boolean[][] plateau) {
		this.plateau = plateau;
	}
	
	public void changerCase(int x, int y) {
		this.plateau[x][y] = !this.plateau[x][y];
	}
}
