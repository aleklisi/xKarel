
public class Board {
	int[][] boardOFBlocks;
	Robot robot;
	int boardSize;

	/**
	 * extended constructor used when user sets its own board
	 * 
	 * @param dimentionOfBoard
	 *            - sets how long squere board side is
	 * @param rPozX
	 *            - robot's horizontal initial poztion
	 * @param rPozY
	 *            - robot's vertical initial position
	 * @param blocksOnTruck
	 *            - how many blocks are initaily in robot's container
	 * @param roboFaceDirection
	 *            initial direction where robot faces
	 */
	Board(int dimentionOfBoard, int rPozX, int rPozY, int blocksOnTruck, char roboFaceDirection) {
		if (dimentionOfBoard > 0) {
			boardSize = dimentionOfBoard;
			boardOFBlocks = new int[dimentionOfBoard][dimentionOfBoard];
			for (int i = 0; i < dimentionOfBoard; i++) {
				for (int j = 0; j < dimentionOfBoard; j++) {
					boardOFBlocks[i][j] = 0; // put 0 to make shure there is
												// nothig else there, habbit
												// fotm C++
				}
			}
		} else {
			throw new RuntimeException("You can't make bord that has dimention <= 0 .");
		}
		if (rPozX >= 0 && rPozX < dimentionOfBoard && rPozY >= 0 && rPozY < dimentionOfBoard) {
			robot = new Robot(rPozX, rPozY, this);
		} else {
			throw new RuntimeException("You can't place robot out of board.");
		}
	}

	/**
	 * default constructor for impatient creates 10 by 10 board and places robot
	 * on field (5,5) facing north
	 */
	Board() {
		this(10, 6, 4, 1, 'N');
	}

	void addBlock(int x, int y) {
		boardOFBlocks[x][y]++;
	}

	boolean takeBlock(int x, int y) {
		if (boardOFBlocks[x][y] > 0) {
			boardOFBlocks[x][y]--;
			return true;
		}
		return false;
	}

	void showBoard() {
		for (int i = 0; i < boardSize; i++) {
			Envirement.add("\n");
			for (int j = 0; j < boardSize; j++) {
				Envirement.add(boardOFBlocks[j][i] + "	");
			}
		}
		Envirement.add(" ");
		robot.allInfo();
		Envirement.add(" ");

	}
}
