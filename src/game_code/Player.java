package game_code;

import java.util.Random;

public class Player {
	static Random randomGenerator = new Random(System.nanoTime());
	
	Space currentPosition;
	int myMoney;
	
	public Player(int playerNum, Space startSpace) {
		currentPosition = startSpace;
		myMoney = 1500;
	}

	public void changeMyMoney(int value) {myMoney += value;}
	
	public int getMyMoney() {return myMoney;}	
		
	public void takeATurn() {
		int sumOfTwoRolls;
		
		sumOfTwoRolls = rollADie() + rollADie();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
		}	
		
		this.preformSpaceAction();
	}
	
	public void preformSpaceAction() {
		int returnFromSpaceAction = currentPosition.spaceAction();
		
		this.changeMyMoney(returnFromSpaceAction);
	}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public int rollADie() {
		int randomRoll = randomGenerator.nextInt(6);
		randomRoll += 1;
		return randomRoll;
	}
}
