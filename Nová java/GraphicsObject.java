import java.awt.Color;
import java.awt.TexturePaint;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;

public abstract class GraphicsObject {
	
	Color color = new Color(0,0,0);
	public GradientPaint gradient;
	public TexturePaint texture;
	Vector2 position = new Vector2(0,0);
	Vector2 dimension = new Vector2(0,0);
	String textureType = "none";
	String renderType = "fill";
	
	public ArrayList<GraphicsObject> children = new ArrayList<GraphicsObject>();
	
	public void tickChildren(){
		for(GraphicsObject child : children){
			child.tick();
			child.tickChildren();
		}
	}
	
	public void renderChildren(Graphics2D context){
		for(GraphicsObject child : children){
			child.render(context);
			child.renderChildren(context);
		}
	}
	
	public GraphicsObject (Vector2 zposition, Color zcolor){
		position = zposition;
		color = zcolor;
		textureType = "color";
	}
	
	public GraphicsObject (Vector2 zposition, BufferedImage image){
		position = zposition;
		texture = new TexturePaint(
				image, 
				new Rectangle2D.Float(0,0,image.getWidth(), image.getHeight())
			);
		textureType = "texture";
	}
	
	public GraphicsObject (Vector2 zposition, Vector2 point1, Color col1, Vector2 point2, Color col2, boolean cyclic){
		position = zposition;
		gradient = new GradientPaint(point1.x, point1.y, col1, point2.x, point2.y, col2, cyclic);
		textureType = "gradient";
		// TODO: dodìlat cyclic gradient a dynamické mìnìní gradientu
	}
	
	public void render(Graphics2D context){
		GeneralPath path = drawPath(context);
		if(textureType == "color"){
			context.setPaint(color);
		}
		else if(textureType == "texture"){
			context.setPaint(texture);
		}
		else if(textureType == "gradient"){
			context.setPaint(gradient);
		}
		else return;
		if(renderType == "fill"){
			context.fill(path);
		}
		else if(renderType == "stroke"){
			context.draw(path);
		}
	}
	
	public void tick(){
		
	}
	
	public abstract GeneralPath drawPath(Graphics2D graphics);
		// Metoda je implementována každým konkrétním objektem zvláštì
}
