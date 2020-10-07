package com.lucky.game2048.service;

import com.lucky.game2048.WindowsMain;
import com.lucky.game2048.controller.GridController;
import com.lucky.game2048.model.Grid;

/**
 * This class is responsible for processing user input.
 */
public class InputService {

    public void processInput(int input, Grid grid) {
        GridController gridController = new GridController();
        switch (input) {
            case 'a':
                if (gridController.moveLeft(grid))
                    grid.generateTile();
                break;
            case 'd':
                if (gridController.moveRight(grid))
                    grid.generateTile();
                break;
            case 'w':
                if (gridController.moveUp(grid))
                    grid.generateTile();
                break;
            case 's':
                if (gridController.moveDown(grid))
                    grid.generateTile();
                break;
            case 'q':
                System.exit(0);
        }
    }

}
