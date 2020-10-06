package com.lucky.game2048;

import com.lucky.game2048.controller.GameController;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import java.util.ArrayList;

/**
 * Default main class for console game version.
 */
public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(4, new ArrayList<Tile>());
        GameController gameController = new GameController();

        gameController.startGame(grid);

    }

}
