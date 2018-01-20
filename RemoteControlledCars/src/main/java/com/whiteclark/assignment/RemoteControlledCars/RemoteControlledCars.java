package com.whiteclark.assignment.RemoteControlledCars;

public class RemoteControlledCars {
	private int gridX, gridY;

	public RemoteControlledCars(int x, int y) {
		this.gridX = x;
		this.gridY = y;
	}

	public Position move(Position position, String command) {

		if (position == null || command == null)
			throw new RuntimeException("position and command are mandatory");

		int x = position.getX(), y = position.getY();

		if (this.isOutOfGrid(x, y))
			throw new RuntimeException("position is out of range");

		Direction curr = Direction.N;
		char[] commands = command.toUpperCase().toCharArray();

		for (char c : commands) {
			if (c == 'F' && curr == Direction.N) {
				x++;
			} else if (c == 'F' && curr == Direction.E) {
				y++;
			} else if (c == 'F' && curr == Direction.S) {
				x--;
			} else if (c == 'F' && curr == Direction.W) {
				y--;
			} else if (c == 'R' || c == 'L') {
				curr = curr.getDirection(c);
			} else {
				throw new RuntimeException("Invalid Command");
			}
			if (this.isOutOfGrid(x, y))
				return null;
		}
		position.setXY(x, y);
		return position;
	}

	private boolean isOutOfGrid(int x, int y) {
		if (x < 1 || x > gridX)
			return true;
		if (y < 1 || y > gridY)
			return true;
		return false;
	}
}

enum Direction {
	N {
		Direction getDirection(char command) {
			if (command == 'L')
				return W;
			if (command == 'R')
				return E;
			return N;
		}
	},
	E {
		Direction getDirection(char command) {
			if (command == 'L')
				return N;
			if (command == 'R')
				return S;
			return E;
		}
	},
	W {
		Direction getDirection(char command) {
			if (command == 'L')
				return S;
			if (command == 'R')
				return N;
			return W;
		}
	},
	S {
		Direction getDirection(char command) {
			if (command == 'L')
				return E;
			if (command == 'R')
				return W;
			return S;
		}
	};

	Direction getDirection(char command) {
		return N;
	}

}
