package com.lucky.game2048.controller;

import com.lucky.game2048.model.GameFrame;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.InputService;
import com.lucky.game2048.service.WindowsRenderingService;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * This class is responsible for game mechanics.
 */
public class GameController {

    public void runGame(Grid grid) throws IOException {
        ConsoleRenderingService consoleRenderingService = new ConsoleRenderingService();
        InputService inputService = new InputService();

        consoleRenderingService.renderGrid(grid);
        while (true) {
            inputService.processInput(System.in.read(), grid);
            consoleRenderingService.renderGrid(grid);
            GameStateController.checkForGameOverConsole(grid);
        }
    }

    public void runGame(final GameFrame gameFrame) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final WindowsRenderingService windowsRenderingService = WindowsRenderingService.getInstance();
                final InputService inputService = new InputService();

                windowsRenderingService.renderGrid(gameFrame);
                gameFrame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        inputService.processInput((int) e.getKeyChar(), gameFrame.getGrid());
                        windowsRenderingService.renderGrid(gameFrame);
                        GameStateController.checkForGameOverWindows(gameFrame);
                    }

                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
            }
        });
    }

}
