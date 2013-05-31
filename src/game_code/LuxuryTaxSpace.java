package game_code;

public class LuxuryTaxSpace extends Space {

	public LuxuryTaxSpace(int space_num) {
		super(space_num);
	}
	
	@Override
	public void interactWithPlayer(Player player) {player.changeMyMoney(-75);}
}