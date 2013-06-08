package game_code;

public class AbstractSpace implements Space{	
	private Space nextSpace;

	public AbstractSpace() {}
	
	@Override
	public void setNextSpace(Space nextSpace) {
		this.nextSpace = nextSpace;
	}

	@Override
	public Space getNextSpace() {
		return nextSpace;
	}

	@Override
	public void interactWithLandAction(Player player) {}

	@Override
	public void interactWithPassAction(Player player) {}

}
