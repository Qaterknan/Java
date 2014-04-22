import java.awt.Color;
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
		
		Window okno = new Window("Nastaviteln� okno",new Vector2(50,50),new Vector2(500,500));
		
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
		texture.rotation = (float)0.78;
		GameObject obd = new GameObject(new Vector2(100,100), texture);
		children.add(obd);
		
		
		try {
			File file = new File("cathedral.png");
			try {
				Image img = ImageIO.read(file);
				ImageTexture texture2 = new ImageTexture(img,new Vector2(150,150), new Vector2(1,1));
				children.add(new GameObject(new Vector2(75,226), texture2));
				texture2.toggleDevMode();
			}
			catch (IOException ex){
				System.out.println(ex.getCause());
			}
		}
		catch (NullPointerException ex){
			System.out.println("Wrong URL");
		}
		
		GeneralPath s2 = new GeneralPath();
		s2.moveTo(45, 37);
		s2.lineTo(32, -27);
		s2.lineTo(-36, -40);
		s2.lineTo(-50, 20);
		s2.closePath();
		float[] ratios = new float[3];
		ratios[0] = (float) 0.0;
		ratios[1] = (float)0.5;
		ratios[2] = (float)1.0;
		Color[] cols = new Color[3];
		cols[0] = Color.WHITE;
		cols[1] = Color.BLUE;
		cols[2] = Color.BLACK;
		LinearGradientTexture texture3 = new LinearGradientTexture(s2,new Vector2(-30,0), new Vector2(30,0), ratios, cols, "cyclic");
		children.add(new GameObject(new Vector2(200,200),texture3));
		
		try {
			File file = new File("toyota.png");
			try {
				Image img = ImageIO.read(file);
				FilmstripAnimatedTexture texture4 = new FilmstripAnimatedTexture(
						img,
						new Vector2(6,1),
						1000,
						new Vector2(150,150),
						new Vector2(1,1)
					);
				children.add(new GameObject(new Vector2(300,300), texture4));
			}
			catch(IOException ex){
				
			}
		}
		catch(NullPointerException ex){
			System.out.println("Wrong URL");
		}
		
		run();
	}
		
	long limit = 20;
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
				renderer.switchContext(); // Zaji��uje bufferov�n�
			}
		}
	}
	
	public static void main(String[] args) {
		new Hlavni();
	}

}
