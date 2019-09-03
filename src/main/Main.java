package main;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	private static Main instance;
	
	public static Affichage aff;
	public static Plateau p;

	public static void main(String[] args) throws IOException, InterruptedException {

		p = new Plateau(15, 10);
		//p.setLigne(14, true);
		//p.setLigne(13, true);
		//p.changerCase(10, 5);
		//p.changerCase(2, 4);
		//p.EliminerLignes();

		aff = Affichage.getInstance();
		
		/*new Thread(new Runnable() {
			@Override
			public void run() {
				Controleur.
			}
		}).start();*/
		
		/*while(true) {
			aff.update();*/
			Controleur.rawMode();
			Controleur.detectionTouches();
			/*Thread.sleep(100);
		}*/
	}
	
	public static Main getInstance() {
		return instance;
	}

}
