import java.util.*;

public class Envirement {
//	static IHistory hist = new History();
	static IBoard b = new Board();
	//static IBoard historyBeginning = new
	static String consoleOutput = "";

	/*
	 * public static void main(String[] args) { String nextAction =
	 * readNewCommand(); while (!nextAction.equals("End")) { nextAction =
	 * readNewCommand().replaceAll("\\s+", "");
	 * 
	 * if (Interpreter.chceckIfProprerCommand(nextAction) ||
	 * Interpreter.chceckIfProperBoardCreatorCommand(nextAction)) { if
	 * (Interpreter.ifActionPossible(b, nextAction)) {
	 * Envirement.add("proper command was given"); Act(nextAction); } } else {
	 * /* if (Interpreter.chceckIfProprerCondition(nextAction)) {
	 * Envirement.add("proper condition was given"); }else{
	 * if(Interpreter.chceckIfProprerWhileLoop(nextAction)){
	 * Envirement.add("proper loop was given"); }else{
	 */
	// Run();

	/*
	 * Envirement.add("no correct command was given"); } } }
	 */

	static void add(String s) {
		consoleOutput += s;
	}

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
	 * reads commend form console
	 * 
	 * @return 1 line form console
	 */
	/*
	 * private static String readNewCommand() { BufferedReader br = new
	 * BufferedReader(new InputStreamReader(System.in)); String s = ""; //
	 * Envirement.add("Enter new command:"); try { s = br.readLine(); //
	 * Envirement.add(s); //
	 * Envirement.add(Interpreter.chceckIfProprerCommand(s)); } catch
	 * (IOException e) { e = new IOException("Can't read new command."); }
	 * return s; }
	 * 
	 * /** function that makes action accualy happen
	 */

	static void act(String functionName) {
		//hist.saveAction(functionName);
		//hist.saveBoard(b);
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
		 */case "ShowBoard":
			b.showBoard();
			break;
		/*
		 * case "Run": Run(); break;
		 */
		}
	}

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
	 * creates new board asks for: board dimemention than initial robots x,y,
	 * load and direction it'll face each partameter is in while loop until
	 * proper int and and possible to make configuration are given
	 * 
	 * @return new board with given configuration parameters
	 */
	/*
	 * private static IBoard createNewBoard() { int dim = 0, x = -1, y = -1,
	 * load = -1; char direc = 'N';
	 * Envirement.add("Write dimetion you would like for your board to have: \n"
	 * ); while (dim <= 0) { dim = getInt(); } Envirement.
	 * add("Write x pozytion [0;dimention-1] you would like for your robot to be:\n "
	 * ); while (x < 0 || x >= dim) { x = getInt();
	 * Envirement.add(" Try again: "); } Envirement.
	 * add("Write y pozytion [0;dimention-1] you would like for your robot to be: \n"
	 * ); while (y < 0 || y >= dim) { y = getInt();
	 * Envirement.add(" Try again: "); } Envirement.
	 * add("Write direction ['N';'W';'S';'E'] or small letter you would like for your robot to face: \n"
	 * ); String pom = ""; while (!pom.equals("N") && !pom.equals("W") &&
	 * !pom.equals("S") && !pom.equals("E")) {
	 * Envirement.add("That's not a proper char.\n Try again: \n"); pom = new
	 * Scanner(System.in).next(); pom.toUpperCase(); } direc = pom.charAt(0); b
	 * = new Board(dim, x, y, load, direc);
	 * Envirement.add("Board propreli crated:)\n"); return b;
	 * 
	 * }
	 */
	/**
	 * function that ads block to (x,y) position where x and y are read in loop
	 * until int possible configuration x and y are given (0 <= x < size of
	 * board),(0 <= y < size of board)
	 */

	/*
	 * private static void addBlock() { int x = -1, y = -1;
	 * Envirement.add("Write x pozytion of new block:\n "); while (x < 0 || x >=
	 * b.boardSize()) { x = getInt(); Envirement.add(" Try again: \n"); }
	 * Envirement.add("Write y pozytion of new block:\n "); while (y < 0 || y >=
	 * b.boardSize()) { y = getInt(); Envirement.add(" Try again: \n"); }
	 * b.addBlock(x, y); }
	 */
	/**
	 * function reads from console until correct int is given
	 * 
	 * @return int from console
	 */
	static int getInt() {
		while (true) {
			try {
				return Integer.parseInt(new Scanner(System.in).next());
			} catch (NumberFormatException e) {
				Envirement.add("That's not a proper int.\n Try again: \n");
			}
		}
	}

	/*
	 * static void Run(String prgName) { Program p = new Program(prgName); if
	 * (p.compileProg()) { Envirement.add("Compiled"); p.runProg(); }
	 * 
	 * }
	 */

	/*
	 * static void Run() { File f; String progName; while (true) { try {
	 * progName = readNewCommand(); f = new File(progName + "/main.txt");
	 * Run(progName); } catch (Exception e) {
	 * Envirement.add("Wrong file name try again.");
	 * 
	 * }
	 * 
	 * } }
	 */

	/*
	 * static boolean Run(String procedName) {
	 * 
	 * Proced p = new Proced(); File f; try { f = new File(procedName);
	 * 
	 * } catch (Exception e) { Envirement.add("Wrong file name try again.");
	 * return false; }
	 * 
	 * if (p.readFileToProg(f)) { //Envirement.add(p.proced); if (p.compile() <
	 * 0) { p.run(); return true; } else {
	 * Envirement.add("Compilation fail on line:" + p.compile()); return false;
	 * } } else { Envirement.add("wrong file directory"); return false; } }
	 */

}
