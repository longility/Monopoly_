package game_tests;

import static org.junit.Assert.*;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	MonopolyGame testGame;

	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
	}
	
	@Test
	public void testMonopolyGameBoardWrapAround() { 
		Space testSpace = testGame.getListOfPlayers().get(0).getCurrentPosition(); 
		for(int i = 0; i<50; i++) {
			if(i == 39) {
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
