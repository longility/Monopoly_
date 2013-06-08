package game_code;

public class EmptySpace {			
	private EmptySpace nextSpace;
	
	public EmptySpace() {}
	
	public void setNextSpace(EmptySpace nextSpace) {this.nextSpace = nextSpace;}
		
	public EmptySpace getNextSpace() {return nextSpace;}	
	 
	public void interactWithLandAction(Player player) {}
	
	public void interactWithPassAction(Player player) {}
}
