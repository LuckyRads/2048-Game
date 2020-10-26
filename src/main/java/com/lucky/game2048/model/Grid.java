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
	private static Color COLOR = Color.DARK_GRAY;

	public Grid(int gridSize, List<Tile> tiles, Dimension dimension) {
		this.gridSize = gridSize;
		this.tiles = tiles;
		generateGrid();
		generateTile();
		this.setLayout(new GridLayout(gridSize, gridSize, 10, 10));
		this.setBackground(this.COLOR);
		this.setPreferredSize(dimension);
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

	public void addTile(Tile tile) {
		this.tiles.add(tile);
		this.add(tile);
	}

	public void removeTile(Tile tile) {
		this.tiles.remove(tile);
		this.remove(tile);
	}

	public void replaceTile(Tile tileToReplace, Tile replacementTile) {
		removeTile(tileToReplace);
		addTile(replacementTile);
	}

	private void generateGrid() {
		for (int y = 0; y < this.gridSize; y++) {
			for (int x = 0; x < this.gridSize; x++) {
				addTile(new Tile(x, y, -1));
			}
		}
	}

	public void generateTile() {
		int tileValue = NumberUtil.generateRandomTileNumber();
		int tilePosX = NumberUtil.generateRandomNumber(0, this.gridSize);
		int tilePosY = NumberUtil.generateRandomNumber(0, this.gridSize);

		while (true) {
			if (!getTileAt(tilePosX, tilePosY).isTaken()) {
				replaceTile(getTileAt(tilePosX, tilePosY), new Tile(tilePosX, tilePosY, tileValue));
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

}
