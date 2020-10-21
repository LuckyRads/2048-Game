package com.lucky.game2048.util;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;

/**
 * This class contains grid utilities/tools.
 */
public class GridUtil {

	public static void rearrangeGrid(Grid grid) {
		grid.removeAll();
		for (int y = 0; y < grid.getGridSize(); y++) {
			for (int x = 0; x < grid.getGridSize(); x++) {
				grid.add(grid.getTileAt(x, y));
			}
		}
	}

	public static boolean isMovementAvailable(Tile tile, Tile sideTile, TilePosition tilePosition, Grid grid) {
		return TileUtil.canBeMoved(tile, sideTile, tilePosition, grid.getGridSize()) && !sideTile.isTaken()
				|| TileUtil.canBeMoved(tile, sideTile, tilePosition, grid.getGridSize())
						&& TileUtil.canBeMerged(tile, sideTile);
	}

}
