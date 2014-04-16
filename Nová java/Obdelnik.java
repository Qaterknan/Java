import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.GeneralPath;
import java.awt.Color;


public class Obdelnik extends GraphicsObject {

	Vector2 dimension = new Vector2(0,0);
	Color color = new Color(0,0,0);
	
	public Obdelnik(Vector2 zposition, Vector2 zdimension, Color col){
		super(zposition, zdimension, col);
		dimension = zdimension;
	}
	public Obdelnik(Vector2 zposition, Vector2 zdimension, Color col1, Color col2){ //Velmi základní
		super(zposition, zdimension,new Vector2(-zdimension.x/2, 0), col1, new Vector2(zdimension.x/2,0), col2, false);
		dimension = zdimension;
		//TODO: vertikální gradient
	}
	public Obdelnik(Vector2 zposition, Vector2 zdimension, Image img){
		super(zposition, zdimension, img);
		dimension = zdimension;
	}
	@Override
	public GeneralPath drawPath(Graphics2D graphics) {
		GeneralPath path = new GeneralPath();
		path.moveTo(-dimension.x/2,dimension.y/2);
		path.lineTo(-dimension.x/2,-dimension.y/2);
		path.lineTo(dimension.x/2, -dimension.y/2);
		path.lineTo(dimension.x/2, dimension.y/2);
		path.closePath();
		return path;
	}

}
