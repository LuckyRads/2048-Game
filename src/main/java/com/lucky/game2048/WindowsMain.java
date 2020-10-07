package com.lucky.game2048;

import com.lucky.game2048.controller.GameController;
import com.lucky.game2048.model.GameFrame;

import java.awt.*;

/**
 * Default main class for windows game version.
 */
public class WindowsMain {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        GameFrame gameFrame = new GameFrame(4, new Dimension(600, 800));

        gameController.runGame(gameFrame);
    }

}
