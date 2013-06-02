package game_code;

import java.util.Random;

public class Player {
	static Random randomGenerator = new Random(System.nanoTime());
	
	Space currentPosition;
	int myMoney;
	
	public Player(int playerNum, Space currentPosition) {
		this.currentPosition = currentPosition;
		myMoney = 1500;
	}

	public void changeMyMoney(int amountToChange) {myMoney += amountToChange;}
	
	public int getMyMoney() {return myMoney;}	
		
	public void takeATurn() {
		int sumOfTwoRolls = rollADie() + rollADie();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
			if(this.getCurrentPosition() instanceof GoSpace && i<sumOfTwoRolls-1) this.preformSpaceAction();
		}	
		
		this.preformSpaceAction();
	}
	
	public void preformSpaceAction() {currentPosition.interactWithPlayer(this);}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public int rollADie() {return (randomGenerator.nextInt(6) + 1);}
	
	public Space getCurrentPosition() {return currentPosition;}
}
