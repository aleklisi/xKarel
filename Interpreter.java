/**
 *  helps to set comends in program checks spelling in code an dif actions taken by robot are possible
 *  @author Aleksander Lisiecki
 *
 */
public class Interpreter {
	final static String[] possibleCommends = {"Run","Move", "Put", "Take", "Turnleft", "End","ShowBoard"};
	final static String[] possibleConditions = { "IsNorth","IsWall","IsBrick", "NOTIsNorth","NOTIsWall","NOTIsBrick" };
	final static String[] boardCreatorCommends = {"BoardCreator", "AddBlock"};
	static int commandsCounter = 0;
	final static private int maxCodeLinesNumber = 1000; 
	static boolean chceckIfProprerCommand(String command) {
		if(commandsCounter++ > maxCodeLinesNumber){
			return false;
		}
		for (String comandName : possibleCommends) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProprerCondition(String command) {
		if(commandsCounter++ > maxCodeLinesNumber){
			return false;
		}
		for (String comandName : possibleConditions) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProperBoardCreatorCommand(String command) {
		if(commandsCounter++ > maxCodeLinesNumber){
			return false;
		}
		for (String comandName : boardCreatorCommends) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProprerWhileLoop(String command) {
		if(commandsCounter++ > maxCodeLinesNumber){
			return false;
		}
		for (String comandName : possibleConditions) {
			if (command.equals("While " + comandName)) {
				return true;
			}
		}
		return false;
	}
/**
 * functoion checks if chosen action is possible 
 * eg if u stand agaist the wall u cant make move so returns false 
 * otherwise returns true 
 * @param b - our board with robot and blocks
 * @param action - comend name
 * @return returns true if given action is possible
 */
	static boolean ifActionPossible(IBoard b, String action) {
		switch(action){
		case "Move":
		return ifMovePossible(b);
		case "Put":
			return ifPutPossible(b);
		case "Take":
			return ifTakePossible(b);
		case "Turnleft":
			return true;
		case "BoardCreator":
			return true;
		case "AddBlock":
			return true;
		case "ShowBoard":
			return true;
		case "Run":
			return true;
		}
		return false;
	}
/**
 * chcecks if move is possible
 * @param b - our board with robot and blocks
 * @return true if robot can make Move otherwise returns false
 */
	private static boolean ifMovePossible(IBoard b) {
		if (b.IsWall()) {
			return false;
		}
		return true;
	}
	/**
	 * chcecks if put is possible (if has any blocks on robots container
	 * @param b - our board with robot and blocks
	 * @return true if robot can put block (has more than 0 blocks in its container) otherwise returns false
	 */
	private static boolean ifPutPossible(IBoard b){
		if(b.blocksOnTruck() > 0){
			return true;
		}
		return false;
	}
	/**
	 * chcecks if take is possible 
	 * @param b - our board with robot and blocks
	 * @return true if there is block on fiel robot is standing now
	 */
	private static boolean ifTakePossible(IBoard b){
		if(b.IsBrick()){
			return true;
		}
		return false;
	}
	
}
