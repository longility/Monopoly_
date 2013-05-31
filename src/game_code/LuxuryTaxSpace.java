package game_code;

public class LuxuryTaxSpace extends Space {

	public LuxuryTaxSpace(int space_num) {
		super(space_num);
	}
	
	@Override
	public int spaceAction() { return -75;}	
}
