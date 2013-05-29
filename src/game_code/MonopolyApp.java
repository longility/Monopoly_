package game_code;

public class MonopolyApp {
	
	public static void main(String[] args) {
		int numberOfPlayers = 	3;
		int numberOfRounds = 	10;		
		
		MonopolyGame gameOne = new MonopolyGame(numberOfRounds, numberOfPlayers);
		gameOne.runTheGame();
	}
}
