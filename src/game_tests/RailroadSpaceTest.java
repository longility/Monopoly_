package game_tests;

import static org.junit.Assert.*;
import game_code.*;

import org.junit.Before;
import org.junit.Test;

public class RailroadSpaceTest {
	MonopolyGame testGame;
	
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(2);
	}
	
	@Test
	public void testMonopolyGameHasFourRailroads() { 
		MonopolyGame game = new MonopolyGame(2);
		Space currentSpace = game.getInitialSpace();
		int numberOfRailroads = 0;
		for(int i=0; i<Board.BOARD_SIZE; i++) {
			if (currentSpace instanceof game_code.RailroadSpace)
				numberOfRailroads++;
			currentSpace = currentSpace.getNextSpace();
		}
		
		assertEquals(4, numberOfRailroads);
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadSetsOwner() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = testGame.getListOfPlayers().get(0);
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(testPlayer, testSpace.getRailroadOwner());
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadNotEnoughMoney() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = testGame.getListOfPlayers().get(0);
		testPlayer.changeMyMoney(-1400);
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(null, testSpace.getRailroadOwner());
	}
	
	@Test
	public void testMonopolyGameBuyingRailroadChargesMoney() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player testPlayer = testGame.getListOfPlayers().get(0);
		
		testSpace.interactWithLandAction(testPlayer);
		
		assertEquals(1300, testPlayer.getMyMoney());
	}
	
	@Test
	public void testMonopolyGamePayingRentRailroad() {
		RailroadSpace testSpace = new RailroadSpace("Shortline");
		Player ownerPlayer = testGame.getListOfPlayers().get(0);
		Player rentingPlayer = testGame.getListOfPlayers().get(1);
		
		testSpace.interactWithLandAction(ownerPlayer);
		testSpace.interactWithLandAction(rentingPlayer);
		
		assertEquals(1450, rentingPlayer.getMyMoney());
	}
	
	@Test
	public void testMonopolyGameOwningMultipleRailroad() {
		RailroadSpace testRailroadOne = new RailroadSpace("Shortline");
		RailroadSpace testRailroadTwo = new RailroadSpace("B&O");
		
		Player ownerPlayer = testGame.getListOfPlayers().get(0);
		
		testRailroadOne.interactWithLandAction(ownerPlayer);
		testRailroadTwo.interactWithLandAction(ownerPlayer);
		
		assertEquals(1100, ownerPlayer.getMyMoney());
	}
	
	@Test
	public void testMonopolyGamePayingRentRailrdddoad() {
		RailroadSpace testRailroadOne = new RailroadSpace("Shortline");
		RailroadSpace testRailroadTwo = new RailroadSpace("B&O");
		
		Player ownerPlayer = testGame.getListOfPlayers().get(0);
		Player rentingPlayer = testGame.getListOfPlayers().get(1);
		
		testRailroadOne.interactWithLandAction(ownerPlayer);
		testRailroadTwo.interactWithLandAction(ownerPlayer);

		testRailroadTwo.interactWithLandAction(rentingPlayer);
		
		
		
		assertEquals(1400, rentingPlayer.getMyMoney());
		assertEquals(1200, ownerPlayer.getMyMoney());
	}
}
