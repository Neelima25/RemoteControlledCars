package com.whiteclark.assignment.RemoteControlledCars;

/**
 * Holds the co-ordinates x and y of the car. 'x' represents the vertical axis
 * and 'y' represents horizantal axis
 * 
 * @author Neelima
 *
 */
public class Position {
	private int x, y;

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * A convenient hybrid setter method that sets both x and y at same time.
	 * 
	 * @param x
	 * @param y
	 */
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
