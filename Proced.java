import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Proced {
	List<String> proced;
	String procedName;
	final Program outer;

	Proced(Program outer) {
		proced = new ArrayList<String>();
		this.outer = outer;
	}

	Proced(File procFile, Program outer) {
		proced = new ArrayList<String>();
		procedName = procFile.getName().replaceAll(".txt", "");
		readFileToProc(procFile);
		this.outer = outer;
	}

	/**
	 * read's file line by line
	 * 
	 * @param filename
	 *            - file name or location
	 * @return true if file was correctly read if there were any prblems returns
	 *         false
	 */
	boolean readFileToProc(File f) {
		String line;
		try {
			InputStream fis = new FileInputStream(f);
			InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				proced.add(line);
			}
			br.close();
		} catch (Exception e) {
			Envirement.add("File doesn't exist!\n");
			return false;
		}
		return true;
	}

	int compileProc() {
		if (proced.isEmpty()) {
			Envirement.add("Proced is Empty - has 0 code lines in it!\n");
			return 0;
		}
		int ProcedLength = proced.toArray().length;
		for (int i = 0; i < ProcedLength; i++) {
			if (isInt(proced.get(i)) || proced.get(i).equals("{") || proced.get(i).equals("}")) {
				continue;
			}
			if (Interpreter.chceckIfProprerCommand(proced.get(i))) {
				continue;
			}
			if (Interpreter.chceckIfProprerCondition(proced.get(i))) {
				if (!conditionHandler(i)) {
					Envirement.add("conditionHandler(" + i + ")\n");
					return i;
				} else {
					continue;
				}
			}
			if (Interpreter.chceckIfProprerWhileLoop(proced.get(i))) {

				int newBracket = findFittingBracket(i) - 1;
				if(newBracket == -2){
					return i;
				}
				proced.set(i, proced.get(i).replaceAll("While", "").replaceAll("\\s+", ""));
				if (!conditionHandler(i)) {
					Envirement.add("conditionHandler(" + i + ") while problem\n");
					return i;
				} else {
					Integer j = i;
					proced.set(newBracket, j.toString());
					continue;
				}
			}
			if (outer.contains(proced.get(i))) {
				continue;
			} else {
				return i;
			}
		}
		Envirement.add("Compilation Ended.\n");
		return -1;

	}

	Integer findFittingBracket(int i) {
		int bracketCounter = 1;
		int wynik = i + 2;
		int ProcedLength = proced.toArray().length;
		while (bracketCounter > 0) {
			Envirement.add(wynik +"");
			if (proced.get(wynik).equals("{") || isInt(proced.get(wynik))) {
				bracketCounter++;
			}
			if (proced.get(wynik).equals("}")) {
				bracketCounter--;
			}
			if (wynik >= ProcedLength) {
				return -1;
			}
			wynik++;
		}
		return wynik;
	}

	boolean conditionHandler(int i) {
		if (proced.get(i + 1).equals("{")) {
			if(proced.get(i+2).equals("}")){
				Envirement.add("Codition changes nothing, becouse it is empty.\n");
				return false;
			}
			if (findFittingBracket(i + 1) != -1) {
				
				proced.set(i + 1, findFittingBracket(i).toString());
				return true;
			}
		}
		return false;
	}

	void run() {
		cout();
		int ProcedLength = proced.toArray().length;
		for (int i = 0; i < ProcedLength; i++) {
			Envirement.add(i+"");
			if (proced.get(i).equals("{") || proced.get(i).equals("}")) {
				continue;
			}
			if (outer.contains(proced.get(i))) {
				outer.getProcedByName(proced.get(i)).run();
				continue;
			}
			if (Interpreter.chceckIfProprerCondition(proced.get(i))) {
				if (Envirement.ifConditionIsTrue(proced.get(i))) {
					i++;
					Envirement.add("condition on line:" + i + " is true.\n");
				} else {
					Envirement.add("condition on line:" + i + " is false.\n");
				}
				continue;
			}
			if (isInt(proced.get(i))) {
				Envirement.add("Jump form line: " + i + "to: " + proced.get(i) + "\n");
				int pomi = Integer.parseInt(proced.get(i));
				if (pomi < i) {
					i = pomi - 1;
				} else {
					i = pomi;
				}
				if (i >= ProcedLength || i < -1) {
					Envirement.add("Proced cant be executed. Brackets problem.\n");
					break;
				}
				continue;
			}
			
			if (Interpreter.ifActionPossible(Envirement.b, proced.get(i))) {
				Envirement.act(proced.get(i));
				continue;
			} else {
				Envirement.add("Proced cant be executed. Error in line: " + i + "in procedure:\n " + procedName);
				break;
			}

		}
	}

	void cout() {
		int ProcedLength = proced.toArray().length;
		for (int i = 0; i < ProcedLength; i++) {
			Envirement.add(i + "	" + proced.get(i));
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
