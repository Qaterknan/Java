import java.awt.Color;
import java.awt.Image;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;

public abstract class GraphicsObject {
	
	Color color = new Color(0,0,0);
	public GradientPaint gradient;
	public Image image;
	Vector2 position = new Vector2(0,0);
	Vector2 dimension = new Vector2(0,0);
	Vector2 positionInImage;
	Vector2 dimensionInImage;
	String textureType = "none";
	String renderType = "fill";
	
	
	public GraphicsObject (Vector2 zposition, Vector2 zdimension, Color zcolor){
		position = zposition;
		dimension = zdimension;
		color = zcolor;
		textureType = "color";
	}
	
	public GraphicsObject (Vector2 zposition, Vector2 zdimension, Image imageIn, Vector2 zpositionInImage, Vector2 zdimensionInImage){
		position = zposition;
		dimension = zdimension;
		positionInImage = zpositionInImage;
		dimensionInImage = zdimensionInImage;
		image = imageIn;
		textureType = "texture";
	}
	
	public GraphicsObject (Vector2 zposition, Vector2 zdimension, Image imageIn){
		this(
			zposition,
			zdimension,
			imageIn,
			new Vector2(0,0),
			new Vector2(
				imageIn.getWidth(null),
				imageIn.getHeight(null)
			)
		);
	}
	
	public GraphicsObject (Vector2 zposition, Vector2 zdimension, Vector2 point1, Color col1, Vector2 point2, Color col2, boolean cyclic){
		position = zposition;
		dimension = zdimension;
		gradient = new GradientPaint(point1.x, point1.y, col1, point2.x, point2.y, col2, cyclic);
		textureType = "gradient";
		// TODO: dod�lat cyclic gradient a dynamick� m�n�n� gradientu
	}
	
	public void render(Graphics2D context){
		if(textureType == "texture"){
			context.drawImage(
					image, // Image obr�zek, z ImageIO.read(File source)
					0, // pozice obr�zku x
					0, // pozice obr�zku y
					dimension.ix(), // rozm�ry vid�n� ���ka
					dimension.iy(), // rozm�ry vid�n� v��ka
					positionInImage.ix(), // pozice v��ezu x
					positionInImage.iy(), // pozice v��ezu y
					dimensionInImage.ix(), // konec v��ezu ���ka od x
					dimensionInImage.iy(), // konec v��ezu - v��ka od y
					null // ImageObserver
				);
			return;
		}
		else if(textureType == "color"){
			context.setPaint(color);
		}
		else if(textureType == "gradient"){
			context.setPaint(gradient);
		}
		else return;
		GeneralPath path = drawPath(context);
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
		// Metoda je implementov�na ka�d�m konkr�tn�m objektem zvl�t�
}
