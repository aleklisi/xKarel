import java.util.*;

/**
 * class without interface to let it have all fields and fuction static it is
 * main class connecting all program together
 * 
 * @author Aleksander Lisiecki
 * 
 *
 */
public class Envirement {
	static IHistory hist = new History();
	static IBoard b = new Board();
	static String consoleOutput = "";

	/**
	 * method add s to consoleOutput
	 * 
	 * @param s
	 *            - added text
	 */
	static void add(String s) {
		consoleOutput += s;
	}

	/**
	 * method checks if given action is correct and if it si so calls act method
	 * 
	 * @see act(String functionName)
	 * @param nextAction
	 *            - action in String
	 */
	static void action(String nextAction) {
		if (Interpreter.chceckIfProprerCommand(nextAction)
				|| Interpreter.chceckIfProperBoardCreatorCommand(nextAction)) {
			if (Interpreter.ifActionPossible(b, nextAction)) {
				Envirement.add("proper command was given\n");
				act(nextAction);
			}
		} else {
			Envirement.add("not correct command was given\n");
		}
	}

	
	/**
	 * function that makes action accualy happen
	 * @param functionName - action name
	 */

	static void act(String functionName) {
		// hist.saveAction(functionName);
		// hist.saveBoard(b);
		switch (functionName) {
		case "Move":
			b.Move();
			break;
		case "Put":
			b.Put();
			break;
		case "Take":
			b.Take();
			break;
		case "Turnleft":
			b.Turnleft();
			break;
		/*
		 * case "BoardCreator": b = createNewBoard(); break; case "AddBlock":
		 * addBlock(); break;
		 */
			/*case "ShowBoard":
			b.showBoard();
			break;*/
		/*
		 * case "Run": Run(); break;
		 */
		}
	}
/**
 * gives answer if any possible in xKarel language condition is True
 * @param comandName - condition line
 * @return true if comandName condition is true  else returns false, if comadName spelling is wrongly given return False
 */
	static boolean ifConditionIsTrue(String comandName) {
		switch (comandName) {
		case "IsWall":
			return b.IsWall();
		case "NOTIsWall":
			return !b.IsWall();
		case "IsNorth":
			return b.IsNorth();
		case "NOTIsNorth":
			return !b.IsNorth();
		case "IsBrick":
			return b.IsBrick();
		case "NOTIsBrick":
			return b.IsBrick();

		}
		return false;
	}


	/**
	 * function reads from console until correct int is given
	 * 
	 * @return int from console
	 */
	/*static int getInt() {
		while (true) {
			try {
				return Integer.parseInt(new Scanner(System.in).next());
			} catch (NumberFormatException e) {
				Envirement.add("That's not a proper int.\n Try again: \n");
			}
		}
	}
*/


}
