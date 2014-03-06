
public class Vector2 {
	float x = 0;
	float y = 0;
	
	public Vector2(float zx, float zy){
		x = zx;
		y = zy;
	}
	
	public void add(Vector2 v){
		x += v.x;
		y += v.y;
	}
	
	public void multiplyScalar(float s){
		x *= s;
		y *= s;
	}
	
	public float scalarProduct(Vector2 v){
		return v.x*x+v.y*y;
	}
	
	public int ix(){
		return Math.round(x);
	}
	
	public int iy(){
		return Math.round(y);
	}
	// TODO: Další metody
}
