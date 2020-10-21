package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;
import com.lucky.game2048.util.GridUtil;
import com.lucky.game2048.util.TileUtil;

/**
 * This class controls grid tile movement mechanics and other grid associated
 * methods.
 */
public class GridController {

	private boolean moveTiles(Grid grid, int x, int y, TilePosition tilePosition) {
		boolean actionMade = false;

		Tile tile = grid.getTileAt(x, y);
		Tile sideTile = grid.getSideTile(tile, tilePosition);

		while (GridUtil.isMovementAvailable(tile, sideTile, tilePosition, grid)) {

			actionMade = true;

			grid.removeTile(tile);
			grid.removeTile(sideTile);
			grid.addTile(TileUtil.generateEmptyTile(tile));

			if (!sideTile.isTaken()) {
				grid.addTile(TileUtil.generateSideTile(tile, tilePosition, false));
			} else if (TileUtil.canBeMerged(tile, sideTile)) {
				grid.addTile(TileUtil.generateSideTile(tile, tilePosition, true));
				break;
			}

			tile = grid.getSideTile(tile, tilePosition);
			sideTile = grid.getSideTile(tile, tilePosition);
		}

		return actionMade;
	}

	public boolean moveLeft(Grid grid) {
		boolean actionMade = false;

		for (int y = 0; y < grid.getGridSize(); y++) {
			for (int x = 1; x < grid.getGridSize(); x++) {
				if (!actionMade) {
					actionMade = moveTiles(grid, x, y, TilePosition.LEFT);
				} else {
					moveTiles(grid, x, y, TilePosition.LEFT);
				}
			}
		}
		return actionMade;
	}

	public boolean moveRight(Grid grid) {
		boolean actionMade = false;

		for (int y = 0; y < grid.getGridSize(); y++) {
			for (int x = grid.getGridSize() - 2; x >= 0; x--) {
				if (!actionMade) {
					actionMade = moveTiles(grid, x, y, TilePosition.RIGHT);
				} else {
					moveTiles(grid, x, y, TilePosition.RIGHT);
				}
			}
		}
		return actionMade;
	}

	public boolean moveUp(Grid grid) {
		boolean actionMade = false;

		for (int x = 0; x < grid.getGridSize(); x++) {
			for (int y = 1; y < grid.getGridSize(); y++) {
				if (!actionMade) {
					actionMade = moveTiles(grid, x, y, TilePosition.TOP);
				} else {
					moveTiles(grid, x, y, TilePosition.TOP);
				}
			}
		}
		return actionMade;
	}

	public boolean moveDown(Grid grid) {
		boolean actionMade = false;

		for (int x = 0; x < grid.getGridSize(); x++) {
			for (int y = grid.getGridSize() - 2; y >= 0; y--) {
				if (!actionMade) {
					actionMade = moveTiles(grid, x, y, TilePosition.BOTTOM);
				} else {
					moveTiles(grid, x, y, TilePosition.BOTTOM);
				}
			}
		}
		return actionMade;
	}

}
