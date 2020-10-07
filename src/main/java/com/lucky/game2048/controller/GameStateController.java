package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;
import com.lucky.game2048.model.TilePosition;
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

        if (!gameWon && isGameWon(grid))
            consoleRenderingService.showGameWon();

        if (isGameLost(grid)) {
            consoleRenderingService.showGameOver(result);
            System.exit(0);
        }
    }

    public void checkForGameOverWindows(Grid grid) {
        WindowsRenderingService windowsRenderingService = new WindowsRenderingService();

        calculateResult(grid);

        if (!gameWon && isGameWon(grid))
            windowsRenderingService.showGameWon();

        if (isGameLost(grid)) {
            windowsRenderingService.showGameOver(result);
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
        for (int y = 0; y < grid.getGridSize(); y++) {
            for (int x = 0; x < grid.getGridSize(); x++) {
                for (TilePosition tilePosition : TilePosition.values()) {
                    Tile tile = grid.getTileAt(x, y);
                    Tile sideTile = grid.getSideTile(tile, tilePosition);

                    if (grid.canBeMoved(tile, sideTile, tilePosition) && !sideTile.isTaken() ||
                            grid.canBeMoved(tile, sideTile, tilePosition) && grid.areMergeable(tile, sideTile)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void calculateResult(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() > result)
                result = tile.getValue();
        }
    }

}
