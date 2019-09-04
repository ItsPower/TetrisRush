package main;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	private static Main instance;

	public Affichage aff;
	public Plateau p;
	public Piece pi;
	public boolean isInMenu;
	public int selection_menu;
	public int score;

	public static void main(String[] args) throws IOException, InterruptedException {
		instance = new Main();
		instance.p = new Plateau(11, 15);
		instance.aff = Affichage.getInstance();
		instance.pi = new Piece();
		instance.isInMenu = true;
		instance.selection_menu = 1;
		instance.score = 0;
		Controleur.rawMode();
		
		while(instance.isInMenu) {
			
			String titre1 = "JOUER", titre2 = "QUITTER";
			instance.aff.update();
			instance.aff.curseur(16, instance.aff.base_x+instance.aff.PLATEAU_WIDTH/2-titre1.length()/2);
			instance.aff.syso(titre1);
			instance.aff.curseur(28, instance.aff.base_x+instance.aff.PLATEAU_WIDTH/2-titre2.length()/2);
			instance.aff.syso(titre2);
			
			if(instance.selection_menu == 1) {
				instance.aff.curseur(16, instance.aff.base_x+10);
			} else {
				instance.aff.curseur(28, instance.aff.base_x+10);
			}
			instance.aff.syso("<!>");
			
			int c = System.console().reader().read();
			
			System.out.println(c);
			
			if((c == 65 || c == 122) && instance.selection_menu == 2) {
				instance.selection_menu = 1;
			} else if((c == 66 || c == 115) && instance.selection_menu == 1) {
				instance.selection_menu = 2;
			} else if(c==13) {
				if(instance.selection_menu == 1) {
					instance.isInMenu = false;
				} else {
					System.exit(42);
				}
			}
		}
		instance.aff.update();
		instance.p.piece(instance.pi);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if(instance.pi.getPositionPlateau().getY() < 14) instance.pi.translationBas();
				instance.p.piece(instance.pi);
				instance.aff.update();
			}
		}, 0, 650);
		Controleur.detectionTouches();
	}

	public static Main getInstance() {
		return instance;
	}

}
