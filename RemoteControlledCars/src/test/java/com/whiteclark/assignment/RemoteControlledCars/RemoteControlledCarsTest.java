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
	 * Test case1 for a positive scenario
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
	@Test
	public void testPositiveCaseFive() {
		position.setXY(15, 1);
		Position result = rc.move(position, "RF");
		assertEquals(15, result.getX());
		assertEquals(2, result.getY());
	}

	/**
	 * Test case6 for a negative scenario
	 */
	@Test
	public void testNegativeCaseOne() {
		position.setXY(1, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

	/**
	 * Test case7 for a negative scenario
	 */
	@Test
	public void testNegativeCaseTwo() {
		position.setXY(1, 1);
		Position result = rc.move(position, "RFRF");
		assertNull(result);
	}

	/**
	 * Test case8 for a negative scenario
	 */
	@Test
	public void testNegativeCaseThree() {
		position.setXY(15, 15);
		Position result = rc.move(position, "F");
		assertNull(result);
	}

	/**
	 * Test case9 for a negative scenario
	 */
	@Test
	public void testNegativeCaseFour() {
		position.setXY(15, 15);
		Position result = rc.move(position, "LFRF");
		assertNull(result);
	}

	/**
	 * Test case10 for a negative scenario
	 */
	@Test
	public void testNegativeCaseFive() {
		position.setXY(1, 15);
		Position result = rc.move(position, "RF");
		assertNull(result);
	}

	/**
	 * Test case11 for a negative scenario
	 */
	@Test
	public void testNegativeCaseSix() {
		position.setXY(15, 1);
		Position result = rc.move(position, "LF");
		assertNull(result);
	}

	/**
	 * Test case12 for a invalid input
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidInputOne() {
		position.setXY(-1, -1);
		rc.move(position, "LF");
	}

	/**
	 * Test case13 for a invalid input
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidInputTwo() {
		position.setXY(16, 16);
		rc.move(position, "FF");
	}

	/**
	 * Test case14 for a invalid input
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidInputThree() {
		position.setXY(1, 1);
		rc.move(position, "ABCDE");
	}

	/**
	 * Test case15 for a invalid input
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidInputFour() {
		rc.move(null, "ABCDE");
	}

	/**
	 * Test case16 for a invalid input
	 */
	@Test(expected = RuntimeException.class)
	public void testInvalidInputFive() {
		rc.move(null, null);
	}
}
