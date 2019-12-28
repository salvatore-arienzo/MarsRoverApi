package it.unisa.mra;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlanetTest {

	@Test
	public void testCreatePlanet() {
		Planet planet = new Planet(100);
		int size = planet.getGridSize();
		assertEquals(100,size);
		
	}
	@Test
	public void testCheckIsObstacle() throws InvalidInputException {
		Planet planet = new Planet(100);
		planet.addObstacle(45, 67);
		boolean checkObstacle = planet.isObstacle(45, 67);
		assertTrue(checkObstacle);
	
		
	}
	
	@Test
	public void testCheckIsNotObstacle() throws InvalidInputException {
		Planet planet = new Planet(100);
		planet.addObstacle(45, 67);
		boolean checkObstacle = planet.isObstacle(46, 67);
		assertFalse(checkObstacle);
	
		
	}
	
	@Test(expected=InvalidInputException.class)
	public void testInvalidObstaclePositionOnX() throws InvalidInputException {
		Planet planet = new Planet(100);
		planet.addObstacle(101, 67);
	
	}
	@Test(expected=InvalidInputException.class)
	public void testInvalidObstaclePositionOnY() throws InvalidInputException {
		Planet planet = new Planet(100);
		planet.addObstacle(45, 101);
	
	}
	
	
	

}
