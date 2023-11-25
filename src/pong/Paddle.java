package pong;
import java.awt.*; 
import java.awt.event.*;

public class Paddle extends Rectangle{
	int id;
	int yVelocity;
	int speed = 10;
	boolean pU=false, pD=false;//paddle up, paddle down
	
	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.id=id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
				pU=true;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
				pD=true;
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
				pU=true;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
				pD=true;
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			
			if(e.getKeyCode()==KeyEvent.VK_W) {
				pU=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				pD=false;
			}
			
			if(!pU && !pD) {
				setYDirection(0);
			}else if(pD){
				setYDirection(speed);				
			}
			else {
				setYDirection(-speed);				
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				pU=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				pD=false;
			}
			
			if(!pU && !pD) {
				setYDirection(0);
			}else if(pD){
				setYDirection(speed);				
			}
			else {
				setYDirection(-speed);				
			}
			break;
		}
	}
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void setXDirection(int xDir) {
		x=xDir;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		if(id==1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}