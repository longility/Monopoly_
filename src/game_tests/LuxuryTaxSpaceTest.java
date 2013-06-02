package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class LuxuryTaxSpaceTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testMonopolyGameLuxuryTaxSpace() { 
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace(0); 

		testSpace.interactWithLandAction(listOfPlayers.get(0));
		
		assertEquals(listOfPlayers.get(0).getMyMoney(), 1425);
	}
	
	@Test
	public void testMonopolyGameLuxuryTaxSpaceInBoard() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<40; i++) {
			if (testSpace.getSpaceNumber() == 20) testSpace.interactWithLandAction(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(listOfPlayers.get(0).getMyMoney(), 1425);
	}
	
	@Test
	public void testLuxuryTaxRemoveFromPlayersMoney() { 
		Space startSpace = new Space(19);
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace(20);
		startSpace.setNextSpace(testSpace);
		Player testPlayer = new Player(1, startSpace);
		
		testPlayer.moveOnePosition();
		testPlayer.preformLandAction();
		
		assertEquals(testPlayer.getMyMoney(), 1425);		
	}
}
