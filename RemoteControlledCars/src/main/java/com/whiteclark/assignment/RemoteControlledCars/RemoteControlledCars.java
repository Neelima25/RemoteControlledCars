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
		if (position.getX() < 1 || position.getX() > gridX)
			throw new RuntimeException("x of position is out of range");
		if (position.getY() < 1 || position.getY() > gridY)
			throw new RuntimeException("y of position is out of range");
		Direction curr = Direction.N;
		
		
		
		
		return position;
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
