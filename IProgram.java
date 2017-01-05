import java.util.List;

public interface IProgram {
	List<IProced> getAllProceds();
	boolean contains(String shearchedProcName);
	IProced getProcedByName(String shearchedProcName);
	void runProg();
	boolean compileProg();
}
