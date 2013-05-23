package game_code;

public class MonopolyGame {
	public static void main(String[] args) {
		
		System.out.println("The number of turns in this game is 10");
		GameMechanics.runTheGame(10);
		System.out.println("The number of turns in this game is 5");
		GameMechanics.runTheGame(5);
		System.out.println("The number of turns in this game is 2");
		GameMechanics.runTheGame(2);
	}
}
