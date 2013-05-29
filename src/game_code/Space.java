package game_code;

public class Space {

	int spaceNumber;		
	Space nextSpace;
	
	//Constructor
	public Space(int space_num) {
		spaceNumber = space_num;
	}
	
	public void setNextSpace(Space next) {
		nextSpace = next;
	}
	
	public int getSpaceNumber() {return spaceNumber;}
		
	public Space getNextSpace() {return nextSpace;}
	
}
