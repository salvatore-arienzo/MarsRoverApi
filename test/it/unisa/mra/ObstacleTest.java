package it.unisa.mra;

import static org.junit.Assert.*;

import org.junit.Test;

public class ObstacleTest {

	@Test
	public void testGetObstacle() {
		Obstacle obstacle = new Obstacle(45,67);
		String obs = obstacle.getObstacle();
		assertEquals("(45,67)", obs);
	}

}
