package com.lucky.game2048.service;

import com.lucky.game2048.model.Grid;

public class RenderingService {

    public void renderGrid(Grid grid) {
        String format = "%5s";
        System.out.println("----------------------");
        for (int y = 0; y < grid.getSize(); y++) {
            System.out.print("|");
            for (int x = 0; x < grid.getSize(); x++) {
                System.out.printf(format, grid.getTileAt(x, y).getTileGridValue());
            }
            System.out.print("|\n");
        }
        System.out.println("----------------------");
    }

}
