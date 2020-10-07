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

}
