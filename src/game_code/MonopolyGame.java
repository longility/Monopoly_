package game_code;
import java.util.Random;
import java.util.Vector;

public class MonopolyGame {
	Vector<Player> listOfPlayers;
	int numberOfTurns;
	int numberOfPlayers;
	Space initialSpace;
	
	public MonopolyGame(int numOfTurns, int numOfPlayers) {
		numberOfTurns = 	numOfTurns;
		numberOfPlayers = 	numOfPlayers;
		listOfPlayers = 	new Vector<Player>(numberOfPlayers);
		
		createTheBoard();
		
		for(int i=0; i<numberOfPlayers; i++) {
			listOfPlayers.add(i, new Player(i+1,initialSpace));
		}		
	}
	
	public void createTheBoard() {
		initialSpace = 		new Space(0);
		Space previous = 	initialSpace; 
		Space next;
		for(int i=1; i<40; i++) { 
			next = new Space(i);
			previous.setNextSpace(next);
			previous = next;
		}
		previous.setNextSpace(initialSpace);
	}
	
	public void runTheGame() {		
		for(int i=1; i<=numberOfTurns; i++) {
			for(int j=0; j<listOfPlayers.size(); j++) {
				takeATurn(listOfPlayers.get(j));
			}
		}		
	}
	
	public void takeATurn(Player player) {
		int sumOfTwoRolls;
		
		sumOfTwoRolls = rollADie(player.getMyNumber()) + rollADie(player.getMyNumber());

		for(int i=0; i<sumOfTwoRolls; i++) {
			player.moveOnePosition();
		}		
	} 
	
	public int rollADie(int playerNum) {
		Random generator = new Random(System.nanoTime()%(playerNum*10));
		int randomRoll = generator.nextInt(6);
		randomRoll += 1;
		return randomRoll;
	}

}
