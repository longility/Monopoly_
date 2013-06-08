package game_code;

public class LuxuryTaxSpace extends Space {

	public LuxuryTaxSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(-75);}
}