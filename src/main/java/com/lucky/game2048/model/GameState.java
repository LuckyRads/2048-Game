package com.lucky.game2048.model;

public class GameState {

    public static boolean GAME_WON = false;
    public static int RESULT = 0;

    public static boolean isGameOver(Grid grid) {
        calculateResult(grid);
        return isGameWon(grid) || isGameLost(grid);
    }

    private static boolean isGameWon(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() == 2048) {
                GAME_WON = true;
                return true;
            }
        }
        return false;
    }

    private static boolean isGameLost(Grid grid) {
        int occupiedTiles = 0;
        for (Tile tile : grid.getTiles()) {
            occupiedTiles += tile.getValue() > 0 ? 1 : 0;
        }
        return occupiedTiles == grid.getSize() * grid.getSize();
    }

    private static void calculateResult(Grid grid) {
        for (Tile tile : grid.getTiles()) {
            if (tile.getValue() > RESULT)
                RESULT = tile.getValue();
        }
    }

}
