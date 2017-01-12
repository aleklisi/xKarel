import java.util.ArrayList;
import java.util.List;

public class History implements IHistory {

	private int cuttentActionNumer = -1;
	
	private List<IBoard> actionStepByStep = new ArrayList<IBoard>();

	@Override
	public void saveBoard(IBoard b) {	
		actionStepByStep.add(b);
		cuttentActionNumer++;
		for (IBoard board : actionStepByStep) {
			board.showBoard();
		}
	}

	private boolean boardAviableUp() {
		if (cuttentActionNumer + 1 >= actionStepByStep.size()) {
			return false;
		}
		return true;
	}

	private boolean boardAviableDown() {
		if (cuttentActionNumer - 1 < 0) {
			return false;
		}
		return true;
	}

	@Override
	public IBoard actionForeward() {
			System.out.println("Szo³ board");
			for (IBoard board : actionStepByStep) {
				board.showBoard();
			}
			System.out.println("End Szo³ board");
		
		if (boardAviableUp()) {
			System.out.println("boardAviableUp()" + cuttentActionNumer);
			return actionStepByStep.get(++cuttentActionNumer);
		} else {
			System.out.println("!boardAviableUp()" + cuttentActionNumer);
			return actionStepByStep.get(cuttentActionNumer);
		}
	}

	@Override
	public IBoard actionBackward() {
		if (boardAviableDown()) {
			System.out.println("boardAviableDown()" + cuttentActionNumer);
			return actionStepByStep.get(--cuttentActionNumer);
		} else {
			System.out.println("!boardAviableDown()" + cuttentActionNumer);
			return actionStepByStep.get(cuttentActionNumer);
		}
	}

	@Override
	public void clearAllPreviousActions(IBoard currentBoard) {
		actionStepByStep.clear();
		cuttentActionNumer = 0;
	}

	@Override
	public boolean IsEmpty() {
		return actionStepByStep.isEmpty();
	}

	@Override
	public void saveAction(String actionName) {
		// TODO Auto-generated method stub
		
	}

}
