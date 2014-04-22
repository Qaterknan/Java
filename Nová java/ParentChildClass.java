import java.util.ArrayList;


public abstract class ParentChildClass {
	
	public ArrayList<ParentChildClass> children = new ArrayList<ParentChildClass>();
	
	public void tickChildren(){
		for(ParentChildClass child : children){
			child.tick();
			child.tickChildren();
		}
	}
	
	public abstract void tick();
}
