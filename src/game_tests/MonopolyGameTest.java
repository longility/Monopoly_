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
		assertEquals(5, testGame.getNumberOfTurns());
	}

	@Test
	public void testTakeATurn() { 
		Space beforePosition = listOfPlayers.get(0).getCurrentPosition();
		
		listOfPlayers.get(0).takeATurn();
		Space afterPosition = listOfPlayers.get(0).getCurrentPosition();
		
		assertNotSame(afterPosition, beforePosition);
	}
	
	@Test
	public void testRunTheGame() { 
		MonopolyGame gameToTestOne = new MonopolyGame(10,2);
		MonopolyGame gameToTestTwo = new MonopolyGame(10,2);
		
		gameToTestOne.runTheGame();
		gameToTestTwo.runTheGame();
		
		assertTrue(gameToTestOne.getListOfPlayers().get(0).getMyMoney() != gameToTestTwo.getListOfPlayers().get(0).getMyMoney() ||
				   gameToTestOne.getListOfPlayers().get(1).getMyMoney() != gameToTestTwo.getListOfPlayers().get(1).getMyMoney());
		
	}
}
