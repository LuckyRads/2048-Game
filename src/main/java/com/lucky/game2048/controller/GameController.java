package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.service.RenderingService;

import java.io.IOException;

public class GameController {

    public void startGame(Grid grid) {
        grid.generateTile();
        runGame(grid);
    }

    public void runGame(Grid grid) {
        RenderingService renderingService = new RenderingService();
        GameStateController gameStateController = new GameStateController();
        while (true) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("-------- 2048 --------");

            renderingService.renderGrid(grid);

            System.out.println("Use w, a, s, d keys to move the tiles.");
            System.out.println("Enter q to quit the game.");

            processAction(grid);

            if (gameStateController.isGameOver(grid))
                break;
        }
        if (GameStateController.GAME_WON) {
            System.out.println("Congratulations! You have won the game!");
        } else {
            System.out.println("Too bad, you have lost the game! Play again and beat it next time!");
        }
        System.out.println("Your result is " + GameStateController.RESULT);
    }

    public void processAction(Grid grid) {
        try {
            switch (System.in.read()) {
                case 'a':
                    if (grid.moveLeft())
                        grid.generateTile();
                    break;
                case 'd':
                    if (grid.moveRight())
                        grid.generateTile();
                    break;
                case 'w':
                    if (grid.moveUp())
                        grid.generateTile();
                    break;
                case 's':
                    if (grid.moveDown())
                        grid.generateTile();
                    break;
                case 'q':
                    System.exit(0);

            }
        } catch (IOException e) {
            System.out.println("Wrong input detected!");
            System.out.println("Printing stack trace:");
            e.printStackTrace();
        }
    }

}
