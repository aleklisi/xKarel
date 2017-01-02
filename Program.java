import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Program {
	String programName;
	List<Proced> programProcedures;

	Program(String progName) {
		programName = progName;
		programProcedures = getAllProceds();
	}

	List<Proced> getAllProceds() {
		List<Proced> allProceds = new ArrayList<Proced>();
		File folder = new File(programName);
		Proced corrProc;
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().endsWith(".txt")) {
					corrProc = new Proced(listOfFiles[i], this);
					allProceds.add(corrProc);
					
					Envirement.add(listOfFiles[i].getName() + " Proced added.");
				}
			}
		}
		Envirement.add(allProceds+"");
		return allProceds;
	}

	boolean contains(String shearchedProcName) {
		for (Proced p : programProcedures) {
			if (p.procedName.equals(shearchedProcName)) {
				return true;
			}
		}
		return false;
	}

	Proced getProcedByName(String shearchedProcName) {
		for (Proced p : programProcedures) {
			if (p.procedName.equals(shearchedProcName)) {
				return p;
			}
		}
		return null;
	}

	void runProg() {
		getProcedByName("main").run();
	}

	boolean compileProg() {
		Envirement.add("Program entered compileProg." + programProcedures.toArray().length);
		for (int i = 0; i < programProcedures.size(); i++) {
			if (programProcedures.get(i).compileProc() > -1) {
				Envirement.add("Problem in procedure: " + programProcedures.get(i).procedName);
			//	return false;
			}
		}
		Envirement.add("Program is compiled correctly :D");
		return true;
	}
}
