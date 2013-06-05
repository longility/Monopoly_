package game_code;

public class Board {
	Space startSpace;
	
	public Board() {
		startSpace = new GoSpace();
		Space currentSpace = startSpace; 
		Space nextSpace;
		for(int i=1; i<40; i++) { 
			if (i == 10) nextSpace = new IncomeTaxSpace();
			else if (i == 20) nextSpace = new LuxuryTaxSpace();
			else nextSpace = new Space();
			currentSpace.setNextSpace(nextSpace);
			currentSpace = nextSpace;
		}
		currentSpace.setNextSpace(startSpace);
	}
	
	public Space getInitialSpace() {return startSpace;}
}
