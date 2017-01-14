import java.util.List;
/**
 * used as one program cosists of @see IProced 
 * 
 *  @author Aleksander Lisiecki
 *
 */
public interface IProgram {
	/**
	 * 
	 * @return list of procedures it contains
	 */
	List<IProced> getAllProceds();
	/**
	 * 
	 * @param shearchedProcName
	 * @return true if procedure wirh shearchedProcName as name exists else returns false
	 */
	boolean contains(String shearchedProcName);
	/**
	 * 
	 * @param shearchedProcName
	 * @return procedure with shearchedProcName as name
	 */
	IProced getProcedByName(String shearchedProcName);
	/**
	 * runs this program until gets line cant handle with then stops and brakes
	 * always begins with main prcedure
	 */
	void runProg();
	/**
	 * compiles program serches for error in its all procedures step by step
	 * @return true if ALL procedures were compiled correctly else flase
	 */
	boolean compileProg();
}
