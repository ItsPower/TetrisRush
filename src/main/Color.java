package main;

import java.util.Random;

public enum Color {

	BLACK("\u001B[90m", true),
	RED("\u001B[91m", true),
	GREEN("\u001B[92m", true),
	YELLOW("\u001B[93m", true),
	BLUE("\u001B[94m", true),
	PURPLE("\u001B[95m", true),
	CYAN("\u001B[96m", true),
	WHITE("\u001B[97m", true),
	NOCOLOR("", false);
	
	public final String color;
	public final boolean isFull;

	private Color(String color, boolean isFull) {
		this.color = color;
		this.isFull = isFull;
	}
	
	public static Color random() {
		return Color.values()[Math.abs(new Random().nextInt(Color.values().length)-1)];
	}
}
