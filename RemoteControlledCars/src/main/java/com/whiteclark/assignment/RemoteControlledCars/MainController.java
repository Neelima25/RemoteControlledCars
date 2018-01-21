package com.whiteclark.assignment.RemoteControlledCars;

import java.util.Scanner;

/**
 * Main class which takes grid size, current position of the car and commands
 * from the command line and outputs the result into the console.
 * 
 * @author Neelima
 *
 */
public class MainController {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int gridX = 15, gridY = 15, x = 1, y = 1;
		String commands;
		System.out.println("Enter the grid size x,y: \n");
		String grid = sc.nextLine();
		String grids[] = grid.split(",");
		if (grids.length > 2 || grids.length < 1) {
			System.out.println("Usage: Enter the grid size as natural number in the format x,y. Example 15,15");
			sc.close();
			System.exit(1);
		}
		try {
			gridX = Integer.parseInt(grids[0]);
			gridY = Integer.parseInt(grids[1]);
		} catch (Exception e) {
			System.out.println("Usage: Enter the grid size as natural number in the format x,y. Example 15,15");
			sc.close();
			System.exit(1);
		}
		System.out.println("Enter the car's position x,y: \n");
		String position = sc.nextLine();
		String pos[] = position.split(",");
		if (pos.length > 2 || pos.length < 1) {
			System.out.println("Usage: Enter the position as natural number in the format x,y. Example 5,5");
			sc.close();
			System.exit(1);
		}
		try {
			x = Integer.parseInt(pos[0]);
			y = Integer.parseInt(pos[1]);
		} catch (Exception e) {
			System.out.println("Usage: Enter the position as natural number in the format x,y. Example 5,5");
			sc.close();
			System.exit(1);
		}
		System.out.println("Enter the commands: \n");
		commands = sc.nextLine();
		start(gridX, gridY, x, y, commands);
		sc.close();
	}

	/**
	 * Takes grid size, current position of the car and the commands and calls the
	 * move method in RemoteControlledCars
	 * 
	 * @param gridX
	 * @param gridY
	 * @param x
	 * @param y
	 * @param commands
	 */
	private static void start(int gridX, int gridY, int x, int y, String commands) {
		RemoteControlledCars rc = new RemoteControlledCars(gridX, gridY);
		Position p = new Position();
		p.setXY(x, y);
		try {
			Position result = rc.move(p, commands);
			if (result == null)
				System.out.println("Car fell off the grid");
			else
				System.out.println("Car is now at : " + result.getX() + "," + result.getY());
		} catch (Exception e) {
			System.out.println(
					"Car's position cannot be calculated as input is invalid. Detail message: " + e.getMessage());
		}
	}
}
