package com.whiteclark.assignment.RemoteControlledCars;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RemoteControlledCarsTest extends TestCase {
	RemoteControlledCars rc;

	Position position;

	public RemoteControlledCarsTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(RemoteControlledCarsTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		position = new Position();
		rc = new RemoteControlledCars();
	}

	/**
	 * Test case1 for a positive scenario
	 */
	public void testPositiveCaseOne() {

		position.setX(5);
		position.setY(5);
		Position result = rc.move(position, "FRF");
		assertEquals(6, result.getX());
		assertEquals(6, result.getY());
	}

	/**
	 * Test case2 for a positive scenario
	 */
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
	public void testPositiveCaseThree() {
		position.setX(15);
		position.setY(15);
		Position result = rc.move(position, "LFR");
		assertEquals(15, result.getX());
		assertEquals(14, result.getY());
	}

	/**
	 * Test case4 for a positive scenario
	 */
	public void testPositiveCaseFour() {
		position.setXY(1, 15);
		Position result = rc.move(position, "FR");
		assertEquals(2, result.getX());
		assertEquals(15, result.getY());
	}

	/**
	 * Test case5 for a positive scenario
	 */
	public void testPositiveCaseFive() {
		position.setXY(15, 1);
		Position result = rc.move(position, "RF");
		assertEquals(15, result.getX());
		assertEquals(2, result.getY());
	}

	/**
	 * Test case6 for a negative scenario
	 */
	public void testNegativeCaseOne() {
		position.setXY(1, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

	/**
	 * Test case7 for a negative scenario
	 */
	public void testNegativeCaseTwo() {
		position.setXY(1, 1);
		Position result = rc.move(position, "RFRF");
		assertNull(result);
	}

	/**
	 * Test case8 for a negative scenario
	 */
	public void testNegativeCaseThree() {
		position.setXY(15, 15);
		Position result = rc.move(position, "F");
		assertNull(result);
	}

	/**
	 * Test case9 for a negative scenario
	 */
	public void testNegativeCaseFour() {
		position.setXY(15, 15);
		Position result = rc.move(position, "LFRF");
		assertNull(result);
	}

	/**
	 * Test case10 for a negative scenario
	 */
	public void testNegativeCaseFive() {
		position.setXY(1, 15);
		Position result = rc.move(position, "RF");
		assertNull(result);
	}

	/**
	 * Test case11 for a negative scenario
	 */
	public void testNegativeCaseSix() {
		position.setXY(15, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

}
