package com.lucky.game2048.controller;

import com.lucky.game2048.model.GameFrame;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.service.ConsoleRenderingService;
import com.lucky.game2048.service.InputService;
import com.lucky.game2048.service.RenderingService;
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
		RenderingService renderingService = ConsoleRenderingService.getInstance(grid);
		InputService inputService = new InputService();

		renderingService.renderGrid();
		while (true) {
			inputService.processInput(System.in.read(), grid);
			renderingService.renderGrid();
			GameStateController.checkForGameOverConsole(grid);
		}
	}

	public void runGame(final GameFrame gameFrame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final RenderingService windowsRenderingService = WindowsRenderingService.getInstance(gameFrame);
				final InputService inputService = new InputService();

				windowsRenderingService.renderGrid();
				gameFrame.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent e) {
						inputService.processInput((int) e.getKeyChar(), gameFrame.getGrid());
						windowsRenderingService.renderGrid();
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
