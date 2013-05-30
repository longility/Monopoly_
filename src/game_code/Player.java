package game_code;

public class Player {

	int myPlayerNumber;
	Space currentPosition;
	int myMoney;
	
	public Player(int playerNum, Space startSpace) {
		myPlayerNumber = playerNum;
		currentPosition = startSpace;
		myMoney = 0;
	}
	
	public void giveToMyMoney(int value) {myMoney += value;}
	
	public void takeFromMyMoney(int value) {myMoney -= value;}
	
	public int getMyMoney() {return myMoney;}
	
	public int getMyNumber() {return myPlayerNumber;}	
	
	public Space getMySpace() {return currentPosition;}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
}
