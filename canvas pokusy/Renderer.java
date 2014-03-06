import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.util.Date;

import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Renderer extends Canvas implements Runnable {
	public BufferedImage image;
	public Renderer() throws Exception {
		super();
		image = ImageIO.read(new FileInputStream("cathedral.png"));
	}
	
	float poziceKruhu = 250;
	float maximum = 500;
	
	public void paint(Graphics context){
		context.clearRect(0,0,getWidth(),getHeight());
		context.setColor(Color.BLACK);
		context.fillRect(10,10,100,100);
		
		context.drawString("This is a black square!", 120,30);
		
		context.setColor(Color.BLUE);
		context.fillOval(Math.round(poziceKruhu),50,50,50);
		
		context.drawImage(image, 300,300,this);
	}
	
	boolean running = false;
	long minulyRender = new Date().getTime();
	long limit = 100;
	public void run(){
		running = true;
		while(running){
			if( new Date().getTime() - minulyRender < limit) continue;
			if(poziceKruhu < maximum) poziceKruhu += 0.3;
			System.out.println(poziceKruhu);
			paint(getGraphics());
			minulyRender = new Date().getTime();
		}
	}
}