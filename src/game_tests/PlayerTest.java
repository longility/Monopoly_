package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
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

}
