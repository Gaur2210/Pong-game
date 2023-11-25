package pong;
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{

	GamePanel panel;
	
	GameFrame(){
		panel = new GamePanel(this);
//		panel.setLayout(new BorderLayout());
		this.add(panel);
		this.setTitle("Pong Game");
		this.setSize(new Dimension(1920,1080));
		this.setResizable(true);
		this.setBackground(Color.black);
		this.setFocusable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}