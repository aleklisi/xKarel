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
	private IBoard tmpBoard;
	private int cuttentActionNumer = -1;
	private List<String> actionStepByStep = new ArrayList<String>();

	@Override
	public void saveCurrentBoard(IBoard board) {
		serializeBoard(Envirement.b);
		initialBoard = deserializeBoard(tmpPath);
		tmpBoard = initialBoard;
		// initialBoard.showBoard();
	}

	@Override
	public void saveAction(String actionName) {
		actionStepByStep.add(actionName);
	}

	@Override
	public IBoard actionForeward() {

		return initialBoard;
	}

	/*
	 * @Override public IBoard actionBackward() { // TODO Auto-generated method
	 * stub return null; }
	 */

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
		initialBoard = setBoard;
	}

	@Override
	public void setTmpBoarc(IBoard setBoard) {
		tmpBoard = setBoard;
	}

}
