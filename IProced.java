import java.io.File;
/**
 * used as program components
 *  @author Aleksander Lisiecki
 *
 */
public interface IProced {
	/**
	 * reads procedure form file
	 * @param f - file procedure reads form
	 * @return true if reading procedure form file succeded esle returns false
	 */
	boolean readFileToProc(File f);
	/**
	 * compiles single procedure
	 * @return returns -1 if procedure was compiled succesfuly else returns nuber of line error has been found
	 */
	int compileProc();
	/**
	 * runs prcedure line by line
	 */
	void run();
	/**
	 * 
	 * @return name of procedure (filename procedure code is in)
	 */
	String procedName();
}
