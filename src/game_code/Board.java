package game_code;

public class Board {
	Space startSpace;
	
	public Board() {
		startSpace = new GoSpace();
		Space currentSpace = startSpace; 
		Space nextSpace;
		
		for(int i=1; i<40; i++) { 
			nextSpace = determineNextSpace(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		
		currentSpace.setNextSpace(startSpace);
	}
	
	private Space determineNextSpace(int spaceNumber) {
		Space nextSpace;
		
		if (spaceNumber == 10) nextSpace = new IncomeTaxSpace();
		else if (spaceNumber == 20) nextSpace = new LuxuryTaxSpace();
		else nextSpace = new Space();
		
		return nextSpace;
	}
	
	public Space getInitialSpace() {return startSpace;}
}
