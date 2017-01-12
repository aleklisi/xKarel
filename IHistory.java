public interface IHistory {

	void saveBoard(IBoard b);

	void saveAction(String actionName);

	IBoard actionForeward();

	IBoard actionBackward();

	void clearAllPreviousActions(IBoard currentBoard);

	boolean IsEmpty();
}