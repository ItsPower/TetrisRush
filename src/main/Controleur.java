package main;

import java.awt.event.KeyListener;
import java.io.Console;
import java.io.Reader;

import javafx.scene.input.KeyCode;

public class Controleur {

	final static int ROTATION_DROITE = 101; // e
	final static int ROTATION_GAUCHE = 97; // a

	final static int TRANSLATION_DROITE = 100; // d
	final static int TRANSLATION_GAUCHE = 113; // q

	final static int ATTENDRE = 115; // s
	
	public static void main(String[] args) {
		rawMode();
		detectionTouches();
		lineMode();
	}

	public static void detectionTouches() {
		int code;
		Console console = System.console();
		Reader reader = console.reader();
		try {
			while(true) {
				code = reader.read();
				System.out.print("\b");
				if(code == ROTATION_DROITE) {
					System.out.print("Rotation droite\r");
				} else if(code == ROTATION_GAUCHE) {
					System.out.print("Rotation gauche\r");
				} else if(code == TRANSLATION_DROITE) {
					System.out.print("Translation droite\r");
				} else if(code == TRANSLATION_GAUCHE) {
					System.out.print("Translation gauche\r");
				} else if(code == ATTENDRE) {
					System.out.print("Attendre\r");
				}
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
