package com.lucky.game2048.controller;

import com.lucky.game2048.model.Grid;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.InputService;
import com.lucky.game2048.service.WindowsRenderingService;
import com.lucky.game2048.util.GridUtil;

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
        GameStateController gameStateController = new GameStateController();
        InputService inputService = new InputService();

        consoleRenderingService.renderGrid(grid);
        while (true) {
            inputService.processInput(System.in.read(), grid);
            consoleRenderingService.renderGrid(grid);
            gameStateController.checkForGameOverConsole(grid);
        }
    }

    public void runGame(final JFrame gameFrame) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final WindowsRenderingService windowsRenderingService = new WindowsRenderingService();
                final GameStateController gameStateController = new GameStateController();
                final InputService inputService = new InputService();

                windowsRenderingService.renderGrid(gameFrame);
                gameFrame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        inputService.processInput((int) e.getKeyChar(), GridUtil.extractGridFromFrame(gameFrame));
                        windowsRenderingService.renderGrid(gameFrame);
                        gameStateController.checkForGameOverWindows(GridUtil.extractGridFromFrame(gameFrame));
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
