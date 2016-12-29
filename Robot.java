

/**
 * 
 * @author Alek Lisiecki inner class for Board but in separate file to make code
 *         cleaner
 */
class Robot {
	private int robotPozX;
	private int robotPozY;
	private int blocksOnTruck;
	private char direction;
	final Board outer;

	/**
	 * sets robot on (x,y) position
	 * 
	 * @param x
	 *            - horizontal robots position
	 * @param y
	 *            - vertical robot position
	 */

	Robot(int x, int y, Board outer) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("x and y must be positive.");
		}
		robotPozX = x;
		robotPozY = y;
		blocksOnTruck = 0;
		direction = 'N';
		this.outer = outer;
	}
	

	Robot(int x, int y, int numberOfBlocks, Board outer, char startDirection) {
		robotPozX = x;
		robotPozY = y;
		blocksOnTruck = numberOfBlocks;
		Character.toUpperCase(startDirection);
		if (direction != 'N' && direction != 'W' && direction != 'S' && direction != 'E') {
			direction = 'N';
			throw new RuntimeException("There is no direction like that.Don't worry I set direction to N.");
		} else {
			direction = startDirection;
		}
		this.outer = outer;
	}
	
	int blockOn(){
		return blocksOnTruck;
	}
	
	int[] getCurrentPoz(){
		int[] XY = new int[2];
		XY[0] = robotPozX;
		XY[1] = robotPozY;
		return XY;
	}
	/*void allInfo(){
		System.out.println(x);
	}*/
	
	
	
	/**
	 * Robot will turn to the left. He will stay on the field he was standing
	 * before performance of the command. Neither will take nor put any brick.
	 */
	void Turnleft() {
		 System.out.print("Turnleft chage direction from: " + direction + "to: ");
		if (direction == 'N') {
			direction = 'W';
		}
		if (direction == 'W') {
			direction = 'S';
		}
		if (direction == 'S') {
			direction = 'E';
		}
		if (direction == 'E') {
			direction = 'N';
		}
		 System.out.println(direction);
	}

	/**
	 * Karel will put a brick on the field, on which he is standing. Neither he
	 * will move to another field nor turn to another direction.
	 */
	void Put() {
		
		  System.out.println("Before:"); System.out.println("There are: " +
		  outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" +
		  robotPozX +","+robotPozY+"). "); System.out.println("There are: " +
		  blocksOnTruck + " blocksOnTruck now.");
		 
		blocksOnTruck--;
		outer.boardOFBlocks[robotPozX][robotPozY]++;
		
		  System.out.println("Robot is Putting block on pozytion (" + robotPozX
		  +","+robotPozY+"). "); System.out.println("After:");
		  System.out.println("There are: " +
		  outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" +
		  robotPozX +","+robotPozY+"). "); System.out.println("There are: " +
		  blocksOnTruck + " blocksOnTruck now.");
		 
	}

	/**
	 * Karel will take (remove) a brick of the field he is standing on. Neither
	 * he will move to another field nor turn to another direction.
	 */
	void Take() {
		
		  System.out.println("Before:"); System.out.println("There are: " +
		  outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" +
		  robotPozX +","+robotPozY+"). "); System.out.println("There are: " +
		  blocksOnTruck + " blocksOnTruck now.");
		 
		blocksOnTruck++;
		outer.boardOFBlocks[robotPozX][robotPozY]--;
		
		 System.out.println("Robot is Putting block on pozytion (" + robotPozX
		 +","+robotPozY+"). "); System.out.println("After:");
		 System.out.println("There are: " +
		 outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" +
		 robotPozX +","+robotPozY+"). "); System.out.println("There are: " +
		 blocksOnTruck + " blocksOnTruck now.");
		
	}

	/**
	 * Karel will make a step. He will therefore move by one field in the
	 * direction he faces and he won't change it.
	 */
	void Move() {
		
		  System.out.println("Before:");
		  System.out.println("Robot is on pozytion (" + robotPozX
		  +","+robotPozY+").");
		 
		if (direction == 'N') {
			robotPozY--;
		}
		if (direction == 'W') {
			robotPozX--;
		}
		if (direction == 'S') {
			robotPozY++;
		}
		if (direction == 'E') {
			robotPozX++;
		}
		
		  System.out.println("After:");
		  System.out.println("Robot is on pozytion (" + robotPozX
		  +","+robotPozY+").");
		 
	}
	/**
	 * Condition is true if Robot faces the north (up)
	 */
	boolean isNorth() {
		if (direction == 'N') {
			return true;
		}
		return false;
	}

	/**
	 * Condition is true if Robot is standing on the field where a brick lies.
	 */
	boolean IsBrick() {
		if (outer.boardOFBlocks[robotPozX][robotPozY] > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Condition is true if Robot is standing against the wall. He is therefore
	 * in such a position and is facing in such a direction that if he made a
	 * Move, he will collide with the wall.
	 */
	boolean IsWall() {
		if (direction == 'N' && robotPozY == 0) {
			return true;
		}
		if (direction == 'W' && robotPozX == 0) {
			return true;
		}
		if (direction == 'S' && robotPozY == outer.boardSize - 1) {
			return true;
		}
		if (direction == 'E' && robotPozX == outer.boardSize - 1) {
			return true;
		}
		return false;
	}
}
