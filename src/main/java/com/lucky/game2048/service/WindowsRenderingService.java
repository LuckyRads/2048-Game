package com.lucky.game2048.service;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import javax.swing.*;

/**
 * This class is responsible for rendering game objects in windows application.
 */
public class WindowsRenderingService {

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

    public void showGameOver(boolean gameWon, int result) {
        if (gameWon) {
            JOptionPane.showMessageDialog(null, "Congratulations! You have won the game!\nYour result is " + result);
        } else {
            JOptionPane.showMessageDialog(null, "Too bad, you have lost the game! Play again and beat it next time!\nYour result is " + result);
        }
    }

}
