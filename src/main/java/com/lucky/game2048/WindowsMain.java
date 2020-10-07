package com.lucky.game2048;

import com.lucky.game2048.controller.GameController;
import com.lucky.game2048.model.Grid;
import com.lucky.game2048.model.Tile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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

    private static void createGameWindow(JFrame gameFrame) {
        gameFrame.setTitle("2048 Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setPreferredSize(new Dimension(600, 800));
        gameFrame.setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel infoPanel = createInfoPanel(gameFrame);
        Grid grid = new Grid(4, new ArrayList<Tile>(),
                new Dimension(gameFrame.getWidth(), gameFrame.getHeight() - infoPanel.getHeight()));

        gameFrame.getContentPane().add(grid);
        gameFrame.getContentPane().add(infoPanel);

        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    private static JPanel createInfoPanel(JFrame gameFrame) {
        JPanel infoPanel = new JPanel();
        int height = 100;
        Color panelColor = Color.DARK_GRAY;

        infoPanel.setBackground(panelColor);
        infoPanel.setPreferredSize(new Dimension(gameFrame.getWidth(), height));
        infoPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));

        JLabel instructions = new JLabel();
        instructions.setOpaque(true);
        instructions.setText("Use w, a, s, d keys to move the tiles. Press q to quit the game.");
        instructions.setFont(instructions.getFont().deriveFont(18f));
        instructions.setHorizontalAlignment(JLabel.CENTER);
        instructions.setVerticalAlignment(JLabel.CENTER);
        instructions.setBackground(panelColor);
        instructions.setForeground(Color.LIGHT_GRAY);

        infoPanel.add(instructions);

        return infoPanel;
    }

}
