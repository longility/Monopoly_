package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class GoSpaceTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGamePlayersStartOnGoSpace() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		assertTrue(testSpace instanceof GoSpace);
	}
	
	@Test
	public void testLandOnGoSpaceGivesMoney() { 
		Board testGameBoard = new Board();
		Player testPlayer = new Player(1, testGameBoard.getInitialSpace());
		for (int i=0; i<39; i++) testPlayer.moveOnePosition();

		testPlayer.moveOnePosition();
		testPlayer.preformLandAction();
		
		assertEquals(testPlayer.getMyMoney(), 1700);		
	}
	
	@Test
	public void testPassingGoSpaceGivesMoney() { 
		Board testGameBoard = new Board();
		Player testPlayer = new Player(1, testGameBoard.getInitialSpace());
		for (int i=0; i<39; i++) testPlayer.moveOnePosition();

		testPlayer.takeATurn();
		
		assertEquals(testPlayer.getMyMoney(), 1700);		
	}
}
