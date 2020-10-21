package com.lucky.game2048.service;

import com.lucky.game2048.controller.GameStateController;
import com.lucky.game2048.model.Grid;

/**
 * This class is responsible for rendering game objects in console application.
 */
public class ConsoleRenderingService implements RenderingService {

	private static ConsoleRenderingService single_instance = null;

	private Grid grid = null;

	private ConsoleRenderingService(Grid grid) {
		this.grid = grid;
	}

	public static ConsoleRenderingService getInstance(Grid grid) {
		if (single_instance == null) {
			single_instance = new ConsoleRenderingService(grid);
		}
		return single_instance;
	}

	@Override
	public void renderGrid() {
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
		System.out.println("Your result is " + GameStateController.result);
	}

	@Override
	public void showGameWon() {
		System.out.println("Congratulations! You have won the game!");
	}

	@Override
	public void showGameOver() {
		System.out.println("Too bad, you have lost the game! Play again and beat it next time!\nYour result is "
				+ GameStateController.result);
	}

}
