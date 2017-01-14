/**
 * iterface used to save prgrams action in primitive history
 * @author Aleksander Lisiecki
 *
 */
public interface IHistory {
/**
 * sets voard as "beginning" of history board 
 * @param board - saved board
 */
	void saveCurrentBoard(IBoard board);
/**
 * ads action to action list in history - 
 * @param actionName - saved action
 */
	void saveAction(String actionName);
/**
 * returns board after each move increemts move couter
 * @return board in next step
 */
	void actionForeward();

	/* IBoard actionBackward(); */
/**
 * clears all saved history and saves currentBoard as inital
 * @param currentBoard
 */
	void clearAllPreviousActions(IBoard currentBoard);
/**
 * checks if history keeps anu actionss
 * @return true if u have any actions in history to act uppon
 */
	boolean IsEmpty();
/**
 * sets initialBoard to setBoard
 * @param setBoard
 */
	void setInitialBoarc(IBoard setBoard);
/**
 * sets tmpBaord to setBoard
 * @param setBoard
 */
	void setFinalBoarc(IBoard setBoard);
	
	void setCurrentBoard(IBoard setBoard);
	
	IBoard 	 getInitialBoard();
	/**
	 * sets tmpBaord to setBoard
	 * @param setBoard
	 */
	IBoard getFinalBoard();
		
	IBoard getCurrentBoard();
	
	
	void saveHist();
	
	void uploadHist();
	
	void restCouner();

}