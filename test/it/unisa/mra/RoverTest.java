package it.unisa.mra;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoverTest {

	@Test
	public void testRoverCreation() {
		Rover rover = new Rover();
		rover.setPlanet(10);
		String status = rover.checkStatus();
		assertEquals("(0,0,N)",status);

	}

	@Test
	public void testRoverEmptyCommand() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		String status = rover.move("");
		assertEquals("(0,0,N)",status);

	}

	@Test
	public void testRoverTurningRight() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		String status = rover.move("r");
		assertEquals("(0,0,E)",status);

	}
	@Test
	public void testRoverTurningLeft() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		String status = rover.move("l");
		assertEquals("(0,0,W)",status);

	}
	@Test
	public void testRoverTurningLeftWithUppercaseLetter() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		String status = rover.move("L");
		assertEquals("(0,0,W)",status);

	}
	@Test
	public void testRoverTurningLeftTwoTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.move("L");
		String status = rover.move("l");
		assertEquals("(0,0,S)",status);

	}
	@Test
	public void testRoverTurningRightThreeTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.move("r");
		rover.move("r");
		rover.move("r");
		String status = rover.checkStatus();
		assertEquals("(0,0,W)",status);

	}
	@Test
	public void testRoverTurningRightFourTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.move("r");
		rover.move("r");
		rover.move("r");
		rover.move("r");
		String status = rover.checkStatus();
		assertEquals("(0,0,N)",status);

	}
	@Test
	public void testSetPosition() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(7, 6,"N");
		String status = rover.checkStatus();
		assertEquals("(7,6,N)",status);

	}

	@Test(expected=InvalidInputException.class)
	public void testSetPositionWithInvalidX() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(11, 6,"N");
	}
	@Test(expected=InvalidInputException.class)
	public void testSetPositionWithInvalidY() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(7, 11,"N");
	}

	@Test(expected=InvalidInputException.class)
	public void testSetPositionWithInvalidNegativeY() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(7, -2,"N");
	}
	@Test(expected=InvalidInputException.class)
	public void testSetPositionWithInvalidNegativeX() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(-7, 2,"N");
	}

	@Test
	public void testRoverMovingForward() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(7, 6,"N");
		String status = rover.move("f");
		assertEquals("(7,7,N)",status);

	}
	@Test
	public void testRoverMovingForwardTwoTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(7, 6,"N");
		rover.move("f");
		rover.move("f");
		String status = rover.checkStatus();
		assertEquals("(7,8,N)",status);

	}
	@Test
	public void testRoverMovingBackward() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(5, 8,"E");
		rover.move("b");
		String status = rover.checkStatus();
		assertEquals("(4,8,E)",status);

	}
	
	@Test
	public void testRoverMovingBackwardTwoTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.setRoverPosition(5, 9,"W");
		rover.move("b");
		rover.move("b");
		String status = rover.checkStatus();
		assertEquals("(3,9,W)",status);

	}

	@Test
	public void testRoverMovingCombined() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.move("ffrff");
		String status = rover.checkStatus();
		assertEquals("(2,2,E)",status);

	}
	@Test
	public void testRoverMovesFiveTimes() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.move("f");
		rover.move("f");
		rover.move("r");
		rover.move("f");
		rover.move("f");
		String status = rover.checkStatus();
		assertEquals("(2,2,E)",status);

	}
	@Test
	public void testWrappingSouthPosition() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(100);
		rover.move("b");
		String status = rover.checkStatus();
		assertEquals("(0,99,N)",status);

	}

	@Test
	public void testWrappingSouthPosition2Times() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(100);
		rover.move("bb");
		String status = rover.checkStatus();
		assertEquals("(0,98,N)",status);

	}
	@Test
	public void testWrappingNorthPosition() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(100);
		rover.setRoverPosition(0, 99, "N");
		rover.move("f");
		String status = rover.checkStatus();
		assertEquals("(0,0,N)",status);

	}
	@Test
	public void testWrappingWestPosition() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(100);
		rover.setRoverPosition(0, 0, "W");
		rover.move("f");
		String status = rover.checkStatus();
		assertEquals("(99,0,W)",status);

	}
	@Test
	public void testWrappingEstPosition() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(100);
		rover.setRoverPosition(0, 0, "E");
		rover.move("b");
		String status = rover.checkStatus();
		assertEquals("(99,0,E)",status);

	}


	@Test
	public void testSingleObstacle() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.addObstacle(2, 2);
		String status = rover.move("ffrfff");
		assertEquals("(1,2,E)(2,2)",status);

	}

	@Test
	public void testMultipleObstacles() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.addObstacle(2, 2);
		rover.addObstacle(2, 1);
		String status = rover.move("ffrfffrflf");
		assertEquals("(1,1,E)(2,2)(2,1)",status);

	}
	@Test
	public void testWrappedObstacles() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(10);
		rover.addObstacle(0,9);
		String status = rover.move("b");
		assertEquals("(0,0,N)(0,9)",status);
	}

	@Test
	public void testTourAroundThePlanet() throws InvalidInputException {
		Rover rover = new Rover();
		rover.setPlanet(6);
		rover.addObstacle(2, 2);
		rover.addObstacle(0, 5);
		rover.addObstacle(5, 0);
		String status = rover.move("ffrfffrbbblllfrfrbbl");
		assertEquals("(0,0,N)(2,2)(0,5)(5,0)",status);
	}
}
