package com.lucky.game2048.controller;

import com.lucky.game2048.model.GameState;
import com.lucky.game2048.model.Grid;

import java.io.IOException;

public class GameController {

    public void startGame(Grid grid) {
        System.out.println("----- 2048 -----");
        grid.generateTile();
        runGame(grid);
    }

    public void runGame(Grid grid) {
        while (!GameState.GAME_OVER) {
            grid.draw();
            processAction(grid);
        }

    }

    public void processAction(Grid grid) {
        try {
            switch (System.in.read()) {
                case 'a':
                    grid.moveLeft();
                    grid.generateTile();
                    break;
                case 'd':
                    grid.moveRight();
                    grid.generateTile();
                    break;
                case 'w':
                    grid.generateTile();
                    break;
                case 's':
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
