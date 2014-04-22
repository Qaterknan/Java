import java.awt.Image;
import java.util.Date;


public class FilmstripAnimatedTexture extends Texture {
	
	Vector2 currentFrame = new Vector2(0,0);
	float frameWidth;
	float frameHeight;
	Vector2 frameMap;
	
	Vector2 dimension;
	int speed = 20;
	Image image;
	
	long lastTime;
	
	public FilmstripAnimatedTexture(Image img, Vector2 frames, int s, Vector2 dim, Vector2 scal){
		super(new Vector2(0,0), scal, 0);
		frameWidth = img.getWidth(null)/frames.x;
		frameHeight = img.getHeight(null)/frames.y;
		frameMap = frames;
		speed = s;
		dimension = dim;
		image = img;
		lastTime = new Date().getTime();
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		long currentTime = new Date().getTime();
		if(currentTime > lastTime+speed){
			lastTime = currentTime;
			if(currentFrame.x+2 > frameMap.x){
				if(currentFrame.y+2 > frameMap.y){
					currentFrame.y = 0;
					currentFrame.x = 0;
				}
				else{
					currentFrame.y++;
					currentFrame.x = 0;
				}
			}
			else
				currentFrame.x++;
		}
	}

	@Override
	public void renderTexture(GraphicsContext ctx) {
		// TODO Auto-generated method stub
		ctx.graphics.drawImage(
				image,
				Math.round((float) -dimension.x/2),
				Math.round((float) -dimension.y/2),
				Math.round(dimension.x/2),
				Math.round(dimension.y/2),
				Math.round(currentFrame.x*frameWidth),
				Math.round(currentFrame.y*frameHeight),
				Math.round((currentFrame.x+1)*frameWidth),
				Math.round((currentFrame.y+1)*frameHeight),
				null
			);
	}

}
