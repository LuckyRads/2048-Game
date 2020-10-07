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
                gameFrame.getContentPane().add(grid.getTileAt(x, y));
            }
        }
        gameFrame.revalidate();
        gameFrame.repaint();
    }

    public void showGameWon() {
        JOptionPane.showMessageDialog(null, "Congratulations! You have won the game!");
    }

    public void showGameOver(int result) {
        JOptionPane.showMessageDialog(null, "Too bad, you have lost the game! Play again and beat it next time!\nYour result is " + result);
    }

}
