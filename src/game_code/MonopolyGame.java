package game_code;
import java.util.Vector;

public class MonopolyGame {
	
	Vector<Player> listOfPlayers;
	int numberOfTurns;
	Board gameBoard;
	
	public MonopolyGame(int numberOfTurns, int numberOfPlayers) {
		this.numberOfTurns = numberOfTurns;		
		gameBoard = new Board();
		createPlayers(numberOfPlayers);			
	}
	
	public void createPlayers(int numberOfPlayers) {
		listOfPlayers = new Vector<Player>(numberOfPlayers);
		
		for(int i=0; i<numberOfPlayers; i++) {
			listOfPlayers.add(i, new Player(i+1,gameBoard.getInitialSpace()));
		}
	}
	
	public void runTheGame() {		
		for(int i=1; i<=numberOfTurns; i++) {
			for(int j=0; j<listOfPlayers.size(); j++) {
				listOfPlayers.get(j).takeATurn();
			}
		}	
	}
	
	public Vector<Player> getListOfPlayers() {return listOfPlayers;}
	
	public int getNumberOfTurns() {return numberOfTurns;}
	
	public Board getGameBoard() {return gameBoard;}
}
