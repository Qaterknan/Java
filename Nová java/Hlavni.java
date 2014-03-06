import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Hlavni implements Runnable{
	
	public ArrayList<GraphicsObject> children = new ArrayList<GraphicsObject>();
	Renderer renderer;
	
	public Hlavni(){
		
		Window okno = new Window("NastavitelnÈ okno",new Vector2(50,50),new Vector2(500,500));
		
		renderer = new Renderer();
		okno.add(renderer);
		renderer.init();
		
		children.add(new Obdelnik(
			new Vector2(100,100),
			new Vector2(50,50),
			new Color(0,0,0)
		));
		children.add(new Obdelnik(
			new Vector2(200,0),
			new Vector2(50,50),
			new Color(0,0,0)
		));
		children.add(new Obdelnik(
			new Vector2(300,100),
			new Vector2(25,25),
			new Color(0,0,0),
			new Color(255,255,255)
		));
		
		run();
	}
		
	long limit = 50;
	long time = new Date().getTime();
	long now = time;
	boolean running = true;
		
	public void run(){
		while(running){
			now = new Date().getTime();
			if(now - time > limit){
				time = now;
				for(GraphicsObject child : children){
					renderer.render(child);
				}
				renderer.switchContext(); // Zajiöùuje bufferov·nÌ
			}
		}
	}
	
	public static void main(String[] args) {
		new Hlavni();
	}

}
