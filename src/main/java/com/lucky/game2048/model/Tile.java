package com.lucky.game2048.model;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JLabel;

/**
 * This class is responsible for all operations associated with the grid element
 * tile.
 */
public class Tile extends JLabel {

	private int posX;
	private int posY;
	private int value;
	private HashMap<Integer, Color> colorMap = new HashMap<Integer, Color>();

	public Tile(int posX, int posY, int value) {
		this.posX = posX;
		this.posY = posY;
		this.value = value;

		assignColorMap();

		this.setOpaque(true);
		this.setText(getTileGridValue());
		this.setFont(this.getFont().deriveFont(50f));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setBackground(colorMap.get(value));
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private void assignColorMap() {
		colorMap.put(-1, Color.GRAY);
		colorMap.put(2, Color.LIGHT_GRAY);
		colorMap.put(4, Color.LIGHT_GRAY);
		colorMap.put(8, Color.PINK);
		colorMap.put(16, Color.PINK);
		colorMap.put(32, Color.ORANGE);
		colorMap.put(64, Color.ORANGE);
		colorMap.put(128, Color.RED);
		colorMap.put(256, Color.RED);
		colorMap.put(512, Color.CYAN);
		colorMap.put(1024, Color.CYAN);
		colorMap.put(2048, Color.MAGENTA);
	}

	public String getTileGridValue() {
		return isTaken() ? Integer.toString(this.value) : " ";
	}

	public boolean isTaken() {
		return this.value > 0 && this.value <= 2048;
	}

}
