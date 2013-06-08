package game_code;

public interface Space {
	
	public void setNextSpace(Space nextSpace);
		
	public Space getNextSpace();
	 
	public void interactWithLandAction(Player player);
	
	public void interactWithPassAction(Player player);

}
