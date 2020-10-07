package com.lucky.game2048.util;

import com.lucky.game2048.model.Grid;

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
    
}
