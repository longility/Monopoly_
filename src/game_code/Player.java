package game_code;

import java.util.Random;

public class Player {

	int myPlayerNumber;
	Space currentPosition;
	int myMoney;
	
	public Player(int playerNum, Space startSpace) {
		myPlayerNumber = playerNum;
		currentPosition = startSpace;
		myMoney = 1500;
	}

	public void giveToMyMoney(int value) {myMoney += value;}
	
	public void takeFromMyMoney(int value) {myMoney -= value;}
	
	public int getMyMoney() {return myMoney;}
	
	public int getMyNumber() {return myPlayerNumber;}	
	
	public Space getMySpace() {return currentPosition;}
		
	public void takeATurn() {
		int sumOfTwoRolls;
		
		sumOfTwoRolls = rollADie(this.getMyNumber()) + rollADie(this.getMyNumber());

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
		}	
	}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public int rollADie(int playerNum) {
		Random generator = new Random(System.nanoTime()%(playerNum*10));
		int randomRoll = generator.nextInt(6);
		randomRoll += 1;
		return randomRoll;
	}
}
