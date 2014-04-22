import java.util.ArrayList;

public class GameObject extends ParentChildClass{
	
	public Vector2 position = new Vector2(0,0);
	public ArrayList<GameObject> children = new ArrayList<GameObject>();
	public Texture texture;
	
	public GameObject(Vector2 zposition, Texture ztexture){
		position = zposition;
		texture = ztexture;
	}
	
	public GameObject(){
		
	}
	
	public void renderChildren(Renderer renderer){
		for(GameObject child : children){
			renderer.render(child);
			child.renderChildren(renderer);
		}
	}
	
	public void render(GraphicsContext ctx){
		ctx.save();
		ctx.graphics.translate(position.x, position.y);
		texture.renderTexture(ctx);
		ctx.restore();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

}
