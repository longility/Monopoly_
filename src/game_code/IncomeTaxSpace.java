package game_code;

public class IncomeTaxSpace extends Space {
	public IncomeTaxSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {
		if(player.getMyMoney() > 2000) player.changeMyMoney(-200);
		else player.changeMyMoney(-1* (player.getMyMoney()/10));
	}
}