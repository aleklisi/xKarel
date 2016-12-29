import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Program {
	List<String> program;

	Program() {
		program = new ArrayList<String>();

	}

	/**
	 * read's file line by line
	 * 
	 * @param filename
	 *            - file name or location
	 * @return true if file was correctly read if there were any prblems returns
	 *         false
	 */
	boolean readFileToProg(String filename) {
		File f = new File(filename);
		String line;
		try {
			InputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				program.add(line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("File doesn't exist!");
			return false;
		}
		return true;
	}

	int compile() {
		if (program.isEmpty()) {
			System.out.println("Program is Empty - has 0 code lines in it!");
			return 0;
		}
		int programLength = program.toArray().length;
		for (int i = 0; i < programLength; i++) {
			if (isInt(program.get(i)) || program.get(i).equals("{") || program.get(i).equals("}")) {
				continue;
			}
			if (Interpreter.chceckIfProprerCommand(program.get(i))) {
				continue;
			}
			if (Interpreter.chceckIfProprerCondition(program.get(i))) {
				if (!conditionHandler(i)) {
					System.out.println("conditionHandler()" + i);
					return i;
				} else {
					continue;
				}
			} else {
				return i;
			}
		}
		return -1;
	}

	Integer findFittingBracket(int i) {
		int bracketCounter = 1;
		int wynik = i + 2;
		int programLength = program.toArray().length;
		while (bracketCounter > 0) {
			if (program.get(wynik).equals("{")) {
				bracketCounter++;
			}
			if (program.get(wynik).equals("}")) {
				bracketCounter--;
			}
			if (wynik >= programLength) {
				return -1;
			}
			wynik++;
		}
		return --wynik;
	}

	boolean conditionHandler(int i) {
		if (program.get(i + 1).equals("{")) {
			if (findFittingBracket(i + 1) != -1) {
				program.set(i + 1, findFittingBracket(i).toString());
				return true;
			}
		}
		return false;
	}

	void run() {
		cout();
		int programLength = program.toArray().length;
		for (int i = 0; i < programLength; i++) {

			if (program.get(i).equals("{") || program.get(i).equals("}")) {
				continue;
			}
			if (Interpreter.chceckIfProprerCondition(program.get(i))) {
				if (!Envirement.ifConditionIsTrue(program.get(i))) {
					i++;
				}
				continue;
			}
			if (isInt(program.get(i))) {
				i = Integer.parseInt(program.get(i));
				System.out.println(i);
				if (i >= programLength || i < 0) {
					System.out.println("program cant be executed. Brackets problem.");
					break;
				}
				continue;
			}
			if (Interpreter.ifActionPossible(Envirement.b, program.get(i))) {
				Envirement.Act(program.get(i));
				continue;
			} else {
				System.out.println("program cant be executed. Error in line: " + i);
				break;
			}

		}
	}

	void cout() {
		int programLength = program.toArray().length;
		for (int i = 0; i < programLength; i++) {
			System.out.println(i + "	" + program.get(i));
		}
	}

	public static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

}
