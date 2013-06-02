package game_code;

public class Space {
	
	int spaceNumber;		
	Space nextSpace;
	
	public Space(int spaceNumber) {this.spaceNumber = spaceNumber;}
	
	public void setNextSpace(Space nextSpace) {this.nextSpace = nextSpace;}
	
	public int getSpaceNumber() {return spaceNumber;}
		
	public Space getNextSpace() {return nextSpace;}	
	 
	public void interactWithPlayer(Player player) {player.changeMyMoney(0);}
}
