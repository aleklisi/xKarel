public interface  IBoard {

	void showBoard();
	void addBlock(int x,int y);
	boolean takeBlock(int x, int y);
	int[][] getBoard();	
	int blocksOnTruck();
	int[] getCurrentPoz();
	boolean IsWall();
	void Move();
	void Put();
	void Take();
	void Turnleft();
	boolean IsNorth();
	boolean IsBrick();
	int boardSize();	
	void setRobot(int x, int y, int numberOfBlocks, char direction);
}
