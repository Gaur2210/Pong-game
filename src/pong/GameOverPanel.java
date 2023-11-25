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
        titleLabel.setFont(new Font("Arial", Font.BOLD, 100));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.gray);
        JLabel scoreLabel= new JLabel("Player 1 :" + Score.player1 + "\n\nPlayer 2 : " + Score.player2);
        JLabel resultLabel;
        if(Score.player1 == 5)
        {
        	resultLabel = new JLabel("Player 1 WON!!");        	
        	resultLabel.setForeground(Color.green);
        }else {
        	resultLabel = new JLabel("Player 2 WON!!");
        	resultLabel.setForeground(Color.magenta);
        }
        resultLabel.setFont(new Font("Roboto", Font.BOLD, 50));
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
//        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));
//        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
//        scoreLabel.setForeground(Color.WHITE);
        
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
        playAgainButton.setFocusable(false);
        playAgainButton.setBackground(Color.black);
        playAgainButton.setForeground(Color.yellow);
        add(titleLabel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        titleLabel.setBorder(new EmptyBorder(70,0,0,0));
        buttonPanel.setBorder(new EmptyBorder(0,0,150,0));
    }

    public JButton getPlayAgainButton() {
        return playAgainButton;
    }
}
