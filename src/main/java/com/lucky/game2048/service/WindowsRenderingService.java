package com.lucky.game2048.service;

import com.lucky.game2048.controller.GameStateController;
import com.lucky.game2048.model.GameFrame;
import com.lucky.game2048.util.GridUtil;

import javax.swing.*;

/**
 * This class is responsible for rendering game objects in windows application.
 */
public class WindowsRenderingService implements RenderingService {

	private static WindowsRenderingService single_instance = null;

	private GameFrame gameFrame = null;

	private WindowsRenderingService(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	public static WindowsRenderingService getInstance(GameFrame gameFrame) {
		if (single_instance == null) {
			single_instance = new WindowsRenderingService(gameFrame);
		}
		return single_instance;
	}

	@Override
	public void renderGrid() {

		GridUtil.rearrangeGrid(gameFrame.getGrid());

		gameFrame.revalidate();
		gameFrame.repaint();
	}

	@Override
	public void showGameWon() {
		JOptionPane.showMessageDialog(null, "Congratulations! You have won the game!");
	}

	@Override
	public void showGameOver() {
		JOptionPane.showMessageDialog(null, "Too bad, you have lost the game!" + "Play again and beat it next time!"
				+ "\nYour result is " + GameStateController.result);
	}

}
