package game_code;

public class GoSpace extends Space{
	public GoSpace(int spaceNumber) {
		super(spaceNumber);
	}
	
	@Override
	public void interactWithPlayer(Player player) {player.changeMyMoney(200);}
}
