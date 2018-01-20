package com.whiteclark.assignment.RemoteControlledCars;

public class RemoteControlledCars {
	int gridX, gridY;

	public RemoteControlledCars(int x, int y) {
		this.gridX = x;
		this.gridY = y;
	}

	public Position move(Position position, String command) {
		if (position == null)
			throw new RuntimeException("position object is null");
		if (command == null)
			throw new RuntimeException("Command object is null");
		if (position.getX() < 1 || position.getX() > gridX)
			throw new RuntimeException("x of position is out of range");
		if (position.getY() < 1 || position.getY() > gridY)
			throw new RuntimeException("y of position is out of range");

		return position;
	}
}
