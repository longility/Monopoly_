package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGameBoardWrapAround() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition(); 
		for(int i = 0; i<50; i++) {
			if(testSpace.getSpaceNumber() == 39) {
				assertTrue(testSpace.getNextSpace().getSpaceNumber() == 0);
				assertEquals(testGame.getGameBoard().getInitialSpace(), testSpace.getNextSpace());		
			}
			testSpace = testSpace.getNextSpace();
		}
	}
	
	@Test
	public void testMonopolyGameBoardHasGoSpace() {
		Space testSpace = testGame.getGameBoard().getInitialSpace();
		
		assertTrue(testSpace instanceof game_code.GoSpace);
	}
	
	@Test
	public void testMonopolyGameBoardHasLuxuryTaxSpace() {
		Space testSpace = testGame.getGameBoard().getInitialSpace();
		boolean findLuxuryTaxSpace = false;
		
		for(int i=1; i<50; i++) {
			if (testSpace instanceof game_code.LuxuryTaxSpace) findLuxuryTaxSpace = true;
			testSpace = testSpace.getNextSpace();
		}
		
		assertTrue(findLuxuryTaxSpace);
	}

}
