package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {

    public StartFrame() {
//        initComponents();
        StartPanel startPanel = new StartPanel();
        setLayout(new BorderLayout());
        startPanel.getButton().addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		GameFrame gameFrame = new GameFrame();
//                gameFrame.setPanel(new GamePanel(gameFrame));
        		StartFrame.this.dispose();
        	}
        });
        this.add(startPanel);
        this.setTitle("Pong Game - Start");
        this.setSize(new Dimension(1280, 720));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setBackground(Color.black);
//        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        this.setBackground(Color.black);
    }    
}
