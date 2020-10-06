package com.lucky.game2048.service;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is responsible for rendering game objects in windows application.
 */
public class WindowsRenderingService {

    private static HashMap<Integer, Color> tileColors = new HashMap<Integer, Color>();

    public WindowsRenderingService() {
        tileColors.put(-1, Color.PINK);
        tileColors.put(2, Color.GREEN);
        tileColors.put(4, Color.CYAN);
    }

    public void renderGrid(JFrame gameFrame) {
        Grid grid = (Grid) gameFrame.getContentPane();

        gameFrame.getContentPane().removeAll();

        for (int y = 0; y < grid.getGridSize(); y++) {
            for (int x = 0; x < grid.getGridSize(); x++) {
                Tile tile = grid.getTileAt(x, y);
                gameFrame.getContentPane().add(tile);
            }
        }
        gameFrame.revalidate();
        gameFrame.repaint();
    }

}
