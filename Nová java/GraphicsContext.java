import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


public class GraphicsContext {
	public Graphics2D graphics;
	private ArrayList<AffineTransform> listOfTransforms = new ArrayList<AffineTransform>();
	
	public GraphicsContext(Graphics2D g){
		graphics = g;
	}
	
	public void save(){
		listOfTransforms.add(graphics.getTransform());
	}
	
	public void restore(){
		graphics.setTransform(listOfTransforms.get(listOfTransforms.size()-1));
		listOfTransforms.remove(listOfTransforms.size()-1);
	}
}
