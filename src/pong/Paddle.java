package pong;
import java.awt.*; 
import java.awt.event.*;

public class Paddle extends Rectangle{
	int id;
	int yVelocity;
	int speed = 10;
	int pressCount =0;
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
				pressCount++;
				System.out.print(pressCount);
				pU=true;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
				pressCount++;
				System.out.print(pressCount);
				pD=true;
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
				pressCount++;
				System.out.print(pressCount);
				pU=true;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
				pressCount++;
				System.out.print(pressCount);
				pD=true;
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			
			if(e.getKeyCode()==KeyEvent.VK_W) {
				pressCount--;
				pU=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				pressCount--;
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
				pressCount--;
				pU=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				pressCount--;
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