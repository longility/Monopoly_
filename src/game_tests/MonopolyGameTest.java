package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class MonopolyGameTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGameTurnNumber() {
		assertTrue(testGame.getNumberOfTurns() == 5);
	}

	@Test
	public void testTakeATurn() { 
		int beforePosition = listOfPlayers.get(0).getCurrentPosition().getSpaceNumber();
		
		listOfPlayers.get(0).takeATurn();
		int afterPosition = listOfPlayers.get(0).getCurrentPosition().getSpaceNumber();
		
		assertTrue(beforePosition != afterPosition);
	}
	
	@Test
	public void testRunTheGame() { 
		MonopolyGame gameToTestOne = new MonopolyGame(10,2);
		MonopolyGame gameToTestTwo = new MonopolyGame(10,2);
		
		gameToTestOne.runTheGame();
		gameToTestTwo.runTheGame();
		
		assertTrue(gameToTestOne.getListOfPlayers().get(0).getCurrentPosition().getSpaceNumber() != gameToTestTwo.getListOfPlayers().get(0).getCurrentPosition().getSpaceNumber() ||
				   gameToTestOne.getListOfPlayers().get(1).getCurrentPosition().getSpaceNumber() != gameToTestTwo.getListOfPlayers().get(1).getCurrentPosition().getSpaceNumber());
		
	}
}
