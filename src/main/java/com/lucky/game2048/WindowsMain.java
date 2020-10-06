package com.lucky.game2048;

import com.lucky.game2048.controller.GameController;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Default main class for windows game version.
 */
public class WindowsMain {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        JFrame gameFrame = new JFrame();

        createGameWindow(gameFrame);

        gameController.runGame(gameFrame);
    }

    public static void createGameWindow(JFrame jFrame) {
        jFrame.setTitle("2048 Game");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(600, 600));

        jFrame.setContentPane(new Grid(4, new ArrayList<Tile>()));

        jFrame.pack();
        jFrame.setVisible(true);
    }

}
