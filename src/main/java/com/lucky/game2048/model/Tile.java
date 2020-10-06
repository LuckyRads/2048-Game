package com.lucky.game2048.model;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Tile extends JLabel {

    private int posX;
    private int posY;
    private int value;
    private HashMap<Integer, Color> colorMap = new HashMap<Integer, Color>();

    public Tile(int posX, int posY, int value) {
        this.posX = posX;
        this.posY = posY;
        this.value = value;

        this.setOpaque(true);
        this.setText(getTileGridValue());
        this.setFont(this.getFont().deriveFont(50f));

        colorMap.put(-1, Color.PINK);
        colorMap.put(2, Color.GREEN);
        colorMap.put(4, Color.CYAN);
        this.setBackground(colorMap.get(this.value));
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

    public String getTileGridValue() {
        return isTaken() ? Integer.toString(this.value) : " ";
    }

    public boolean isTaken() {
        return this.value > 0 && this.value <= 2048;
    }

}
