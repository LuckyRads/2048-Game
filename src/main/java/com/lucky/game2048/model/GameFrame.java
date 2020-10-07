package com.lucky.game2048.model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This is the main class for GUI game version.<br>
 * This class consists of two main objects: Grid and InfoPanel.
 */
public class GameFrame extends JFrame {

    private Grid grid;
    private JPanel infoPanel;

    public GameFrame(int gridSize, Dimension dimension) {
        this.setTitle("2048 Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.infoPanel = new InfoPanel(dimension);
        this.grid = new Grid(gridSize, new ArrayList<Tile>(),
                new Dimension(this.getWidth(), this.getHeight() - this.infoPanel.getHeight()));
        this.getContentPane().add(this.grid);
        this.getContentPane().add(this.infoPanel);
        this.pack();
        this.setVisible(true);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public void setInfoPanel(JPanel infoPanel) {
        this.infoPanel = infoPanel;
    }
}
