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
	public void testMonopolyGameRailroadsExist() { 
		Space testSpace = testGame.getInitialSpace();
		
		for(int i=0; i<40; i++) {
			if (i == 5) assertTrue(testSpace instanceof game_code.RailroadSpace);
			if (i == 15) assertTrue(testSpace instanceof game_code.RailroadSpace);
			if (i == 25) assertTrue(testSpace instanceof game_code.RailroadSpace);
			if (i == 35) assertTrue(testSpace instanceof game_code.RailroadSpace);
			testSpace = testSpace.getNextSpace();
		}
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
