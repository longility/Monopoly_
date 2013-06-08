package game_code;

public class LuxuryTaxSpace extends AbstractSpace {

	public LuxuryTaxSpace() {}
	
	@Override
	public void interactWithLandAction(Player player) {player.changeMyMoney(-75);}
}