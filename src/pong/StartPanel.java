package pong;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {
    private JButton startButton;
    StartPanel() {
    	// #01ff00  #ff00ff
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(getWidth(),getHeight()));
        this.setBackground(Color.black);
        JLabel titleLabel = new JLabel("<html><font color=#01ff00> PONG</font> <font color=#ff00ff> GAME</font></html>");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 100));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.RED);
        
        startButton = new JButton("START GAME");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.setForeground(Color.white);
        startButton.setBorderPainted(true);
        startButton.setBounds(getWidth(), getHeight()/2, getWidth(), getHeight());
        startButton.setBackground(Color.GRAY);
        startButton.setFocusable(false);
        startButton.addActionListener
        (
    		new ActionListener() {
//    			@override
    			public void actionPerformed(ActionEvent e) {
    				System.out.println("Start Button Clicked");
				}
			}
		);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
//        buttonPanel.setBackground(Color.black);
        buttonPanel.setBorder(new EmptyBorder(0,0,200,0));
        buttonPanel.setOpaque(false);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(titleLabel, BorderLayout.CENTER);
    }

    public JButton getButton() {
        return startButton;
    }
}