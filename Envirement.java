import java.io.*;
import java.util.*;

public class Envirement {
	static Board b = new Board();

	public static void main(String[] args) {
		/*String nextAction = readNewCommand();
		while (!nextAction.equals("End")) {
			nextAction = readNewCommand();

			if (Interpreter.chceckIfProprerCommand(nextAction) || Interpreter.chceckIfProperBoardCreatorCommand(nextAction)) {
				if (Interpreter.ifActionPossible(b, nextAction)) {
					System.out.println("proper command was given");
					Act(nextAction);
				}
			} else {
				/*
				 * if (Interpreter.chceckIfProprerCondition(nextAction)) {
				 * System.out.println("proper condition was given"); }else{
				 * if(Interpreter.chceckIfProprerWhileLoop(nextAction)){
				 * System.out.println("proper loop was given"); }else{
				 */
		Run();	
		
		System.out.println("no correct command was given");
			//}
		//}
	}

	/**
	 * reads commend form console
	 * 
	 * @return 1 line form console
	 */
	private static String readNewCommand() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		// System.out.print("Enter new command:");
		try {
			s = br.readLine();
			System.out.print(s);
			// System.out.println(Interpreter.chceckIfProprerCommand(s));
		} catch (IOException e) {
			e = new IOException("Can't read new command.");
		}
		return s;
	}

	/**
	 * function that makes action accualy happen
	 */
	static void Act(String functionName) {
		switch (functionName) {
		case "Move":
			b.robot.Move();
			break;
		case "Put":
			b.robot.Put();
			break;
		case "Take":
			b.robot.Take();
			break;
		case "Turnleft":
			b.robot.Turnleft();
			break;
		case "BoardCreator":
			b = createNewBoard();
			break;
		case "AddBlock":
			addBlock();
			break;
		case "ShowBoard":
			b.showBoard();
			break;
		case "Run":
			Run();
			break;
		}
	}
	
	static boolean ifConditionIsTrue(String comandName){
		switch (comandName){
			case "IsWall":
				return b.robot.IsWall();
			case "NOT IsWall":
				return !b.robot.IsWall();
			case "IsNorth":
				return b.robot.IsNorth();
			case "NOT IsNorth":
				return !b.robot.IsNorth();
			case "IsBrick":
				return b.robot.IsBrick();
			case "NOT IsBrick":
				return b.robot.IsBrick();
				
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
	private static Board createNewBoard() {
		int dim = 0, x = -1, y = -1, load = -1;
		char direc = 'N';
		System.out.print("Write dimetion you would like for your board to have: ");
		while (dim <= 0) {
			dim = getInt();
		}
		System.out.print("Write x pozytion [0;dimention-1] you would like for your robot to be: ");
		while (x < 0 || x >= dim) {
			x = getInt();
			System.out.println(" Try again: ");
		}
		System.out.print("Write y pozytion [0;dimention-1] you would like for your robot to be: ");
		while (y < 0 || y >= dim) {
			y = getInt();
			System.out.println(" Try again: ");
		}
		System.out.print("Write direction ['N';'W';'S';'E'] or small letter you would like for your robot to face: ");
		String pom = "";
		while (!pom.equals("N") && !pom.equals("W") && !pom.equals("S") && !pom.equals("E")) {
			System.out.print("That's not a proper char.\n Try again: ");
			pom = new Scanner(System.in).next();
			pom.toUpperCase();
		}
		direc = pom.charAt(0);
		b = new Board(dim, x, y, load, direc);
		System.out.print("Board propreli crated:)");
		return b;

	}

	/**
	 * function that ads block to (x,y) position where x and y are read in loop
	 * until int possible configuration x and y are given (0 <= x < size of
	 * board),(0 <= y < size of board)
	 */
	private static void addBlock() {
		int x = -1, y = -1;
		System.out.print("Write x pozytion of new block: ");
		while (x < 0 || x >= b.boardSize) {
			x = getInt();
			System.out.println(" Try again: ");
		}
		System.out.print("Write y pozytion of new block: ");
		while (y < 0 || y >= b.boardSize) {
			y = getInt();
			System.out.println(" Try again: ");
		}
		b.addBlock(x, y);
	}

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
				System.out.print("That's not a proper int.\n Try again: ");
			}
		}
	}

	static void Run() {
		Program p = new Program();
		if (p.readFileToProg("prog1.txt")) {
			System.out.println(p.program);
			if(p.compile() < 0){
				p.run();
			}else{
				System.out.println("Compilation fail on line:" + p.compile());
			}
		} else {
			System.out.println("wrong file directory");
		}
		
	}

}
