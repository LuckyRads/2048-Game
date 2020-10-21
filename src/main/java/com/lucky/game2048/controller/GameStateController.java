package com.lucky.game2048.controller;

import com.lucky.game2048.model.*;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.WindowsRenderingService;
import com.lucky.game2048.util.TileUtil;

import java.awt.*;

/**
 * This class contains methods and variables responsible for game state.
 */
public class GameStateController {

	private static boolean gameWon = false;
	public static int result = 0;

	public static void checkForGameOverConsole(Grid grid) {
		ConsoleRenderingService consoleRenderingService = ConsoleRenderingService.getInstance(grid);

		calculateResult(grid);

		if (!gameWon && isGameWon(grid))
			consoleRenderingService.showGameWon();

		if (isGameLost(grid)) {
			consoleRenderingService.showGameOver();
			System.exit(0);
		}
	}

	public static void checkForGameOverWindows(GameFrame gameFrame) {
		WindowsRenderingService windowsRenderingService = WindowsRenderingService.getInstance(gameFrame);

		calculateResult(gameFrame.getGrid());

		prepareResultForRendering(gameFrame);

		if (!gameWon && isGameWon(gameFrame.getGrid()))
			windowsRenderingService.showGameWon();

		if (isGameLost(gameFrame.getGrid())) {
			windowsRenderingService.showGameOver();
			System.exit(0);
		}
	}

	private static boolean isGameWon(Grid grid) {
		for (Tile tile : grid.getTiles()) {
			if (tile.getValue() >= 2048) {
				gameWon = true;
				return true;
			}
		}
		return false;
	}

	private static boolean isGameLost(Grid grid) {
		for (int y = 0; y < grid.getGridSize(); y++) {
			for (int x = 0; x < grid.getGridSize(); x++) {
				for (TilePosition tilePosition : TilePosition.values()) {
					Tile tile = grid.getTileAt(x, y);
					Tile sideTile = grid.getSideTile(tile, tilePosition);

					if (TileUtil.canBeMoved(tile, sideTile, tilePosition, grid.getGridSize()) && !sideTile.isTaken()
							|| TileUtil.canBeMoved(tile, sideTile, tilePosition, grid.getGridSize())
									&& TileUtil.canBeMerged(tile, sideTile)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private static void calculateResult(Grid grid) {
		for (Tile tile : grid.getTiles()) {
			if (tile.getValue() > result)
				result = tile.getValue();
		}
	}

	private static void prepareResultForRendering(GameFrame gameFrame) {
		for (Component component : gameFrame.getInfoPanel().getComponents()) {
			if (component instanceof InfoLabel && component.getName().equals("result")) {
				gameFrame.getInfoPanel().remove(component);
				((InfoLabel) component).setText("Result: " + GameStateController.result);
				gameFrame.getInfoPanel().add(component);
				return;
			}
		}
	}

}
