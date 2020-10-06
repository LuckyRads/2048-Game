package com.lucky.game2048.service;

import com.lucky.game2048.model.Grid;

/**
 * This class is responsible for processing user input.
 */
public class InputService {

    public void processInput(int input, Grid grid) {
        switch (input) {
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
    }

}
