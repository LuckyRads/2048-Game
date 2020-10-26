package com.lucky.game2048.util;

import com.lucky.game2048.controller.GridController;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import junit.framework.TestCase;

import java.awt.*;
import java.util.ArrayList;

public class GridControllerTest extends TestCase {

    public void testMovementLeft() {
        int windowWidth = 600;
        int windowHeight = 800;
        Grid grid = new Grid(4, new ArrayList<Tile>(),
                new Dimension(windowWidth, windowHeight - 200));

        grid.replaceTile(grid.getTileAt(2, 0), new Tile(2, 0, 4));
        grid.replaceTile(grid.getTileAt(0, 2), new Tile(0, 2, 2));
        grid.replaceTile(grid.getTileAt(2, 2), new Tile(2, 2, 2));

        GridController gridController = new GridController();
        boolean movementMade = gridController.moveLeft(grid);

        assertTrue(movementMade);
    }

    public void testMovementUp() {
        int windowWidth = 600;
        int windowHeight = 800;
        Grid grid = new Grid(4, new ArrayList<Tile>(),
                new Dimension(windowWidth, windowHeight - 200));

        grid.replaceTile(grid.getTileAt(0, 0), new Tile(0, 0, 2));
        grid.replaceTile(grid.getTileAt(2, 0), new Tile(2, 0, 4));
        grid.replaceTile(grid.getTileAt(2, 1), new Tile(2, 1, 2));

        GridController gridController = new GridController();
        boolean movementMade = gridController.moveUp(grid);

        assertEquals(false, movementMade);
    }


}
