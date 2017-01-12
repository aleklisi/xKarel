
public interface IHistory {

	boolean saveBoard(IBoard b);
	void addAction(String actionName);
	String getAction(int actionNumber);
	String actionForeward();
	String actionBackward();
	void reset();
}
