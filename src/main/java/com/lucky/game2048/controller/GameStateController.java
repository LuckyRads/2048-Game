package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.WindowsRenderingService;

/**
 * This class contains methods and variables responsible for game state.
 */
public class GameStateController {

    private boolean gameWon = false;
    private int result = 0;

    public void checkForGameOverConsole(Grid grid) {
        ConsoleRenderingService consoleRenderingService = new ConsoleRenderingService();

        calculateResult(grid);

        if (isGameWon(grid) || isGameLost(grid)) {
            consoleRenderingService.showGameOver(gameWon, result);
            System.exit(0);
        }
    }

    public void checkForGameOverWindows(Grid grid) {
        WindowsRenderingService windowsRenderingService = new WindowsRenderingService();

        calculateResult(grid);

        if (isGameWon(grid) || isGameLost(grid)) {
            windowsRenderingService.showGameOver(gameWon, result);
            System.exit(0);
        }
    }

    private boolean isGameWon(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() >= 2048) {
                gameWon = true;
                return true;
            }
        }
        return false;
    }

    private boolean isGameLost(Grid grid) {
        /*
        TODO: Fix game lost condition.
        Game is lost when user can no longer do any moves, not when all tiles are occupied
         */
        int occupiedTiles = 0;
        for (Tile tile : grid.getTiles()) {
            occupiedTiles += tile.getValue() > 0 ? 1 : 0;
        }
        return occupiedTiles >= grid.getGridSize() * grid.getGridSize();
    }

    private void calculateResult(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() > result)
                result = tile.getValue();
        }
    }

}
