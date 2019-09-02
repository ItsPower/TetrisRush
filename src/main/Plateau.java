package main;

public class Plateau {
	
	private boolean[][] plateau;
	
	public Plateau(int x, int y) {
		this.plateau = new boolean[x][y];
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
}
