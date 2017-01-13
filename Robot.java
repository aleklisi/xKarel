
/**
 * 
 * @author Alek Lisiecki inner class for Board but in separate file to make code
 *         cleaner
 */
class Robot{
	private int robotPozX;
	private int robotPozY;
	private int blocksOnTruck;
	private char direction;
	final Board outer;

	/**
	 * sets robot on (x,y) position facing north - used as default setting
	 * 
	 * @param x
	 *            - horizontal robots position
	 * @param y
	 *            - vertical robot position
	 * @param outer
	 *            - board robot stands and moves on
	 */
	Robot(Robot copied){
		this.robotPozX = copied.robotPozX;
		this.robotPozY = copied.robotPozY;
		this.blocksOnTruck = copied.blocksOnTruck;
		this.direction = copied.direction;
		this.outer = copied.outer;
	}
	void setX(int x){
		robotPozX = x;
	}
	void setY(int y){
		robotPozX = y;
	}
	void setBlocks(int b){
		blocksOnTruck = b;
	}
	void setDirection(char d){
		direction = d;
	}
	Robot(int x, int y, Board outer) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("x and y must be positive.");
		}
		robotPozX = x;
		robotPozY = y;
		blocksOnTruck = 10;
		direction = 'N';
		this.outer = outer;
	}

	/**
	 * extended constructor used when user wants to make make his or her own
	 * board
	 * 
	 * @param x
	 *            - horizontal robots position
	 * @param y
	 *            - vertical robots position
	 * @param numberOfBlocks
	 *            - how many blocks user wants to have on truck initialy
	 * @param outer
	 *            - board robot stands and on
	 * @param startDirection
	 *            which direction is set initialy
	 */

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

	/**
	 * @return how many blocks are in robots container
	 */
	public int blockOnTruck() {
		return blocksOnTruck;
	}

	/**
	 * 
	 * @return returns 2 elements int array where [horizontal,vertical] robot's
	 *         position
	 */
	public int[] getCurrentPoz() {
		int[] XY = new int[2];
		XY[0] = robotPozX;
		XY[1] = robotPozY;
		return XY;
	}

	void allInfo() {
		Envirement.add("Robot is on: (" + robotPozX + ";" + robotPozY + ")position, has: \n");
		Envirement.add(blocksOnTruck + " blocks on truck and there are: " + outer.boardOFBlocks[robotPozX][robotPozY]
				+ "blocks where it is.\n");
	}

	/**
	 * Robot will turn to the left. He will stay on the field he was standing
	 * before performance of the command. Neither will take nor put any brick.
	 */
	public void Turnleft() {
		Envirement.add("Turnleft chage direction from: " + direction + " to: ");
		switch (direction) {
		case 'N':
			direction = 'W';
			break;

		case 'W':
			direction = 'S';
			break;
		case 'S':
			direction = 'E';
			break;
		case 'E':
			direction = 'N';
		}
		Envirement.add(direction+"\n");
	}

	/**
	 * Karel will put a brick on the field, on which he is standing. Neither he
	 * will move to another field nor turn to another direction.
	 */
	public void Put() {

		Envirement.add("Before:\n");
		Envirement.add("There are: " + outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" + robotPozX
				+ "," + robotPozY + "). \n");
		Envirement.add("There are: " + blocksOnTruck + " blocksOnTruck now.\n");

		blocksOnTruck--;
		outer.boardOFBlocks[robotPozX][robotPozY]++;

		Envirement.add("Robot is Putting block on pozytion (" + robotPozX + "," + robotPozY + "). \n");
		Envirement.add("After:\n");
		Envirement.add("There are: " + outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" + robotPozX
				+ "," + robotPozY + ").\n ");
		Envirement.add("There are: " + blocksOnTruck + " blocksOnTruck now.\n");

	}

	/**
	 * Karel will take (remove) a brick of the field he is standing on. Neither
	 * he will move to another field nor turn to another direction.
	 */
	public void Take() {

		Envirement.add("Before:\n");
		Envirement.add("There are: " + outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" + robotPozX
				+ "," + robotPozY + ").\n ");
		Envirement.add("There are: " + blocksOnTruck + " blocksOnTruck now.\n");

		blocksOnTruck++;
		outer.boardOFBlocks[robotPozX][robotPozY]--;

		Envirement.add("Robot is Putting block on pozytion (" + robotPozX + "," + robotPozY + ").\n ");
		Envirement.add("After:\n");
		Envirement.add("There are: " + outer.boardOFBlocks[robotPozX][robotPozY] + "blocks on field: (" + robotPozX
				+ "," + robotPozY + ").\n ");
		Envirement.add("There are: " + blocksOnTruck + " blocksOnTruck now.\n");

	}

	/**
	 * Karel will make a step. He will therefore move by one field in the
	 * direction he faces and he won't change it.
	 */
	public void Move() {

		Envirement.add("Before:\n");
		Envirement.add("Robot is on pozytion (" + robotPozX + "," + robotPozY + ").\n");

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

		Envirement.add("After:\n");
		Envirement.add("Robot is on pozytion (" + robotPozX + "," + robotPozY + ").\n");

	}

	/**
	 * Condition is true if Robot faces the north (up)
	 */
	public boolean IsNorth() {
		if (direction == 'N') {
			return true;
		}
		return false;
	}

	/**
	 * Condition is true if Robot is standing on the field where a brick lies.
	 */
	public boolean IsBrick() {
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
	public boolean IsWall() {
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
