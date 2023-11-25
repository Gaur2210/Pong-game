package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel {
    private JButton startButton;
    StartPanel() {
        setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(getWidth(),getHeight()));
        JLabel titleLabel = new JLabel("Pong Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.setForeground(Color.green);
        startButton.setBorderPainted(false);
//        startButton.setBackground(Color.red);
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
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);
        this.setBackground(Color.black);
    }

    public JButton getButton() {
        return startButton;
    }
}