import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Pool {
	int generation = 0;
	int width = 10;
	int height = 50;
	
	Random random = new Random();

	// public boolean[][] grid1 = new boolean[width][height];
	// public boolean[][] grid2 = new boolean[width][height];
	public boolean[][][] buffer = new boolean[2][width][height];
	byte bufferPointer = 0;
	// rules
	Set<Integer> birth = new HashSet<Integer>(9);
	Set<Integer> survive = new HashSet<Integer>(9);
	
	Renderer renderer = new Renderer(); 
	
	public Pool(){
		birth.add(3);
		survive.add(2);
		survive.add(3);
		buffer[0][0][1] = true;
		buffer[0][1][2] = true;
		buffer[0][2][2] = true;
		buffer[0][2][1] = true;
		buffer[0][2][0] = true;
		
		while(true){
			long past = System.nanoTime();
			renderer.render(buffer[bufferPointer]);
			tick();
			if(generation % 50 == 0){
				randomizeGrid();
			}
			long now = System.nanoTime();
			double duration = (now-past)/1000;
			System.out.println("time [ms]: "+duration+" Generation: "+generation);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void randomizeGrid() {
		for(int x = 0;x<width;x++){
			for(int y = 0;y<height;y++){
				buffer[bufferPointer][x][y] = random.nextBoolean();
			}
		}
	}
	/**
	 * @param args
	 */
	public void tick(){
		boolean[][] grid = buffer[bufferPointer];
		boolean[][] newGrid = buffer[1-bufferPointer];
		
		for(int x = 0;x<width;x++){
			for(int y = 0;y<height;y++){
				int neighbors = getNeighbors(x,y,grid);
				boolean current = grid[x][y];
				// System.out.println(x+"x"+y+": "+neighbors);
				if(survive.contains(neighbors)){
					newGrid[x][y] = current;
				}
				else {
					newGrid[x][y] = false;
				}
				
				if(birth.contains(neighbors)){
					newGrid[x][y] = true;
				}
			}
		}
		grid = newGrid;
		generation++;
		bufferPointer = (byte) (1 - bufferPointer);
		// System.out.println(generation);
	}
	
	private int getNeighbors(int x, int y, boolean[][] grid) {
		int number = 0;
		for(int xg = Math.max(0,x-1); xg <= Math.min(width-1,x+1); xg++){
			for(int yg = Math.max(0,y-1); yg <= Math.min(height-1,y+1); yg++){
				if(xg == x && yg == y){
					continue;
				}
				
				if(grid[xg][yg]){
					number++;
				}
			}
		}	
		return number;
	}
	
	public static void main(String[] args) {
		new Pool();
	}
}
