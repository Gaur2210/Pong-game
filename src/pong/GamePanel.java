package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

	volatile int GAME_WIDTH = 1920;
	volatile int GAME_HEIGHT = (int)(GAME_WIDTH * (9/16.0f));
//	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	static final int BALL_DIAMETER = 20;
	static final int PADDLE_WIDTH = 25;
	int maxPaddleHeight = 150;
	static int PADDLE1_HEIGHT = 100;
	static int PADDLE2_HEIGHT = 100;
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
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2-BALL_DIAMETER/2),BALL_DIAMETER,BALL_DIAMETER);
	}
	public void newPaddles() {
		paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE1_HEIGHT/2),PADDLE_WIDTH,PADDLE1_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE2_HEIGHT/2),PADDLE_WIDTH,PADDLE2_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this); 
	}
	public void draw(Graphics g) {
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
Toolkit.getDefaultToolkit().sync(); //helps with the animation

	}
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
	}
	
	public void checkCollision() {
		
		//bounce ball off window edges
		if(ball.y <=0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		
		
		//bounce ball off paddles
		if(ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if(ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++;
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		
		
		//stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		if(paddle1.y >= (GAME_HEIGHT-PADDLE1_HEIGHT))
			paddle1.y = GAME_HEIGHT-PADDLE1_HEIGHT;
		if(paddle2.y<=0)
			paddle2.y=0;
		if(paddle2.y >= (GAME_HEIGHT-PADDLE2_HEIGHT))
			paddle2.y = GAME_HEIGHT-PADDLE2_HEIGHT;
		
		
		//score ++
		if(ball.x <=0) {
			Score.player2++;
			PADDLE1_HEIGHT-=PADDLE1_HEIGHT/20;
			PADDLE2_HEIGHT+=PADDLE2_HEIGHT/20;
			PADDLE2_HEIGHT=Math.min(maxPaddleHeight,PADDLE2_HEIGHT);
			newPaddles();
			newBall();
			System.out.println("Player 2: "+Score.player2);
		}
		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
			Score.player1++;
			PADDLE2_HEIGHT-=PADDLE2_HEIGHT/20;
			PADDLE1_HEIGHT+=PADDLE1_HEIGHT/20;
			PADDLE1_HEIGHT=Math.min(maxPaddleHeight,PADDLE1_HEIGHT);
			newPaddles();
			newBall();
			System.out.println("Player 1: "+Score.player1);
		}
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double frameDur = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			//responsive{
			GAME_WIDTH = getWidth();
			GAME_HEIGHT = getHeight();
			score =new Score(GAME_WIDTH,GAME_HEIGHT);
			paddle1.setXDirection(0);
			paddle2.setXDirection(GAME_WIDTH - PADDLE_WIDTH);
			//}
			long now = System.nanoTime();
			delta += (now -lastTime)/frameDur;
			lastTime = now;
			if(delta >=1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}