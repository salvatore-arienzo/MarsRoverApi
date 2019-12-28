package it.unisa.mra;

import java.util.ArrayList;

public class Rover {
	private int x;
	private int y;
	private String direction;
	private Planet planet;
	private  ArrayList<Obstacle> obstacles;

	public Rover() {
		this.planet=null;
		this.x = 0;
		this.y = 0;
		this.direction = "N";
		this.obstacles = new ArrayList<Obstacle>();
	}

	public String checkStatus() {
		return "(" + x + "," + y +","+ direction + ")";
	}

	public void setRoverPosition(int newX, int newY, String newDirection) throws InvalidInputException {
		this.x=newX;
		this.y=newY;
		this.direction=newDirection;
		if(x > planet.getGridSize()-1 || y > planet.getGridSize()-1 || x<0 || y<0) {
			throw new InvalidInputException("Invalid location");
		}
	}

	public void turnRight(){
		if(direction.equalsIgnoreCase("N")) {
			this.direction="E";
		} else if(direction.equalsIgnoreCase("E")) {
			this.direction="S";
		} else if(direction.equalsIgnoreCase("S")) {
			this.direction="W";
		} else if(direction.equalsIgnoreCase("W")) {
			this.direction="N";
		} 
	} 

	public void turnLeft() {
		if(direction.equalsIgnoreCase("N")) {
			this.direction="W";
		} else if(direction.equalsIgnoreCase("W")) {
			this.direction="S";
		} else if(direction.equalsIgnoreCase("S")) {
			this.direction="E";
		} else if(direction.equalsIgnoreCase("E")) {
			this.direction="N";
		} 
	} 

	public void moveForward() {
		int oldX=x;
		int oldY=y;
		if(direction.equalsIgnoreCase("N")) {
			if(this.y == planet.getGridSize()-1) {
				y = 0;
			} else {
				y+=1;
			}
		}
		else if(direction.equalsIgnoreCase("S")) {
			if(this.y == 0) {
				y = planet.getGridSize()-1;
			} else {
				y-=1;
			}
		} else if(direction.equalsIgnoreCase("W")) {
			if(this.x == 0) {
				x = planet.getGridSize()-1;
			} else {
				x-=1;
			}
		} else if (direction.equalsIgnoreCase("E")) {
			if(this.x == planet.getGridSize()-1) {
				x = 0;
			} else {
				x+=1;
			}
		}
		if(planet.isObstacle(x, y)) {
			Obstacle obstacle_found = new Obstacle(x,y);
			obstacles.add(obstacle_found);
			this.x = oldX;
			this.y = oldY;
		} 

	}

	public void moveBackward() {
		int oldX = x;
		int oldY = y;
		if(direction.equalsIgnoreCase("N")) {
			if(this.y == 0) {
				y = planet.getGridSize()-1;
			} else {
				y-=1;
			}
		}
		else if(direction.equalsIgnoreCase("S")) {
			if(this.y == planet.getGridSize()-1) {
				y = 0;
			} else {
				y+=1;
			}
		} else if(direction.equalsIgnoreCase("W")) {
			if(this.x == planet.getGridSize()-1) {
				x = 0;
			} else {
				x-=1;
			}
		} else if (direction.equalsIgnoreCase("E")) {
			if(this.x == 0) {
				x = planet.getGridSize()-1;
			} else {
				x-=1;
			}
		}
		if(planet.isObstacle(x, y)) {
			Obstacle obstacle_found = new Obstacle(x,y);
			obstacles.add(obstacle_found);
			this.x = oldX;
			this.y = oldY;
		} 
	}

	public String move(String moves) throws InvalidInputException {
		if(moves.equals("")) {
			return checkStatus();
		} else {
			for(int i = 0; i<=moves.length()-1;i++) {
				char mov = moves.charAt(i);
				String move = String.valueOf(mov);
				if(move.equalsIgnoreCase("f")) {
					moveForward();
				} else if(move.equalsIgnoreCase("b")) {
					moveBackward();
				} else if(move.equalsIgnoreCase("l")) {
					turnLeft();
				} else if(move.equalsIgnoreCase("r")) {
					turnRight();
				} else throw new InvalidInputException("Invalid Input");
			}

			if(obstacles.isEmpty()) {
				return checkStatus();
			} else {
				String obstacle ="";
				for(int i = 0; i<obstacles.size();i++) {
					if(!obstacle.contains(obstacles.get(i).getObstacle())) {
						obstacle = obstacle + (obstacles.get(i).getObstacle());
					}
				}
				return checkStatus() + obstacle;
			}
		}
	}

	public void setPlanet(int size) {
		this.planet = new Planet(size);
	}

	public void addObstacle(int x,int y) throws InvalidInputException {
		planet.addObstacle(x, y);
	}	
}