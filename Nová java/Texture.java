public abstract class Texture {
	Vector2 position;
	Vector2 scale;
	float rotation;
	
	public Texture(Vector2 pos, Vector2 scal, float rot){
		position = pos;
		scale = scal;
		rotation = rot;
	}
	
	public void textureTransform(GraphicsContext ctx){
		ctx.graphics.translate(position.x, position.y);
		ctx.graphics.rotate(rotation);
		ctx.graphics.scale(scale.x, scale.y);
	}
	
	public abstract void tick();
	
	public abstract void renderTexture(GraphicsContext ctx);
}
