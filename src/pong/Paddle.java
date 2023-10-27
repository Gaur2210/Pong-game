package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Paddle extends Rectangle{
	
	int id;
	int yVelocity;
	Paddle(int x , int y, int paddleWidth , int paddleHeight , int id)
	{
		super(x,y,paddleWidth,paddleHeight);
		this.id=id;
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void setYDir(int yDir) {
		
	}
	public void move() {
		
	}
	public void draw(Graphics g)
	{
		if(id==1) {
			g.setColor(Color.blue);
		}else {
			g.setColor(Color.red);
		}
		g.fillRect(x, y, width, height);
	}
}
