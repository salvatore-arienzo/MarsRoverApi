package it.unisa.mra;

public class Obstacle {

	private int x,y;

	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getObstacle() {
		return ("("+ x + "," + y + ")");
	}
}
