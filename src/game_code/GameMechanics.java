package game_code;
import java.util.Random;

public class GameMechanics {
	static Player playerOne;
	static Player playerTwo;
	static Player playerThree;
	
	public static void runTheGame(int numberOfTurns) {
		Space start = new Space(0); //Starting Space "0"
		Space previous = start; 	//For linked list purposes
		Space next;				//For linked list purposes
		for(int i=1; i<40; i++) { 			//Creates a board of length 40
			next = new Space(i);
			previous.setNextSpace(next);
			previous = next;
		}
		previous.setNextSpace(start);		//Finishes wrapping the board having Space 39 point to 0
		
		playerOne = 	new Player(1,start);
		playerTwo = 	new Player(2,start);
		playerThree = 	new Player(3,start);		
		
		for(int i=1; i<=numberOfTurns; i++) {
			System.out.println("-------------- Turn " + i + "-------------");
			takeATurn(playerOne);
			takeATurn(playerTwo);
			takeATurn(playerThree);	
		}
		
	}
	
	public static void takeATurn(Player player) {
		int rollTwoDice;
		
		System.out.println("Player " +player.getMyNumber()+ " on space " + player.currentPosition.getSpaceNumber());
		
		rollTwoDice = rollMeDie(player.getMyNumber()) + rollMeDie(player.getMyNumber());
		System.out.println("Player " +player.getMyNumber()+ " rolled a total of " + rollTwoDice);
		
		for(int i=0; i<rollTwoDice; i++) {
			player.moveOnePosition();
		}
		
		System.out.println("Player " +player.getMyNumber()+ " landed on " + player.currentPosition.getSpaceNumber() + "\n");
	} 
	
	public static int rollMeDie(int playerNum) {
		Random generator = new Random(System.nanoTime()%(playerNum*10));
		int randomRoll = generator.nextInt(6);
		randomRoll += 1;
		return randomRoll;
	}

}
