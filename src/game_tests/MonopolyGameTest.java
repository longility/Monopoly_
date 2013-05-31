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
	public void testMonopolyGamePlayerNumber() {
		assertTrue(listOfPlayers.size() == 2);
	}
	
	@Test
	public void testMonopolyGameTurnNumber() {
		assertTrue(testGame.getNumberOfTurns() == 5);
	}
	
	@Test
	public void testMonopolyGamePlayerInitialMoney() { 
		for(int i = 0; i<listOfPlayers.size(); i++) {
			assertEquals(listOfPlayers.get(i).getMyMoney(),1500);
		}
	}
	
	@Test
	public void testMonopolyGamePlayerRemoveMoney() { 
		Player player = listOfPlayers.get(0);
		
		player.changeMyMoney(-500);
		
		assertEquals(player.getMyMoney(), 1000);	
	}
	
	@Test
	public void testMonopolyGamePlayerAddMoney() { 
		Player player = listOfPlayers.get(0);
		
		player.changeMyMoney(500);
		
		assertEquals(player.getMyMoney(), 2000);	
	}

	@Test
	public void testMonopolyGamePlayerStartSpace() { //Each players starts on space 0
		for(int i = 0; i<listOfPlayers.size(); i++) {
			assertTrue(listOfPlayers.get(i).getCurrentPosition().getSpaceNumber() == 0);
		}		
	}
	
	@Test
	public void testMonopolyGameBoardSize() { 
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
	public void testMonopolyGameLuxuryTaxSpace() { 
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace(0); 

		testSpace.interactWithPlayer(listOfPlayers.get(0));
		
		assertEquals(listOfPlayers.get(0).getMyMoney(), 1425);
	}
	
	@Test
	public void testMonopolyGameLuxuryTaxSpaceInBoard() { 
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for(int i=0; i<40; i++) {
			if (testSpace.getSpaceNumber() == 20) testSpace.interactWithPlayer(listOfPlayers.get(0));
			testSpace = testSpace.getNextSpace();
		}
		
		assertEquals(listOfPlayers.get(0).getMyMoney(), 1425);
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
	
	@Test
	public void testLuxuryTaxRemoveFromPlayersMoney() { 
		Space startSpace = new Space(19);
		LuxuryTaxSpace testSpace = new LuxuryTaxSpace(20);
		startSpace.setNextSpace(testSpace);
		Player testPlayer = new Player(1, startSpace);
		
		testPlayer.moveOnePosition();
		testPlayer.preformSpaceAction();
		
		assertEquals(testPlayer.getMyMoney(), 1425);		
	}
}
