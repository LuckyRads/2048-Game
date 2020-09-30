package com.lucky.game2048.model;

public class Tile {

    private int posX;
    private int posY;
    private int value;

    public Tile(int posX, int posY, int value) {
        this.posX = posX;
        this.posY = posY;
        this.value = value;
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

    public boolean moveLeft() {
        if (this.isTaken() && this.posX - 1 > 0) {
            this.posX--;
            return true;
        }
        return false;
    }

}
