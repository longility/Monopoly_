package game_code;

public class MonopolyApp {
	
	public static void main(String[] args) {
		int numberOfPlayers = 	3;
		int numberOfRounds = 	10;
		
		
		System.out.println("The number of turns in this game is " + numberOfRounds);
		MonopolyGame gameOne = new MonopolyGame(numberOfRounds, numberOfPlayers);
		gameOne.runTheGame();	
		
		System.out.println("End of the game");
	}
}
