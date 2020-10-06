package com.lucky.game2048.model;

import com.lucky.game2048.util.NumberUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class is responsible for all operations associated with the game grid.
 */
public class Grid extends JPanel {

    private int gridSize;
    private List<Tile> tiles;

    public Grid(int gridSize, List<Tile> tiles) {
        this.gridSize = gridSize;
        this.tiles = tiles;
        generateGrid();
        generateTile();
        this.setLayout(new GridLayout(gridSize, gridSize, 10, 10));
        this.setBackground(Color.DARK_GRAY);
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int size) {
        this.gridSize = size;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    private void generateGrid() {
        for (int y = 0; y < this.gridSize; y++) {
            for (int x = 0; x < this.gridSize; x++) {
                this.tiles.add(new Tile(x, y, -1));
            }
        }
    }

    public void generateTile() {
        int tileValue = NumberUtil.generateRandomTileNumber();
        int tilePosX = NumberUtil.generateRandomNumber(0, this.gridSize);
        int tilePosY = NumberUtil.generateRandomNumber(0, this.gridSize);

        while (true) {
            if (!getTileAt(tilePosX, tilePosY).isTaken()) {
                this.tiles.remove(getTileAt(tilePosX, tilePosY));
                this.tiles.add(new Tile(tilePosX, tilePosY, tileValue));
                return;
            }
            tilePosX = NumberUtil.generateRandomNumber(0, this.gridSize);
            tilePosY = NumberUtil.generateRandomNumber(0, this.gridSize);
        }
    }

    public Tile getTileAt(int x, int y) {
        for (Tile tile : this.tiles) {
            if (tile.getPosX() == x && tile.getPosY() == y) {
                return tile;
            }
        }
        return null;
    }

    public boolean moveLeft() {
        boolean actionMade = false;

        for (int y = 0; y < this.gridSize; y++) {
            for (int x = 1; x < this.gridSize; x++) {
                Tile tile = getTileAt(x, y);
                Tile sideTile = getTileAt(x - 1, y);

                while (tile != null && sideTile != null && tile.getPosX() > 0 && tile.isTaken()) {
                    if (!sideTile.isTaken()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(tile.getPosX() - 1, y, tile.getValue());
                        Tile newTile = new Tile(tile.getPosX(), y, -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(newSideTile.getPosX(), y);
                        sideTile = getTileAt(newSideTile.getPosX() - 1, y);

                        actionMade = true;
                    } else if (sideTile.getValue() == tile.getValue()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(tile.getPosX() - 1, y, tile.getValue() * 2);
                        Tile newTile = new Tile(tile.getPosX(), y, -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(newSideTile.getPosX(), y);
                        sideTile = getTileAt(newSideTile.getPosX() - 1, y);

                        actionMade = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveRight() {
        boolean actionMade = false;

        for (int y = 0; y < this.gridSize; y++) {
            for (int x = this.gridSize - 2; x >= 0; x--) {
                Tile tile = getTileAt(x, y);
                Tile sideTile = getTileAt(x + 1, y);

                while (tile != null && sideTile != null && tile.getPosX() < this.gridSize - 1 && tile.isTaken()) {
                    if (!sideTile.isTaken()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(tile.getPosX() + 1, y, tile.getValue());
                        Tile newTile = new Tile(tile.getPosX(), y, -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(newSideTile.getPosX(), y);
                        sideTile = getTileAt(newSideTile.getPosX() + 1, y);

                        actionMade = true;
                    } else if (sideTile.getValue() == tile.getValue()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(tile.getPosX() + 1, y, tile.getValue() * 2);
                        Tile newTile = new Tile(tile.getPosX(), y, -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(newSideTile.getPosX(), y);
                        sideTile = getTileAt(newSideTile.getPosX() + 1, y);

                        actionMade = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveUp() {
        boolean actionMade = false;

        for (int x = 0; x < this.gridSize; x++) {
            for (int y = 1; y < this.gridSize; y++) {
                Tile tile = getTileAt(x, y);
                Tile sideTile = getTileAt(x, y - 1);

                while (tile != null && sideTile != null && tile.getPosY() > 0 && tile.isTaken()) {
                    if (!sideTile.isTaken()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(x, tile.getPosY() - 1, tile.getValue());
                        Tile newTile = new Tile(x, tile.getPosY(), -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(x, newSideTile.getPosY());
                        sideTile = getTileAt(x, newSideTile.getPosY() - 1);

                        actionMade = true;
                    } else if (sideTile.getValue() == tile.getValue()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(x, tile.getPosY() - 1, tile.getValue() * 2);
                        Tile newTile = new Tile(x, tile.getPosY(), -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(x, newSideTile.getPosY());
                        sideTile = getTileAt(x, newSideTile.getPosY() - 1);

                        actionMade = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return actionMade;
    }

    public boolean moveDown() {
        boolean actionMade = false;

        for (int x = 0; x < this.gridSize; x++) {
            for (int y = this.gridSize - 2; y >= 0; y--) {
                Tile tile = getTileAt(x, y);
                Tile sideTile = getTileAt(x, y + 1);

                while (tile != null && sideTile != null && tile.getPosY() < this.gridSize - 1 && tile.isTaken()) {
                    if (!sideTile.isTaken()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(x, tile.getPosY() + 1, tile.getValue());
                        Tile newTile = new Tile(x, tile.getPosY(), -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(x, newSideTile.getPosY());
                        sideTile = getTileAt(x, newSideTile.getPosY() + 1);

                        actionMade = true;
                    } else if (sideTile.getValue() == tile.getValue()) {
                        this.tiles.remove(tile);
                        this.tiles.remove(sideTile);

                        Tile newSideTile = new Tile(x, tile.getPosY() + 1, tile.getValue() * 2);
                        Tile newTile = new Tile(x, tile.getPosY(), -1);

                        this.tiles.add(newSideTile);
                        this.tiles.add(newTile);

                        tile = getTileAt(x, newSideTile.getPosY());
                        sideTile = getTileAt(x, newSideTile.getPosY() + 1);

                        actionMade = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        return actionMade;
    }

}
