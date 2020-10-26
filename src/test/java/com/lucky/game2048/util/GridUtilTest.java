package com.lucky.game2048.util;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;
import junit.framework.TestCase;

import java.awt.*;
import java.util.ArrayList;

public class GridUtilTest extends TestCase {

    public void testIsMovementAvailable() {
        int windowWidth = 600;
        int windowHeight = 800;
        Grid grid = new Grid(4, new ArrayList<Tile>(),
                new Dimension(windowWidth, windowHeight - 200));

        grid.replaceTile(grid.getTileAt(0, 0), new Tile(0, 0, 2));
        grid.replaceTile(grid.getTileAt(1, 0), new Tile(1, 0, 2));
        grid.replaceTile(grid.getTileAt(1, 1), new Tile(1, 1, 2));
        grid.replaceTile(grid.getTileAt(3, 1), new Tile(3, 1, 4));

        Tile tile = grid.getTileAt(3, 1);
        Tile sideTile = grid.getTileAt(2, 1);
        TilePosition tilePosition = TilePosition.LEFT;

        boolean isMovementAvailable = GridUtil.isMovementAvailable(tile, sideTile, tilePosition, grid);

        assertTrue(isMovementAvailable);
    }

}
