// GameOverPanel.java
package pong;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

    private JButton playAgainButton;

    GameOverPanel(final GameOverFrame gameOverFrame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        this.setBorder(new EmptyBorder(20,20,20,20));
        JLabel titleLabel = new JLabel("Game Over!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        
        JLabel scoreLabel = new JLabel("Player 1: " + Score.player1 + "\n  |  Player 2: " + Score.player2);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        
        playAgainButton = new JButton("Play Again");
        playAgainButton.setFont(new Font("Arial", Font.PLAIN, 20));
        playAgainButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		gameOverFrame.dispose();
        		StartFrame startFrame = new StartFrame();
        		startFrame.setVisible(true);
        	}
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(playAgainButton);
        buttonPanel.setOpaque(false);
        
        add(titleLabel, BorderLayout.NORTH);
        add(scoreLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBorder(new EmptyBorder(20,20,20,20));
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }
}
