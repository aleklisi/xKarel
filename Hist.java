import java.util.ArrayList;
import java.util.List;

public class Hist implements IHistory{
	
	IBoard initialBoard = new Board(); 
	int currentActionNumer = 0;
	List<String> actionStepByStep = new ArrayList<String>();
	
	@Override
	public void saveBoard(IBoard b) {
		initialBoard  = b;		
	}

	@Override
	public IBoard actionForeward() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBoard actionBackward() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearAllPreviousActions(IBoard currentBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveAction(String actionName) {
		// TODO Auto-generated method stub
		
	}

}
