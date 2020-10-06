package com.lucky.game2048.service;

import com.lucky.game2048.model.Grid;

/**
 * This class is responsible for rendering game objects in console application.
 */
public class ConsoleRenderingService {

    public void renderGrid(Grid grid) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("-------- 2048 --------");
        String format = "%5s";
        for (int y = 0; y < grid.getGridSize(); y++) {
            System.out.print("|");
            for (int x = 0; x < grid.getGridSize(); x++) {
                System.out.printf(format, grid.getTileAt(x, y).getTileGridValue());
            }
            System.out.print("|\n");
        }
        System.out.println("----------------------");
        System.out.println("Use w, a, s, d keys to move the tiles.");
        System.out.println("Enter q to quit the game.");
    }

    public void showGameOver(boolean gameWon, int result) {
        if (gameWon) {
            System.out.println("Congratulations! You have won the game!");
        } else {
            System.out.println("Too bad, you have lost the game! Play again and beat it next time!");
        }
        System.out.println("Your result is " + result);
    }

}
