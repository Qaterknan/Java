import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;


public class ImageTexture extends Texture {

	public Image image;
	public Vector2 dimension = new Vector2(0,0);
	public boolean devMode = false;
	
	@Override
	public void renderTexture(GraphicsContext ctx) {
		ctx.save();
		textureTransform(ctx);
		Graphics2D g = ctx.graphics;
		if(devMode)
			g.drawImage(image, Math.round(-dimension.x/2), Math.round(-dimension.y/2), dimension.ix(),dimension.iy(), new Color(0,255,0),null);
		else
			g.drawImage(image, Math.round(-dimension.x/2), Math.round(-dimension.y/2), dimension.ix(),dimension.iy(), null);
		ctx.restore();
	}
	
	public ImageTexture(Image img, Vector2 zdimension, Vector2 zscale){
		super(new Vector2(0,0), zscale, 0);
		image = img;
		dimension = zdimension;
		scale = zscale;
	}
	
	public void toggleDevMode(){
		devMode = !devMode;
	}
	
	public void tick(){
		
	}

}
