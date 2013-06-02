package game_code;

public class GoSpace extends Space{
	public GoSpace(int spaceNumber) {
		super(spaceNumber);
	}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(200);}
	
	public void interactWithPassAction(Player player) {player.changeMyMoney(200);}
}
