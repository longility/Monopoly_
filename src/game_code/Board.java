package game_code;

public class Board {
	Space startSpace;
	
	public Board() {
		startSpace = new GoSpace(0);
		Space currentSpace = startSpace; 
		Space nextSpace;
		for(int i=1; i<40; i++) { 
			if (i == 20) nextSpace = new LuxuryTaxSpace(i);
			else nextSpace = new Space(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		currentSpace.setNextSpace(startSpace);
	}
	
	public Space getInitialSpace() {return startSpace;}
}
