import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.geom.AffineTransform;

public class Renderer extends Canvas {
	
	private static final long serialVersionUID = 1L; // Eclipse to chce, protože pøepisuji Canvas
	public Graphics2D context;
	public BufferStrategy buffering;
	public AffineTransform transformMatrix;
	
	public Renderer(){
		super();
		setSize(100,100);
		setBackground(new Color(255,255,255));
		setVisible(true);
	}
	
	public void render(GraphicsObject object){
		save();
		context.translate(object.position.x,object.position.y);
		object.render(context);
		object.renderChildren(this);
		restore();
	}
	
	public void switchContext(){
		buffering.show();
		context.dispose();
		context = (Graphics2D) buffering.getDrawGraphics();
	}
	
	public void init(){
		createBufferStrategy(2); // TODO: Graphics capabilities
		buffering = getBufferStrategy();
		context = (Graphics2D) buffering.getDrawGraphics();
	}
	
	public void save(){
		transformMatrix = context.getTransform();
	}
	
	public void restore(){
		context.setTransform(transformMatrix);
	}
}
