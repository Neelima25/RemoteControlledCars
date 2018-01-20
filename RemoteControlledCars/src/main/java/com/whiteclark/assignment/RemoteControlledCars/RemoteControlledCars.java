package com.whiteclark.assignment.RemoteControlledCars;

public class RemoteControlledCars {
	int gridX, gridY;

	public RemoteControlledCars(int x, int y) {
		this.gridX = x;
		this.gridY = y;
	}

	public Position move(Position position, String command) {

		if (position == null || command == null)
			throw new RuntimeException("position and command are mandatory");

		int x = position.getX();
		int y = position.getY();

		if (x < 1 || x > gridX)
			throw new RuntimeException("x of position is out of range");
		if (y < 1 || y > gridY)
			throw new RuntimeException("y of position is out of range");

		Direction curr = Direction.N;

		command = command.toUpperCase();
		char[] commands = command.toCharArray();

		for (char c : commands) {
			if (c == 'F' && curr == Direction.N) {

				x++;
				if (this.checkGrid(x, y))
					return null;
				continue;

			}
			if (c == 'F' && curr == Direction.E) {

				y++;
				if (this.checkGrid(x, y))
					return null;
				continue;
			}
			if (c == 'F' && curr == Direction.S) {

				x--;
				if (this.checkGrid(x, y))
					return null;
				continue;
			}
			if (c == 'F' && curr == Direction.W) {

				y--;
				if (this.checkGrid(x, y))
					return null;
				continue;
			}
			if (c == 'R' || c == 'L') {
				curr = curr.getDirection(c);
				continue;
			}
			throw new RuntimeException("Invalid Command");
		}
		position.setXY(x, y);
		return position;
	}

	private boolean checkGrid(int x, int y) {
		if (x < 1 || x > gridX)
			return true;
		if (y < 1 || y > gridY)
			return true;
		return false;
	}
}

enum Direction {
	N {
		public Direction getDirection(char command) {
			if (command == 'L')
				return W;
			if (command == 'R')
				return E;
			return N;
		}
	},
	E {
		public Direction getDirection(char command) {
			if (command == 'L')
				return N;
			if (command == 'R')
				return S;
			return E;
		}
	},
	W {
		public Direction getDirection(char command) {
			if (command == 'L')
				return S;
			if (command == 'R')
				return N;
			return W;
		}
	},
	S {
		public Direction getDirection(char command) {
			if (command == 'L')
				return E;
			if (command == 'R')
				return W;
			return S;
		}
	};

	public Direction getDirection(char command) {
		return N;
	}

}
