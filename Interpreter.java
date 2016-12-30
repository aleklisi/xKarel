
public class Interpreter {
	final static String[] possibleCommends = {"Run","Move", "Put", "Take", "Turnleft", "End","ShowBoard"};
	final static String[] possibleConditions = { "IsNorth","IsWall","IsBrick", "NOTIsNorth","NOTIsWall","NOTIsBrick" };
	final static String[] boardCreatorCommends = {"BoardCreator", "AddBlock"};

	static boolean chceckIfProprerCommand(String command) {
		for (String comandName : possibleCommends) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProprerCondition(String command) {
		for (String comandName : possibleConditions) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProperBoardCreatorCommand(String command) {
		for (String comandName : possibleConditions) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}
	static boolean chceckIfProprerWhileLoop(String command) {
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
	static boolean ifActionPossible(Board b, String action) {
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
	private static boolean ifMovePossible(Board b) {
		if (b.robot.IsWall()) {
			return false;
		}
		return true;
	}
	/**
	 * chcecks if put is possible (if has any blocks on robots container
	 * @param b - our board with robot and blocks
	 * @return true if robot can put block (has more than 0 blocks in its container) otherwise returns false
	 */
	private static boolean ifPutPossible(Board b){
		if(b.robot.blockOn() > 0){
			return true;
		}
		return false;
	}
	/**
	 * chcecks if take is possible 
	 * @param b - our board with robot and blocks
	 * @return true if there is block on fiel robot is standing now
	 */
	private static boolean ifTakePossible(Board b){
		if(b.boardOFBlocks[b.robot.getCurrentPoz()[0]][b.robot.getCurrentPoz()[1]] > 0){
			return true;
		}
		return false;
	}
	
}
