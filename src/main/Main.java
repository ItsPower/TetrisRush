package main;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	private static Main instance;

	public static Affichage aff;
	public static Plateau p;

	public static Piece pi;

	public static void main(String[] args) throws IOException, InterruptedException {

		p = new Plateau(11, 15);
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
		

		pi = new Piece();
		p.piece(pi);
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				pi.translationBas();
				p.piece(pi);
				aff.update();
			}
			
		}, 0, 1000);
		
		Controleur.rawMode();
		Controleur.detectionTouches();
		
		/*Thread.sleep(100);
		}*/
	}

	public static Main getInstance() {
		return instance;
	}

}
