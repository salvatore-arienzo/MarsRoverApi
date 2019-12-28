package it.unisa.mra;


public class Planet {

	private int[][] grid;

	public Planet(int size) {
		this.grid = new int[size][size];

	}

	public int getGridSize() {
		int size = grid.length;
		return size;
	}

	public void addObstacle(int x, int y) throws InvalidInputException {
		if(x > getGridSize()-1 || y > getGridSize()-1 || x<0 || y<0) {
			throw new InvalidInputException("Invalid obstacle location");
		} else {
			grid[x][y] = 1;
		}
	}

	public boolean isObstacle(int x, int y){
		if(grid[x][y] == 0)
			return false;
		else 
			return true;

	}
}