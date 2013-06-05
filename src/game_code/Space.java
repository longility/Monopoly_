package game_code;

public class Space {
			
	Space nextSpace;
	
	public Space() {}
	
	public void setNextSpace(Space nextSpace) {this.nextSpace = nextSpace;}
		
	public Space getNextSpace() {return nextSpace;}	
	 
	public void interactWithLandAction(Player player) {}
	
	public void interactWithPassAction(Player player) {}
}
