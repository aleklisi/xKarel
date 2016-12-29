import java.io.*;
import java.util.*;

public class Envirement {
	static Board b = new Board();

	public static void main(String[] args) {
		String nextAction = readNewCommand();
		while (!nextAction.equals("End")) {
			nextAction = readNewCommand();

			if (!Interpreter.chceckIfProprerCommand(nextAction)) {
				System.out.println("Give proper command");
				continue;
			}
			if (Interpreter.ifActionPossible(b, nextAction)) {
				System.out.println("proper command was given");
				Act(nextAction);
			}
		}

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

	private static void Act(String functionName) {
		if (functionName.equals("Move")) {
			b.robot.Move();
		}
		if (functionName.equals("Put")) {
			b.robot.Put();
		}
		if (functionName.equals("Take")) {
			b.robot.Take();
		}
		if (functionName.equals("Turnleft")) {
			b.robot.Turnleft();
		}
		if (functionName.equals("BoardCreator")) {
			b = createNewBoard();
		}
	}

	private static Board createNewBoard() {
		int dim = 0, x = -1, y = -1, load = -1;
		char direc = 'N';
		System.out.print("Write dimetion you would like for your board to have: ");
		while (dim <= 0) {
			dim = getInt();
		}
		System.out.print("Write x pozytion [0;dimention-1] you would like for your robot to be: ");
		while(x < 0 || x >= dim){
			x = getInt();
			System.out.println(" Try again: ");

		}
		System.out.print("Write y pozytion [0;dimention-1] you would like for your robot to be: ");
		while(y < 0 || y >= dim){
			y = getInt();
			System.out.println(" Try again: ");
		}
		System.out.print("Write direction ['N';'W';'S';'E'] or small letter you would like for your robot to face: ");
		String pom ="";
		while(!pom.equals("N") && !pom.equals("W") && !pom.equals("S") && !pom.equals("E")){
			System.out.print("That's not a proper char.\n Try again: ");
			pom = new Scanner(System.in).next();
			pom.toUpperCase();
		}
		direc = pom.charAt(0);
		b = new Board(dim, x, y, load, direc);
		System.out.print("Board propreli crated:)");
		return b;

	}

	static int getInt() {
		while (true) {
			try {
				return Integer.parseInt(new Scanner(System.in).next());
			} catch (NumberFormatException e) {
				System.out.print("That's not a proper int.\n Try again: ");
			}
		}
	}


}
