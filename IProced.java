import java.io.File;

public interface IProced {
	boolean readFileToProc(File f);
	int compileProc();
	void run();
	String procedName();
	

}
