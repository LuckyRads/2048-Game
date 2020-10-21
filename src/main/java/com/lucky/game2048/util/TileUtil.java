package com.lucky.game2048.util;

import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;

/**
 * This class contains tile utilities/tools.
 */
public class TileUtil {

	public static boolean canBeMerged(Tile tile, Tile sideTile) {
		return sideTile.getValue() == tile.getValue();
	}

	public static boolean canBeMoved(Tile tile, Tile sideTile, TilePosition tilePosition, int gridSize) {
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

	public static Tile generateEmptyTile(Tile tile) {
		return new Tile(tile.getPosX(), tile.getPosY(), -1);
	}

	public static Tile generateSideTile(Tile tile, TilePosition tilePosition, boolean needsMerge) {
		int mergeMultiplier = needsMerge ? 2 : 1;

		switch (tilePosition) {
		case LEFT:
			return new Tile(tile.getPosX() - 1, tile.getPosY(), tile.getValue() * mergeMultiplier);
		case RIGHT:
			return new Tile(tile.getPosX() + 1, tile.getPosY(), tile.getValue() * mergeMultiplier);
		case TOP:
			return new Tile(tile.getPosX(), tile.getPosY() - 1, tile.getValue() * mergeMultiplier);
		case BOTTOM:
			return new Tile(tile.getPosX(), tile.getPosY() + 1, tile.getValue() * mergeMultiplier);
		}
		return null;
	}

}
