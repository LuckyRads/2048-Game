package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

/**
 * This class contains methods and variables responsible for game state.
 */
public class GameStateController {

    public static boolean GAME_WON = false;
    public static int RESULT = 0;

    public boolean isGameOver(Grid grid) {
        calculateResult(grid);
        return isGameWon(grid) || isGameLost(grid);
    }

    private boolean isGameWon(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() == 2048) {
                GAME_WON = true;
                return true;
            }
        }
        return false;
    }

    private boolean isGameLost(Grid grid) {
        int occupiedTiles = 0;
        for (Tile tile : grid.getTiles()) {
            occupiedTiles += tile.getValue() > 0 ? 1 : 0;
        }
        return occupiedTiles == grid.getGridSize() * grid.getGridSize();
    }

    private void calculateResult(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() > RESULT)
                RESULT = tile.getValue();
        }
    }

}
