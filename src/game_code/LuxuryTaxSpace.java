package game_code;

public class LuxuryTaxSpace extends EmptySpace {

	public LuxuryTaxSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(-75);}
}