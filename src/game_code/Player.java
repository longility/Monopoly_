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
		
	public void takeATurn() {
		int sumOfTwoRolls = rollADie() + rollADie();

		for(int i=0; i<sumOfTwoRolls; i++) {
			this.moveOnePosition();
			if (i != sumOfTwoRolls-1) this.preformPassAction();
		}	
		
		this.preformLandAction();
	}
	
	public void changeMyMoney(int amountToChange) {myMoney += amountToChange;}
	
	public int getMyMoney() {return myMoney;}
	
	
	public void preformLandAction() {currentPosition.interactWithLandAction(this);}
	
	public void preformPassAction() {currentPosition.interactWithPassAction(this);}
	
	public void moveOnePosition() {currentPosition = currentPosition.getNextSpace();}
	
	public Space getCurrentPosition() {return currentPosition;}
	
	
	public int rollADie() {return (randomGenerator.nextInt(6) + 1);}
}
