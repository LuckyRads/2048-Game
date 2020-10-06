package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.WindowsRenderingService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * This class is responsible for game mechanics.
 */
public class GameController {

    public void startGame(Grid grid) {
        grid.generateTile();
        runGame(grid);
    }

    public void startGame(final JFrame gameFrame) throws InvocationTargetException, InterruptedException {
        Grid grid = (Grid) gameFrame.getContentPane();
        grid.generateTile();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runGame(gameFrame);
            }
        });
    }

    public void runGame(Grid grid) {
        ConsoleRenderingService consoleRenderingService = new ConsoleRenderingService();
        GameStateController gameStateController = new GameStateController();
        while (true) {
            consoleRenderingService.renderGrid(grid);

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

    public void runGame(final JFrame gameFrame) {
//        WindowsRenderingService windowsRenderingService = new WindowsRenderingService();
//        GameStateController gameStateController = new GameStateController();


        processAction(gameFrame);


//        if (GameStateController.GAME_WON) {
//            System.out.println("Congratulations! You have won the game!");
//        } else {
//            System.out.println("Too bad, you have lost the game! Play again and beat it next time!");
//        }
//        System.out.println("Your result is " + GameStateController.RESULT);
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

    public void processAction(final JFrame gameFrame) {
        final WindowsRenderingService windowsRenderingService = new WindowsRenderingService();
        final Grid grid = (Grid) gameFrame.getContentPane();

        windowsRenderingService.renderGrid(gameFrame);

        gameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char action = e.getKeyChar();
                switch (action) {
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
                windowsRenderingService.renderGrid(gameFrame);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

}
