package com.lucky.game2048.model;

import com.lucky.game2048.util.NumberUtil;

import java.util.List;

public class Grid {

    private int size;
    private List<Tile> tiles;

    public Grid(int size, List<Tile> tiles) {
        this.size = size;
        this.tiles = tiles;
        generateGrid();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    private void generateGrid() {
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.tiles.add(new Tile(x, y, -1));
            }
        }
    }

    public void draw() {
        String format = "%5s";
        System.out.println("----------------------");
        for (int y = 0; y < this.size; y++) {
            System.out.print("|");
            for (int x = 0; x < this.size; x++) {
                System.out.printf(format, getTileAt(x, y).getTileGridValue());
            }
            System.out.print("|\n");
        }
        System.out.println("----------------------");
    }

    public void generateTile() {
        int tileValue = NumberUtil.generateRandomTileNumber();
        int tilePosX = NumberUtil.generateRandomNumber(0, this.size);
        int tilePosY = NumberUtil.generateRandomNumber(0, this.size);

        while (true) {
            if (!getTileAt(tilePosX, tilePosY).isTaken()) {
                this.tiles.remove(getTileAt(tilePosX, tilePosY));
                this.tiles.add(new Tile(tilePosX, tilePosY, tileValue));
                return;
            }
            tilePosX = NumberUtil.generateRandomNumber(0, this.size);
            tilePosY = NumberUtil.generateRandomNumber(0, this.size);
        }
    }

    private Tile getTileAt(int x, int y) {
        for (Tile tile : this.tiles) {
            if (tile.getPosX() == x && tile.getPosY() == y) {
                return tile;
            }
        }
        return null;
    }

    public boolean moveLeft() {
        boolean actionMade = false;

        // TODO: Optimize this
        for (int i = 0; i < this.size * this.size; i++) {
            for (int y = 0; y < this.size; y++) {
                for (int x = 0; x < this.size; x++) {
                    Tile tile = getTileAt(x, y);
                    Tile sideTile = getTileAt(x - 1, y);

                    if (tile.getPosX() > 0 && tile.isTaken()) {
                        actionMade = true;

                        if (!sideTile.isTaken()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x - 1, y, tile.getValue());
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        } else if (sideTile.getValue() == tile.getValue()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x - 1, y, tile.getValue() * 2);
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        }
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveRight() {
        boolean actionMade = false;

        // TODO: Optimize this
        for (int i = 0; i < this.size * this.size; i++) {
            for (int y = 0; y < this.size; y++) {
                for (int x = 0; x < this.size; x++) {
                    Tile tile = getTileAt(x, y);
                    Tile sideTile = getTileAt(x + 1, y);

                    if (tile.getPosX() < this.size - 1 && tile.isTaken()) {
                        actionMade = true;

                        if (!sideTile.isTaken()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x + 1, y, tile.getValue());
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        } else if (sideTile.getValue() == tile.getValue()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x + 1, y, tile.getValue() * 2);
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        }
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveUp() {
        boolean actionMade = false;

        // TODO: Optimize this
        for (int i = 0; i < this.size * this.size; i++) {
            for (int y = 0; y < this.size; y++) {
                for (int x = 0; x < this.size; x++) {
                    Tile tile = getTileAt(x, y);
                    Tile sideTile = getTileAt(x, y - 1);

                    if (tile.getPosY() > 0 && tile.isTaken()) {
                        actionMade = true;

                        if (!sideTile.isTaken()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x, y - 1, tile.getValue());
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        } else if (sideTile.getValue() == tile.getValue()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x, y - 1, tile.getValue() * 2);
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        }
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveDown() {
        boolean actionMade = false;

        // TODO: Optimize this
        for (int i = 0; i < this.size * this.size; i++) {
            for (int y = 0; y < this.size; y++) {
                for (int x = 0; x < this.size; x++) {
                    Tile tile = getTileAt(x, y);
                    Tile sideTile = getTileAt(x, y + 1);

                    if (tile.getPosY() < this.size - 1 && tile.isTaken()) {
                        actionMade = true;

                        if (!sideTile.isTaken()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x, y + 1, tile.getValue());
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        } else if (sideTile.getValue() == tile.getValue()) {
                            this.tiles.remove(tile);
                            this.tiles.remove(sideTile);

                            Tile newSideTile = new Tile(x, y + 1, tile.getValue() * 2);
                            Tile newTile = new Tile(x, y, -1);

                            this.tiles.add(newSideTile);
                            this.tiles.add(newTile);
                        }
                    }
                }
            }
        }
        return actionMade;
    }

}
