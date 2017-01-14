public interface  IBoard {
/**
 * prints board in console heloful in checking proper code working used in run and compile window to show text program actions wersion 
 */
	void showBoard();
	/**
	 * adds Bloxk on (x,y) pozytion REGUIRES CHCECKING IF UYOU ARE INSIDE BOARD
	 */
	void addBlock(int x,int y);
	/**
	 * takes Bloxk from (x,y) pozytion REGUIRES CHCECKING IF UYOU ARE INSIDE BOARD
	 * @return true if there were blocks on field to be taken else returns false
	 */
	boolean takeBlock(int x, int y);
	/**
	 * recomended in use sets numberOfBlocks on (x,y) field
	 * @param x
	 * @param y
	 * @param numberOfBlocks
	 * @return true if seting ended correctly else returns false
	 */
	boolean setNumberOfBlocks(int x, int y, int numberOfBlocks);
	/**
	 * 
	 * @return return board but only number of blocks on each field
	 */
	int[][] getBoard();	
	/**
	 * @return nuber of blocks on truck
	 */
	int blocksOnTruck();
	/**
	 * 
	 * @return 2 element array : [xRobotPozition , yRobotPozition ]
	 */
	int[] getCurrentPoz();
	/**
	@return true if robot faces Wall
	*/
	boolean IsWall();
	/**
	 * moves robot one filed foreward REQUIRES CHCECKING IF ROBOT STILL WILL BE OIN BOARD
	 */
	void Move();
	/**
	 * puts Block on fild robot is standing now takes one block form robot's truck REQUIRES CHCECKING IF ROBOT HAS MANY EINOUGH BLOCKS
	 */
	void Put();
	/**
	 * takes bloks from field and adds it to robots track REQUIRES CHCECKING IF Field HAS MANY EINOUGH BLOCKS
	 */
	void Take();
	/**
	 * changes robots direction counter clock wize 
	 */
	void Turnleft();
	/**
	 * 
	 * @return true if robot faces north else false
	 */
	boolean IsNorth();
	/**
	 * 
	 * @return true if there are any blocks on field robot is standing on
	 */
	boolean IsBrick();
	/**
	 * 
	 * @return size of board to make prjekt simpler is is fixed to 10 but in later development it could be resizeable
	 */
	int boardSize();	
	/**
	 * sets robot in (x,y) pozition facing direction with numberOfBlocks on truck REQUIRES CHECKING PARAMETERS CORRECTNES
	 * @param x
	 * @param y
	 * @param numberOfBlocks
	 * @param direction
	 */
	void setRobot(int x, int y, int numberOfBlocks, char direction);
}
