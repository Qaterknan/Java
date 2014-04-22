import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;


public class ImageTexture implements Texture {

	public Image image;
	public Vector2 scale = new Vector2(1,1);
	public Vector2 dimension = new Vector2(0,0);
	public boolean devMode = false;
	
	@Override
	public void renderTexture(GraphicsContext ctx) {
		ctx.save();
		Graphics2D g = ctx.graphics;
		g.scale(scale.x, scale.y);
		if(devMode)
			g.drawImage(image, Math.round(-dimension.x/2), Math.round(-dimension.y/2), dimension.ix(),dimension.iy(), new Color(0,255,0),null);
		else
			g.drawImage(image, Math.round(-dimension.x/2), Math.round(-dimension.y/2), dimension.ix(),dimension.iy(), null);
		ctx.restore();
	}
	
	public ImageTexture(Image img, Vector2 zdimension, Vector2 zscale){
		image = img;
		dimension = zdimension;
		scale = zscale;
	}

}
