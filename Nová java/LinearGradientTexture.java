import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Shape;

public class LinearGradientTexture extends Texture {

	LinearGradientPaint texture;
	Vector2 start;
	Vector2 end;
	float[] ratios;
	Color[] colors;
	Shape shape;
	
	public LinearGradientTexture(Shape s, Vector2 zstart, Vector2 zend, float[] zratios, Color[] zcols, String style){
		super(new Vector2(0,0), new Vector2(1,1), 0);
		shape = s;
		start = zstart;
		end = zend;
		ratios = zratios;
		colors = zcols;
		setStyle(style);
	}
	public void setStyle(String style){
		if(style == "cyclic"){
			texture = new LinearGradientPaint(start.x, start.y, end.x, end.y, ratios, colors, MultipleGradientPaint.CycleMethod.REFLECT);
		}
		else if(style == "tiled"){
			texture = new LinearGradientPaint(start.x, start.y, end.x, end.y, ratios, colors, MultipleGradientPaint.CycleMethod.REPEAT);
		}
		else {
			texture = new LinearGradientPaint(start.x, start.y, end.x, end.y, ratios, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);
		}
	}
	@Override
	public void renderTexture(GraphicsContext ctx) {
		ctx.save();
		ctx.graphics.setPaint(texture);
		textureTransform(ctx);
		ctx.graphics.fill(shape);
		ctx.restore();
	}
	
	public void tick(){
		
	}

}
