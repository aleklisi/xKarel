import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

public class History implements IHistory {
	private IBoard innitialBoard;
	private int cuttentActionNumer = 0;
	private List<String> actionStepByStep = new ArrayList<String>();

	@Override
	public boolean saveBoard(IBoard b) {
		try {
			innitialBoard = b;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void addAction(String actionName) {
		actionStepByStep.add(actionName);
	}

	@Override
	public String getAction(int actionNumber) {
		if (actionNumber >= 0 && actionNumber < actionStepByStep.size()) {
			return actionStepByStep.get(actionNumber);
		}
		return "CANT";
	}

	@Override
	public String actionForeward() {
		return getAction(++cuttentActionNumer);
	}

	@Override
	public String actionBackward() {
		return getAction(--cuttentActionNumer);
	}

	@Override
	public void reset() {
		cuttentActionNumer = 0;
		actionStepByStep.clear();
	}
}
