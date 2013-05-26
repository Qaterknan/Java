
public class Renderer {
	public void render(boolean[][] grid){
		String output = "";
		for(boolean[] row : grid){
			for(boolean cell : row){
				output += cell ? "#" : ".";
			}
			output += "\n";
		}
		System.out.println(output);
	}
}
