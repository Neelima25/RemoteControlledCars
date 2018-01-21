package com.whiteclark.assignment.RemoteControlledCars;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RemoteControlledCarsTest {
	RemoteControlledCars rc;
	Position position;

	@Before
	public void setUp() throws Exception {
		position = new Position();
		rc = new RemoteControlledCars(15, 15);
	}

	/**
	 * Test case1 for a positive scenario with valid position and empty command
	 */
	@Test
	public void testPositiveCaseOne() {

		position.setX(5);
		position.setY(5);
		Position result = rc.move(position, "");
		assertEquals(5, result.getX());
		assertEquals(5, result.getY());
	}

	/**
	 * Test case2 for a positive scenario
	 */
	@Test
	public void testPositiveCaseTwo() {
		position.setX(1);
		position.setY(1);
		Position result = rc.move(position, "RFR");
		assertEquals(1, result.getX());
		assertEquals(2, result.getY());
	}

	/**
	 * Test case3 for a positive scenario
	 */
	@Test
	public void testPositiveCaseThree() {
		position.setXY(5, 5);
		Position result = rc.move(position, "RFLFRFLF");
		assertEquals(7, result.getX());
		assertEquals(7, result.getY());
	}

	/**
	 * Test case4 for a positive scenario
	 */
	public void testPositiveCaseFour() {
		position.setXY(6, 6);
		Position result = rc.move(position, "FFLFFLFFLFF");
		assertEquals(6, result.getX());
		assertEquals(6, result.getY());
	}

	/**
	 * Test case5 for a positive scenario
	 */
	@Test
	public void testPositiveCaseFive() {
		position.setXY(5, 5);
		Position result = rc.move(position, "FLFLFFRFFF");
		assertEquals(4, result.getX());
		assertEquals(1, result.getY());
	}

	/**
	 * Test case6 for a negative scenario to get car out of grid
	 */
	@Test
	public void testNegativeOffTheGridOne() {
		position.setXY(1, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

	/**
	 * Test case7 for a negative scenario
	 */
	@Test
	public void testNegativeOffTheGridTwo() {
		position.setXY(15, 15);
		Position result = rc.move(position, "F");
		assertNull(result);
	}

	/**
	 * Test case8 for a negative scenario
	 */
	@Test
	public void testNegativeOffTheGridThree() {
		position.setXY(15, 15);
		Position result = rc.move(position, "LFRF");
		assertNull(result);
	}

	/**
	 * Test case9 for a negative scenario
	 */
	@Test
	public void testNegativeOffTheGridFour() {
		position.setXY(15, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

	/**
	 * Test case10 for a out of grid current position
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidPosition() {
		position.setXY(-1, -1);
		rc.move(position, "LF");
	}

	/**
	 * Test case11 for a invalid command
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidCommand() {
		position.setXY(1, 1);
		rc.move(position, "ABCDE");
	}

	/**
	 * Test case12 for a null position
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidNullPosition() {
		rc.move(null, "FF");
	}

	/**
	 * Test case13 for a null position and null command
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidNullPositionAndCommand() {
		rc.move(null, null);
	}

	/**
	 * Test case14 for zero grid size
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidZeroGridSize() {
		RemoteControlledCars rc2 = new RemoteControlledCars(0, 0);
		position.setXY(1, 1);
		rc2.move(position, "F");
	}
}
