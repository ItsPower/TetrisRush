package main;

public class FinDePartie {

	public static boolean fin(Plateau p) {
		for(int i = 0 ; i < 10 ; i++) {
			if(p.getPlateau()[i][0].isFull) return true;
		}
		return false;
	}
}
