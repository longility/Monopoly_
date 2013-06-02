package game_tests;

import static org.junit.Assert.*;
import java.util.Vector;
import game_code.*;
import org.junit.Before;
import org.junit.Test;

public class SpaceTest {
	MonopolyGame testGame;
	Vector<Player> listOfPlayers;
	@Before
	public void setUp() throws Exception {
		testGame = new MonopolyGame(5,2);
		listOfPlayers = testGame.getListOfPlayers();
	}
	
	@Test
	public void testSpaceNumberOrder() {
		Space testSpace = listOfPlayers.get(0).getCurrentPosition();
		
		for (int i=0; i<50; i++) {
			if(testSpace.getSpaceNumber() == 39) assertEquals(testSpace.getSpaceNumber(), testSpace.getNextSpace().getSpaceNumber()+39);
			else assertEquals(testSpace.getSpaceNumber(), testSpace.getNextSpace().getSpaceNumber()-1);
		}
	}
	
}
