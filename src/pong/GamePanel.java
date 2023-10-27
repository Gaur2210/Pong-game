package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class GamePanel extends JPanel implements Runnable{

	static final int gameWidth=900;
	static final int gameHeight=500;
	static final Dimension screenSize=new Dimension(gameWidth,gameHeight);
	static final int ballDiameter =20;
	static final int paddleWidth=25;
	static final int paddleHeight =100;
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	GamePanel(){
		newPaddles();
		newBall();
		score = new Score(gameWidth,gameHeight);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(screenSize);
		
		gameThread= new Thread(this);
		gameThread.start();
	}
	public void newBall() {
		
	}
	public void newPaddles() {
		paddle1=new Paddle(0,gameHeight/2 - paddleHeight/2,paddleWidth,paddleHeight,1);
		paddle2 = new Paddle(gameWidth - paddleWidth/2 , gameHeight/2 - paddleHeight/2,paddleWidth,paddleHeight,1);
	}
	public void Paint(Graphics g)
	{
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0 , this);
	}
	public void draw (Graphics g)
	{
		paddle1.draw(g);
		paddle2.draw(g);
	}
	public void move() {
		
	}
	public void checkCollision()
	{
		
	}
	public void run()
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		while(true)
		{
			long now= System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime = now;
			if(delta >= 1)
			{
				move();
				checkCollision();
				delta--;
				System.out.println("TEST");
			}
			
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e)
		{
			
		}
		public void keyReleased(KeyEvent e)
		{
			
		}

	}
}
