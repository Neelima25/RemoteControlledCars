package com.whiteclark.assignment.RemoteControlledCars;

public class RemoteControlledCars {
	private int gridX = 15, gridY = 15;

	public RemoteControlledCars() {
	}

	public RemoteControlledCars(int x, int y) {
		this.gridX = x;
		this.gridY = y;
	}

	/**
	 * This method is responsible to move the car to a new position based on the
	 * commands taken as input arguments. This method, when command is F, changes
	 * the x or y values by '1' based on the current direction. On the other hand if
	 * the command is 'L' or 'R', the current direction is changed by the Direction
	 * enum.
	 * 
	 * @param position
	 *            - {@link Position} object that is initial location of car on the grid
	 * @param commands
	 *            - string of commands
	 * @return 'position' object with final coordinates of car. if car moves out of
	 *         grid, null is returned. If input is invalid then RuntimeException is
	 *         thrown.
	 */
	public Position move(Position position, String commands) {

		if (position == null || commands == null)
			throw new RuntimeException("position and command are mandatory");

		int x = position.getX(), y = position.getY();

		if (this.isOutOfGrid(x, y))
			throw new RuntimeException("position is out of range");

		Direction curr = Direction.NORTH;
		char[] cmds = commands.toUpperCase().toCharArray();

		for (char cmd : cmds) {
			if (cmd == 'F' && curr == Direction.NORTH) {
				x++;
			} else if (cmd == 'F' && curr == Direction.EAST) {
				y++;
			} else if (cmd == 'F' && curr == Direction.SOUTH) {
				x--;
			} else if (cmd == 'F' && curr == Direction.WEST) {
				y--;
			} else if (cmd == 'R' || cmd == 'L') {
				curr = curr.getDirection(cmd);
			} else {
				throw new RuntimeException("Invalid Command");
			}
			if (this.isOutOfGrid(x, y))
				return null;
		}
		position.setXY(x, y);
		return position;
	}

	/**
	 * Takes the current position of the car (x,y) and determines whether it is IN
	 * the grid range or 'Off the grid'. Returns true if it is off the grid, false
	 * otherwise.
	 * 
	 * @param x
	 * @param y
	 * @return true if position is off the grid, false otherwise.
	 */
	private boolean isOutOfGrid(int x, int y) {
		if (x < 1 || x > gridX)
			return true;
		if (y < 1 || y > gridY)
			return true;
		return false;
	}
}

/**
 * Direction enum which has 4 objects NORTH, SOUTH, WEST, EAST. These objects
 * have their own implementation of getDirection() method. This method takes
 * command character of either L or R and returns the left direction or right
 * direction of current direction.
 * 
 * @author Neelima
 *
 */
enum Direction {
	NORTH {
		/**
		 * Returns Left of NORTH as WEST and Right of NORTH as EAST
		 */
		Direction getDirection(char command) {
			if (command == 'L')
				return WEST;
			if (command == 'R')
				return EAST;
			return NORTH;
		}
	},
	EAST {
		/**
		 * Returns Left of EAST as NORTH and Right of EAST as SOUTH
		 */
		Direction getDirection(char command) {
			if (command == 'L')
				return NORTH;
			if (command == 'R')
				return SOUTH;
			return EAST;
		}
	},
	WEST {
		/**
		 * Returns Left of WEST as SOUTH and Right of WEST as NORTH
		 */
		Direction getDirection(char command) {
			if (command == 'L')
				return SOUTH;
			if (command == 'R')
				return NORTH;
			return WEST;
		}
	},
	SOUTH {
		/**
		 * Returns Left of SOUTH as EAST and Right of SOUTH as WEST
		 */
		Direction getDirection(char command) {
			if (command == 'L')
				return EAST;
			if (command == 'R')
				return WEST;
			return SOUTH;
		}
	};

	/**
	 * Default direction at the initial stage. This is defaulted to North
	 * 
	 * @param command
	 * @return North
	 */
	Direction getDirection(char command) {
		return NORTH;
	}

}
