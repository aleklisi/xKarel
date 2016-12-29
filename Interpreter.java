
public class Interpreter {
	final static String[] possibleCommends = { "Move", "Put", "Take", "Turnleft", "End", "BoardCreator"};

	static boolean chceckIfProprerCommand(String command) {
		for (String comandName : possibleCommends) {
			if (command.equals(comandName)) {
				return true;
			}
		}
		return false;
	}

	static boolean ifActionPossible(Board b, String action) {
		if(action.equals("Move")){
			return ifMovePossible(b);
		}
		if(action.equals("Put")){
			return ifPutPossible(b);
		}
		if(action.equals("Take")){
			return ifTakePossible(b);
		}
		if(action.equals("Turnleft")){
			return true;
		}
		if(action.equals("BoardCreator")){
			return true;
		}
		return false;
	}

	private static boolean ifMovePossible(Board b) {
		if (b.robot.IsWall()) {
			return false;
		}
		return true;
	}
	
	private static boolean ifPutPossible(Board b){
		if(b.robot.blockOn() > 0){
			return true;
		}
		return false;
	}
	private static boolean ifTakePossible(Board b){
		if(b.boardOFBlocks[b.robot.getCurrentPoz()[0]][b.robot.getCurrentPoz()[1]] > 0){
			return true;
		}
		return false;
	}
	
}
