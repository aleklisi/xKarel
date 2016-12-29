
public class Board {
	int[][] boardOFBlocks;
	Robot robot;
	int boardSize;

	/**
	 *            Constructor that creates board
	 *            places robot on it: 
	 * @param dimentionOfBoard
	 */
	public Board(int dimentionOfBoard, int rPozX, int rPozY, int blocksOnTruck, char roboFaceDirection) {
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
	 * default constructor for impatient creates 10 by 10 board and places robot on field (5,5) facing north
	 */
	public Board() {
		this(10,5,5,1,'N');
	}

	
}
