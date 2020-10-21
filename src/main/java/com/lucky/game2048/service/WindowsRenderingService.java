package com.lucky.game2048.service;

import com.lucky.game2048.controller.GameStateController;
import com.lucky.game2048.model.GameFrame;
import com.lucky.game2048.util.GridUtil;

import javax.swing.*;

/**
 * This class is responsible for rendering game objects in windows application.
 */
public class WindowsRenderingService {
	
	private static WindowsRenderingService single_instance = null;

	private WindowsRenderingService() {
		System.out.println("WindowsRenderingService initialized.");
	}
	
	public static WindowsRenderingService getInstance() {
		if (single_instance == null) {
			single_instance = new WindowsRenderingService();
		}
		return single_instance;
	}
	
    public void renderGrid(GameFrame gameFrame) {

        GridUtil.rearrangeGrid(gameFrame.getGrid());

        gameFrame.revalidate();
        gameFrame.repaint();
    }

    public void showGameWon() {
        JOptionPane.showMessageDialog(null, "Congratulations! You have won the game!");
    }

    public void showGameOver() {
        JOptionPane.showMessageDialog(null, "Too bad, you have lost the game!" +
                "Play again and beat it next time!" +
				"\nYour result is " + GameStateController.result);
	}

}
