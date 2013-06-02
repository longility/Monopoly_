package game_code;

public class LuxuryTaxSpace extends Space {

	public LuxuryTaxSpace(int spaceNumber) {
		super(spaceNumber);
	}
	
	@Override
	public void interactWithPlayer(Player player) {player.changeMyMoney(-75);}
}