import java.awt.Image;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Hlavni implements Runnable{
	
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	Renderer renderer;
	
	public Hlavni(){
		
		Window okno = new Window("NastavitelnÈ okno",new Vector2(50,50),new Vector2(500,500));
		
		renderer = new Renderer();
		okno.add(renderer);
		renderer.init();
		
		GeneralPath s = new GeneralPath();
		s.moveTo(-50,-50);
		s.lineTo(-50,50);
		s.lineTo(50, 50);
		s.lineTo(50, -50);
		s.closePath();
		ColorTexture texture = new ColorTexture(255,0,0, 0.8, s);
		GameObject obd = new GameObject(new Vector2(100,100), texture);
		children.add(obd);
		
		
		try {
			File file = new File("cathedral.png");
			try {
				Image img = ImageIO.read(file);
				ImageTexture texture2 = new ImageTexture(img,new Vector2(150,150), new Vector2(-1,1));
				children.add(new GameObject(new Vector2(75,75), texture2));
			}
			catch (IOException ex){
				System.out.println(ex.getCause());
			}
		}
		catch (NullPointerException ex){
			System.out.println("Wrong URL");
		}
		
		
		
		
		/*children.add(new Obdelnik(
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
		));*/
		
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
				for(GameObject child : children){
					child.tick();
					child.tickChildren();
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
