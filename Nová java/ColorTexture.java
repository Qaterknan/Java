import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;


public class ColorTexture extends Texture{
	
	public Color color = new Color(0,255,0);
	public String renderType = "fill";
	public Shape shape;
	float alpha;
	
	public void renderTexture(GraphicsContext ctx){
		ctx.save();
		textureTransform(ctx);
		Graphics2D g = ctx.graphics;
		g.setPaint(color);
		if(renderType == "fill")
			g.fill(shape);
		else if(renderType == "stroke")
			g.draw(shape);
		else
			System.out.println("Non-existent render type");
		ctx.restore();
	}
	
	public ColorTexture (int r, int g, int b, double alfa, String type, Shape s){
		super(new Vector2(0,0), new Vector2(1,1),0);
		alpha = (float) alfa;
		color = new Color(r,g,b,Math.round(alpha*255));
		renderType = type;
		shape = s;
	}
	
	public ColorTexture(int r, int g, int b, double alfa, Shape s){
		super(new Vector2(0,0), new Vector2(1,1), 0);
		alpha = (float) alfa;
		color = new Color(r,g,b,Math.round(alpha*255));
		renderType = "fill";
		shape = s;
	}
	
	public void set(int r, int g, int b, double alfa){
		alpha = (float) alfa;
		color = new Color(r,g,b,Math.round(alpha*255));
	}

	@Override
	public void tick() {
		
	}
}
