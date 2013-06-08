package game_code;

public class Board {
	private EmptySpace startSpace;
	
	public Board() {
		startSpace = new GoSpace();
		EmptySpace currentSpace = startSpace; 
		EmptySpace nextSpace;
		
		for(int i=1; i<40; i++) { 
			nextSpace = determineNextSpace(i);
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		
		currentSpace.setNextSpace(startSpace);
	}
	
	private EmptySpace determineNextSpace(int spaceNumber) {
		EmptySpace nextSpace;
		
		if (spaceNumber == 10) nextSpace = new IncomeTaxSpace();
		else if (spaceNumber == 20) nextSpace = new LuxuryTaxSpace();
		else nextSpace = new EmptySpace();
		
		return nextSpace;
	}
	
	public EmptySpace getInitialSpace() {return startSpace;}
}
