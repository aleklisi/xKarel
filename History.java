import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class History implements IHistory, Serializable {
	private final String tmpPath = "./tmpBoard.ser";
	private IBoard initialBoard;
	private IBoard currentBoard;
	private IBoard finalBoard;

	private int cuttentActionNumer = 0;
	private List<String> actionStepByStep = new ArrayList<String>();

	@Override
	public void saveCurrentBoard(IBoard board) {
		serializeBoard(Envirement.b);
		initialBoard = deserializeBoard(tmpPath);
		currentBoard = Envirement.cp(initialBoard);
		// initialBoard.showBoard();
	}

	@Override
	public void saveAction(String actionName) {
		actionStepByStep.add(actionName);
	}

	@Override
	public void actionForeward() {
		if (cuttentActionNumer < actionStepByStep.size()) {
			act(actionStepByStep.get(cuttentActionNumer++));
		} else {
			System.out.println("!actionForeward" + actionStepByStep.size());
		}

	}

	void act(String functionName) {
		;
		switch (functionName) {
		case "Move":
			currentBoard.Move();
			break;
		case "Put":
			currentBoard.Put();
			break;
		case "Take":
			currentBoard.Take();
			break;
		case "Turnleft":
			currentBoard.Turnleft();
			break;
		}
	}

	@Override
	public void clearAllPreviousActions(IBoard currentBoard) {
		initialBoard = currentBoard;
		actionStepByStep.clear();

	}

	@Override
	public boolean IsEmpty() {
		return actionStepByStep.isEmpty();
	}

	private void serializeBoard(IBoard board) {
		try {
			FileOutputStream fileOut = new FileOutputStream(tmpPath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(board);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + tmpPath);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private IBoard deserializeBoard(String serializedBoardPath) {
		IBoard result = null;
		try {
			FileInputStream fileIn = new FileInputStream(serializedBoardPath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			result = (IBoard) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return result;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public void setInitialBoarc(IBoard setBoard) {
		initialBoard = Envirement.cp(setBoard);
		System.out.println("initialBoard 1:");
		initialBoard.showBoard();
	}

	@Override
	public void setFinalBoarc(IBoard setBoard) {
		finalBoard = Envirement.cp(setBoard);
		System.out.println("initialBoard 2:");
		initialBoard.showBoard();
		System.out.println("finalBoard 2:");
		finalBoard.showBoard();
	}

	@Override
	public void saveHist() {
		try {
			FileOutputStream fileOut = new FileOutputStream("./hist.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in ./hist.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	@Override
	public void uploadHist() {
		try {
			FileInputStream fileIn = new FileInputStream("./hist.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Envirement.hist = (History) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
		}

	}

	@Override
	public void restCouner() {
		cuttentActionNumer = 0;

	}

	@Override
	public void setCurrentBoard(IBoard setBoard) {
		currentBoard = Envirement.cp(setBoard);
	}

	@Override
	public IBoard getInitialBoard() {
		return Envirement.cp(initialBoard);
	}

	@Override
	public IBoard getFinalBoard() {
		return Envirement.cp(finalBoard);
	}

	@Override
	public IBoard getCurrentBoard() {
		return Envirement.cp(currentBoard);
	}

}
