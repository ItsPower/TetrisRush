package main;

public class Test {

	public static void main(String[] args) {

		Plateau p = new Plateau(15, 10);
		p.setLigne(14, true);
		p.setLigne(13, true);
		p.changerCase(10, 5);
		p.changerCase(2, 4);
		p.EliminerLignes();
		p.tostring();

	}

}
