// GameOverFrame.java
package pong;

import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {

    public GameOverFrame() {
        GameOverPanel gameOverPanel = new GameOverPanel(this);
        this.add(gameOverPanel);
        this.setTitle("Pong Game - Game Over");
        this.setSize(new Dimension(1280, 720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
    }

}
