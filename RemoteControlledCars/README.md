# Remote Controlled Cars

## Problem Statement
Cars are placed on a 15 by 15 grid at particular co-ordinates heading north, and the simple
commands Left, right and forward are transmitted to them. The commands must be executed and
the final position calculated.
The following examples should be used to demonstrate your code:
- For the input &quot;5,5:RFLFRFLF&quot;, we should get the position &quot;7,7&quot;
- For the input &quot;6,6:FFLFFLFFLFF&quot;, we should get the position &quot;6,6&quot;
- For the input &quot;5,5:FLFLFFRFFF&quot;, we should get the position &quot;4,1&quot;

## Assumptions
1. The grid number always starts from 1.
2. In the position (x,y), x represents the vertical axis and y represents horizantal axis (as per thrid example in the problem statement). 
3. If the command moves the car out of the grid, then, as there will be no new position, 'null' to be returned indicating 'off the grid'.
4. If the initial position is invalid (ex: -1.-1) or commands are invalid, then a RuntimeException to be thrown.
 
## Solution
#### Classes Used
- RemoteControlledCars.java - has move() method which performs the move operation
- Direction - Enum that tells the direction, and changes the direction based on the given command.
- Position.java - holds the position of the car
- MainController - has the main method with simple command-line user interface

#### Test Class
- RemoteControlledCarsTest.java

#### Implementation
1. The Position object represents the car and holds its current position in x,y properties.
2. The size of the grid can be set while initializing the 'RemoteControlledCars' object, default value is 15.
     - If the grid is initialized with a non-natural number, then a RuntimeException is thrown by the move() method. 
3. The 'move()' method in the class 'RemoteControlledCars' takes two arguments, the position object which represents the car's position and the commands as a string. If,
     - input is invalid (current position is out of grid or commands has characters that are not in 'R', 'L', 'F') then RuntimeException is thrown.
     - the current position is valid and the command takes the car 'out of the grid', then null is returned.
     - the input is valid and the command moves the car inside the grid range, then a position object with the new co-ordinates are returned.


## How to run
- You can run the test class - RemoteControlledCarsTest.java which has ample of unit test cases with all positive and negative scenarios.
- You can also run main method in 'MainController' class to have a user interface which takes inputs from command-line and outputs the result on to the console. 
