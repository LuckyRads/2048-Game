package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;

/**
 * This class controls grid tile movement mechanics.
 */
public class GridController {

    public boolean moveLeft(Grid grid) {
        boolean actionMade = false;

        for (int y = 0; y < grid.getGridSize(); y++) {
            for (int x = 1; x < grid.getGridSize(); x++) {

                Tile tile = grid.getTileAt(x, y);
                Tile sideTile = grid.getSideTile(tile, TilePosition.LEFT);

                while (grid.canBeMoved(tile, sideTile, TilePosition.LEFT) && !sideTile.isTaken() ||
                        grid.canBeMoved(tile, sideTile, TilePosition.LEFT) && grid.areMergeable(tile, sideTile)) {

                    actionMade = true;

                    grid.getTiles().remove(tile);
                    grid.getTiles().remove(sideTile);
                    grid.getTiles().add(new Tile(tile.getPosX(), y, -1));

                    if (!sideTile.isTaken()) {
                        grid.getTiles().add(new Tile(tile.getPosX() - 1, y, tile.getValue()));
                    } else if (grid.areMergeable(tile, sideTile)) {
                        grid.getTiles().add(new Tile(tile.getPosX() - 1, y, tile.getValue() * 2));
                        break;
                    }

//                    grid.moveTilePair(tile, sideTile, TilePosition.LEFT);
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

                while (grid.canBeMoved(tile, sideTile, TilePosition.RIGHT) && !sideTile.isTaken() ||
                        grid.canBeMoved(tile, sideTile, TilePosition.RIGHT) && grid.areMergeable(tile, sideTile)) {

                    actionMade = true;

                    grid.getTiles().remove(tile);
                    grid.getTiles().remove(sideTile);
                    grid.getTiles().add(new Tile(tile.getPosX(), y, -1));

                    if (!sideTile.isTaken()) {
                        grid.getTiles().add(new Tile(tile.getPosX() + 1, y, tile.getValue()));
                    } else if (grid.areMergeable(tile, sideTile)) {
                        grid.getTiles().add(new Tile(tile.getPosX() + 1, y, tile.getValue() * 2));
                        break;
                    }

//                    grid.moveTilePair(tile, sideTile, TilePosition.RIGHT);
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

                while (grid.canBeMoved(tile, sideTile, TilePosition.TOP) && !sideTile.isTaken() ||
                        grid.canBeMoved(tile, sideTile, TilePosition.TOP) && grid.areMergeable(tile, sideTile)) {

                    actionMade = true;

                    grid.getTiles().remove(tile);
                    grid.getTiles().remove(sideTile);
                    grid.getTiles().add(new Tile(x, tile.getPosY(), -1));

                    if (!sideTile.isTaken()) {
                        grid.getTiles().add(new Tile(x, tile.getPosY() - 1, tile.getValue()));
                    } else if (grid.areMergeable(tile, sideTile)) {
                        grid.getTiles().add(new Tile(x, tile.getPosY() - 1, tile.getValue() * 2));
                        break;
                    }

//                    grid.moveTilePair(tile, sideTile, TilePosition.RIGHT);
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

                while (grid.canBeMoved(tile, sideTile, TilePosition.BOTTOM) && !sideTile.isTaken() ||
                        grid.canBeMoved(tile, sideTile, TilePosition.BOTTOM) && grid.areMergeable(tile, sideTile)) {

                    actionMade = true;

                    grid.getTiles().remove(tile);
                    grid.getTiles().remove(sideTile);
                    grid.getTiles().add(new Tile(x, tile.getPosY(), -1));

                    if (!sideTile.isTaken()) {
                        grid.getTiles().add(new Tile(x, tile.getPosY() + 1, tile.getValue()));
                    } else if (grid.areMergeable(tile, sideTile)) {
                        grid.getTiles().add(new Tile(x, tile.getPosY() + 1, tile.getValue() * 2));
                        break;
                    }

//                    grid.moveTilePair(tile, sideTile, TilePosition.BOTTOM);
                    tile = grid.getSideTile(tile, TilePosition.BOTTOM);
                    sideTile = grid.getSideTile(tile, TilePosition.BOTTOM);
                }
            }
        }
        return actionMade;
    }

}
