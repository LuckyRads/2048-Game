package com.lucky.game2048.model;

import javax.swing.*;
import java.awt.*;

/**
 * This class contains all GUI text information.
 */
public class InfoPanel extends JPanel {

    private static int HEIGHT = 100;
    private static Color COLOR = Color.DARK_GRAY;

    public InfoPanel(Dimension dimension) {
        this.setBackground(this.COLOR);
        this.setPreferredSize(new Dimension((int) dimension.getWidth(), this.HEIGHT));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, this.HEIGHT));
        this.setLayout(new GridLayout(3, 1));
        this.add(new InfoLabel("movement", "Use w, a, s, d keys to move the tiles.", this.COLOR));
        this.add(new InfoLabel("quit", "Press q to quit the game.", this.COLOR));
        this.add(new InfoLabel("result", "Result: 0", this.COLOR));
    }

}
