package game_code;

public class GoSpace extends EmptySpace{
	public GoSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(200);}
	
	public void interactWithPassAction(Player player) {player.changeMyMoney(200);}
}
