package com.lucky.game2048;

import com.lucky.game2048.controller.GameController;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import java.util.ArrayList;

/**
 * Default main class for console game version.
 */
public class ConsoleMain {

    public static void main(String[] args) {
        Grid grid = new Grid(4, new ArrayList<Tile>(), null);
        GameController gameController = new GameController();

        try {
            gameController.runGame(grid);
        } catch (Exception e) {
            System.out.println("An error has occurred!");
            System.out.println("Please contact technical support.");
            System.out.println("Printing exception stack trace:");
            e.printStackTrace();
        }
    }

}
