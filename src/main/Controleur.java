package main;

import java.io.Console;
import java.io.Reader;

public class Controleur {

	final static int ROTATION_DROITE = 101; // e
	final static int ROTATION_GAUCHE = 97; // a

	final static int TRANSLATION_DROITE = 100; // d
	final static int TRANSLATION_GAUCHE = 113; // q

	final static int ATTENDRE = 115; // s
	
	public static void detectionTouches() {
		int code;
		Console console = System.console();
		Reader reader = console.reader();
		try {
			while(true) { 
				code = reader.read();
				System.out.print("\b");
				System.out.println(code);
				
				if(code == ROTATION_DROITE) {
					Main.getInstance().pi.rotationD();
					
				} else if(code == ROTATION_GAUCHE) {
					Main.getInstance().pi.rotationG();
					
				} else if(code == TRANSLATION_DROITE) {
					Main.getInstance().pi.translationDroite();
					
				} else if(code == TRANSLATION_GAUCHE) {
					Main.getInstance().pi.translationGauche();
					
				} else if(code == ATTENDRE) {
					Main.getInstance().pi.translationBas();
					
				}
				
				Main.getInstance().p.piece(Main.getInstance().pi);
				Main.getInstance().aff.update();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void rawMode() {
		String[] cmd = { "/bin/sh", "-c", "stty raw </dev/tty" };
		try {
			Runtime.getRuntime().exec(cmd).waitFor();
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	public static void lineMode() {
		String[] cmd = { "/bin/sh", "-c", "stty sane </dev/tty" };
		try {
			Runtime.getRuntime().exec(cmd).waitFor();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
