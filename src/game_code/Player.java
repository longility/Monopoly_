package game_code;

public class Player {

	int myPlayerNumber;
	Space currentPosition;
	
	public Player(int playerNum, Space startSpace) {
		myPlayerNumber = playerNum;
		currentPosition = startSpace;
	}
	
	public int getMyNumber() {return myPlayerNumber;}
	
	
	public Space getMySpace() {return currentPosition;}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
}
