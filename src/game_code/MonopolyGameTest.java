package game_code;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonopolyGameTest {
	MonopolyGame testGame;

	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
	}

	@Test
	public void testMonopolyGamePlayerNumber() { //The vector of players holds the same number of players passed to the constructor
		assertTrue(testGame.listOfPlayers.size() == 2);
	}
	
	@Test
	public void testMonopolyGameTurnNumber() { //The int for turn number holds the correct number of turns passed to the constructor
		assertTrue(testGame.numberOfTurns == 5);
	}

	@Test
	public void testMonopolyGamePlayerStartSpace() { //Each players starts on space 0
		for(int i = 0; i<testGame.listOfPlayers.size(); i++) {
			assertTrue(testGame.listOfPlayers.get(i).getMySpace().getSpaceNumber() == 0);
		}
		
	}
	
	@Test
	public void testMonopolyGameBoardSize() { //Verifies that space 39 wraps around to space 0
		Space testSpace = testGame.listOfPlayers.get(0).getMySpace(); //Gets the starting space from the first player (Position 0);
		for(int i = 0; i<50; i++) {
			if(testSpace.getSpaceNumber() == 39) {
				assertTrue(testSpace.getNextSpace().getSpaceNumber() == 0);
			}
			testSpace = testSpace.getNextSpace();
		}
	}
	
	@Test
	public void testRunTheGame() {
		testGame.runTheGame();
	}

	@Test
	public void testTakeATurn() {
		int beforePosition = testGame.listOfPlayers.get(0).getMySpace().getSpaceNumber();
		
		testGame.takeATurn(testGame.listOfPlayers.get(0));
		int afterPosition = testGame.listOfPlayers.get(0).getMySpace().getSpaceNumber();
		
		assertTrue(beforePosition != afterPosition);
	}

}
