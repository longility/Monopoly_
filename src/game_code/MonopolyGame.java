package game_code;
import java.util.Random;
import java.util.Vector;



public class MonopolyGame {
	Vector<Player> listOfPlayers;
	int numberOfTurns;
	int numberOfPlayers;
	
	public MonopolyGame(int numOfTurns, int numOfPlayers) {
		numberOfTurns = 	numOfTurns;
		numberOfPlayers = 	numOfPlayers;
		listOfPlayers = 	new Vector<Player>(numberOfPlayers);
		
		Space start = 		new Space(0); 	//Starting Space "0"
		Space previous = 	start; 			//For linked list purposes
		Space next;							//For linked list purposes
		for(int i=1; i<40; i++) { 			//Creates a board of length 40
			next = new Space(i);
			previous.setNextSpace(next);
			previous = next;
		}
		previous.setNextSpace(start);		//Finishes wrapping the board having Space 39 point to 0
		
		for(int i=0; i<numberOfPlayers; i++) {
			listOfPlayers.add(i, new Player(i+1,start));
		}		
	}
	
	public void runTheGame() {				
		
		for(int i=1; i<=numberOfTurns; i++) {
			System.out.println("-------------- Turn " + i + "--------------");
			for(int j=0; j<listOfPlayers.size(); j++) {
				takeATurn(listOfPlayers.get(j));
			}
		}
		
	}
	
	public void takeATurn(Player player) {
		int rollTwoDice;
		
		System.out.println("Player " +player.getMyNumber()+ " on space " + player.currentPosition.getSpaceNumber());
		
		rollTwoDice = rollMeDie(player.getMyNumber()) + rollMeDie(player.getMyNumber());
		System.out.println("Player " +player.getMyNumber()+ " rolled a total of " + rollTwoDice);
		
		for(int i=0; i<rollTwoDice; i++) {
			player.moveOnePosition();
		}
		
		System.out.println("Player " +player.getMyNumber()+ " landed on " + player.currentPosition.getSpaceNumber() + "\n");
	} 
	
	public int rollMeDie(int playerNum) {
		Random generator = new Random(System.nanoTime()%(playerNum*10));
		int randomRoll = generator.nextInt(6);
		randomRoll += 1;
		return randomRoll;
	}

}
