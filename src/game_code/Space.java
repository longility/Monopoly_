package game_code;

public class Space {

	int spaceNumber;		
	String characteristic;	//To be used later
	Space nextSpace;	//The piece ahead
	
	//Constructor
	public Space(int space_num) {
		spaceNumber = space_num;
		characteristic = "NULL for now";
	}
	
	public void setNextSpace(Space next) {
		nextSpace = next;
	}
	
	public int getSpaceNumber() {return spaceNumber;}		//Where am I?
		
	public Space getNextSpace() {return nextSpace;}	//What is next?
	
}
