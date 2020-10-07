package com.lucky.game2048.util;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;

import javax.swing.*;
import java.awt.*;


/**
 * This class contains grid utilities/tools.
 */
public class GridUtil {

    public static Grid extractGridFromFrame(JFrame gameFrame) {
        for (Component component : gameFrame.getContentPane().getComponents()) {
            if (component instanceof Grid) {
                return (Grid) component;
            }
        }
        return null;
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

    public static boolean canBeMerged(Tile tile, Tile sideTile) {
        return sideTile.getValue() == tile.getValue();
    }

}
