package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;
import com.lucky.game2048.util.GridUtil;
import com.lucky.game2048.util.TileUtil;

/**
 * This class controls grid tile movement mechanics and other grid associated methods.
 */
public class GridController {

    public boolean moveLeft(Grid grid) {
        boolean actionMade = false;

        for (int y = 0; y < grid.getGridSize(); y++) {
            for (int x = 1; x < grid.getGridSize(); x++) {

                Tile tile = grid.getTileAt(x, y);
                Tile sideTile = grid.getSideTile(tile, TilePosition.LEFT);

                while (TileUtil.canBeMoved(tile, sideTile, TilePosition.LEFT, grid.getGridSize()) && !sideTile.isTaken() ||
                        TileUtil.canBeMoved(tile, sideTile, TilePosition.LEFT, grid.getGridSize()) && TileUtil.canBeMerged(tile, sideTile)) {

                    actionMade = true;

                    grid.removeTile(tile);
                    grid.removeTile(sideTile);
                    grid.addTile(new Tile(tile.getPosX(), y, -1));

                    if (!sideTile.isTaken()) {
                        grid.addTile(new Tile(tile.getPosX() - 1, y, tile.getValue()));
                    } else if (TileUtil.canBeMerged(tile, sideTile)) {
                        grid.addTile(new Tile(tile.getPosX() - 1, y, tile.getValue() * 2));
                        break;
                    }

                    tile = grid.getSideTile(tile, TilePosition.LEFT);
                    sideTile = grid.getSideTile(tile, TilePosition.LEFT);
                }
            }
        }
        return actionMade;
    }

    public boolean moveRight(Grid grid) {
        boolean actionMade = false;

        for (int y = 0; y < grid.getGridSize(); y++) {
            for (int x = grid.getGridSize() - 2; x >= 0; x--) {

                Tile tile = grid.getTileAt(x, y);
                Tile sideTile = grid.getSideTile(tile, TilePosition.RIGHT);

                while (TileUtil.canBeMoved(tile, sideTile, TilePosition.RIGHT, grid.getGridSize()) && !sideTile.isTaken() ||
                        TileUtil.canBeMoved(tile, sideTile, TilePosition.RIGHT, grid.getGridSize()) && TileUtil.canBeMerged(tile, sideTile)) {

                    actionMade = true;

                    grid.removeTile(tile);
                    grid.removeTile(sideTile);
                    grid.addTile(new Tile(tile.getPosX(), y, -1));

                    if (!sideTile.isTaken()) {
                        grid.addTile(new Tile(tile.getPosX() + 1, y, tile.getValue()));
                    } else if (TileUtil.canBeMerged(tile, sideTile)) {
                        grid.addTile(new Tile(tile.getPosX() + 1, y, tile.getValue() * 2));
                        break;
                    }

                    tile = grid.getSideTile(tile, TilePosition.RIGHT);
                    sideTile = grid.getSideTile(tile, TilePosition.RIGHT);
                }
            }
        }
        return actionMade;
    }

    public boolean moveUp(Grid grid) {
        boolean actionMade = false;

        for (int x = 0; x < grid.getGridSize(); x++) {
            for (int y = 1; y < grid.getGridSize(); y++) {

                Tile tile = grid.getTileAt(x, y);
                Tile sideTile = grid.getSideTile(tile, TilePosition.TOP);

                while (TileUtil.canBeMoved(tile, sideTile, TilePosition.TOP, grid.getGridSize()) && !sideTile.isTaken() ||
                        TileUtil.canBeMoved(tile, sideTile, TilePosition.TOP, grid.getGridSize()) && TileUtil.canBeMerged(tile, sideTile)) {

                    actionMade = true;

                    grid.removeTile(tile);
                    grid.removeTile(sideTile);
                    grid.addTile(new Tile(x, tile.getPosY(), -1));

                    if (!sideTile.isTaken()) {
                        grid.addTile(new Tile(x, tile.getPosY() - 1, tile.getValue()));
                    } else if (TileUtil.canBeMerged(tile, sideTile)) {
                        grid.addTile(new Tile(x, tile.getPosY() - 1, tile.getValue() * 2));
                        break;
                    }

                    tile = grid.getSideTile(tile, TilePosition.TOP);
                    sideTile = grid.getSideTile(tile, TilePosition.TOP);
                }
            }
        }
        return actionMade;
    }

    public boolean moveDown(Grid grid) {
        boolean actionMade = false;

        for (int x = 0; x < grid.getGridSize(); x++) {
            for (int y = grid.getGridSize() - 2; y >= 0; y--) {

                Tile tile = grid.getTileAt(x, y);
                Tile sideTile = grid.getSideTile(tile, TilePosition.BOTTOM);

                while (TileUtil.canBeMoved(tile, sideTile, TilePosition.BOTTOM, grid.getGridSize()) && !sideTile.isTaken() ||
                        TileUtil.canBeMoved(tile, sideTile, TilePosition.BOTTOM, grid.getGridSize()) && TileUtil.canBeMerged(tile, sideTile)) {

                    actionMade = true;

                    grid.removeTile(tile);
                    grid.removeTile(sideTile);
                    grid.addTile(new Tile(x, tile.getPosY(), -1));

                    if (!sideTile.isTaken()) {
                        grid.addTile(new Tile(x, tile.getPosY() + 1, tile.getValue()));
                    } else if (TileUtil.canBeMerged(tile, sideTile)) {
                        grid.addTile(new Tile(x, tile.getPosY() + 1, tile.getValue() * 2));
                        break;
                    }

                    tile = grid.getSideTile(tile, TilePosition.BOTTOM);
                    sideTile = grid.getSideTile(tile, TilePosition.BOTTOM);
                }
            }
        }
        return actionMade;
    }

}
