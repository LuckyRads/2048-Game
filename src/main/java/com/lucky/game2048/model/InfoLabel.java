package com.lucky.game2048.model;

import javax.swing.*;
import java.awt.*;

/**
 * InfoPanel class consists of InfoLabel Objects. InfoLabel objects are InfoPanel's messages.
 */
public class InfoLabel extends JLabel {

    private static Color TEXT_COLOR = Color.LIGHT_GRAY;

    public InfoLabel(String name, String text, Color panelColor) {
        this.setName(name);
        this.setText(text);
        this.setOpaque(true);
        this.setFont(this.getFont().deriveFont(18f));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBackground(panelColor);
        this.setForeground(this.TEXT_COLOR);
    }

}
