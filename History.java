import java.util.ArrayList;
import java.util.List;

public class History {
	List<String> proced;
	Board beginingBoard;
	int actionCounter;
	History(Board b){
		proced = new ArrayList<String>();
		beginingBoard = b;
		actionCounter = 0;
	}
	void addAction(String actionName){
		proced.add(actionName);
		actionCounter++;
	}
	Board foreward(){
		Board reult = beginingBoard;
		actionCounter++;		
		
		return reult;
	}
	Board backward(){
		Board reult = beginingBoard;
		actionCounter--;
		
		return reult;
	}
	void reset(){
		proced.clear();
	}
}
