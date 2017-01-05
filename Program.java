import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Program implements IProgram {
	String programName;
	List<IProced> programProcedures;

	Program(String progName) {
		programName = progName;
		programProcedures = getAllProceds();
	}

	public List<IProced> getAllProceds() {
		List<IProced> allProceds = new ArrayList<IProced>();
		File folder = new File(programName);
		IProced corrProc;
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (listOfFiles[i].getName().endsWith(".txt")) {
					corrProc = new Proced(listOfFiles[i], this);
					allProceds.add(corrProc);
					
					Envirement.add(listOfFiles[i].getName() + " IProced added.");
				}
			}
		}
		Envirement.add(allProceds+"");
		return allProceds;
	}

	public boolean contains(String shearchedProcName) {
		for (IProced p : programProcedures) {
			if (p.procedName().equals(shearchedProcName)) {
				return true;
			}
		}
		return false;
	}

	public IProced getProcedByName(String shearchedProcName) {
		for (IProced p : programProcedures) {
			if (p.procedName().equals(shearchedProcName)) {
				return p;
			}
		}
		return null;
	}

	public void runProg() {
		getProcedByName("main").run();
	}

	public boolean compileProg() {
		Envirement.add("Program entered compileProg.\n" + programProcedures.toArray().length);
		for (int i = 0; i < programProcedures.size(); i++) {
			if (programProcedures.get(i).compileProc() > -1) {
				Envirement.add("Problem in procedure: " + programProcedures.get(i).procedName() + "\n");
			//	return false;
			}
		}
		Envirement.add("Program is compiled correctly :D\n");
		return true;
	}
}
