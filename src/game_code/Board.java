package game_code;

public class Board {
	Space initialSpace;
	
	public Board() {
		initialSpace = new Space(0);
		Space currentSpace = initialSpace; 
		Space nextSpace;
		for(int i=1; i<40; i++) { 
			nextSpace = new Space(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		currentSpace.setNextSpace(initialSpace);
	}
	
	public Space getInitialSpace() { return initialSpace;}
}
