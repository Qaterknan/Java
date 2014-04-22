import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.geom.AffineTransform;

public class Renderer extends Canvas {
	
	private static final long serialVersionUID = 1L; // Eclipse to chce, protože pøepisuji Canvas
	public GraphicsContext context;
	public BufferStrategy buffering;
	public AffineTransform transformMatrix;
	
	public Renderer(){
		super();
		setSize(100,100);
		setBackground(new Color(255,255,255));
		setVisible(true);
	}
	
	public void render(GameObject object){
		context.save();
		object.render(context);
		object.renderChildren(this);
		context.restore();
	}
	
	public void switchContext(){
		buffering.show();
		context.graphics.dispose();
		context.graphics = (Graphics2D) buffering.getDrawGraphics();
		context.graphics.clearRect(0, 0, getHeight(), getWidth());
	}
	
	public void init(){
		createBufferStrategy(2); // TODO: Graphics capabilities
		buffering = getBufferStrategy();
		context = new GraphicsContext((Graphics2D) buffering.getDrawGraphics());
	}
}
