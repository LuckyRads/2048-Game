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

    public Tile getSideTile(Tile tile, TilePosition tilePosition) {
        switch (tilePosition) {
            case LEFT:
                return getTileAt(tile.getPosX() - 1, tile.getPosY());
            case RIGHT:
                return getTileAt(tile.getPosX() + 1, tile.getPosY());
            case TOP:
                return getTileAt(tile.getPosX(), tile.getPosY() - 1);
            case BOTTOM:
                return getTileAt(tile.getPosX(), tile.getPosY() + 1);
        }
        return null;
    }

    public boolean areMergeable(Tile tile, Tile sideTile) {
        return sideTile.getValue() == tile.getValue();
    }

    public boolean canBeMoved(Tile tile, Tile sideTile, TilePosition tilePosition) {
        switch (tilePosition) {
            case LEFT:
                return tile != null && sideTile != null && tile.getPosX() > 0 && tile.isTaken();
            case RIGHT:
                return tile != null && sideTile != null && tile.getPosX() < gridSize - 1 && tile.isTaken();
            case TOP:
                return tile != null && sideTile != null && tile.getPosY() > 0 && tile.isTaken();
            case BOTTOM:
                return tile != null && sideTile != null && tile.getPosY() < gridSize - 1 && tile.isTaken();
        }
        return false;
    }

    public void moveTilePair(Tile tile, Tile sideTile, TilePosition tilePosition) {
        // TODO: Fix this
        tile = getSideTile(tile, tilePosition);
        sideTile = getSideTile(tile, tilePosition);
    }

}
