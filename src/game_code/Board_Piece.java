package game_code;

public class Board_Piece {

	int space_Number;		
	String characteristic;	//To be used later
	Board_Piece next_Piece;	//The piece ahead
	
	//Constructor
	public Board_Piece(int space_num) {
		space_Number = space_num;
		characteristic = "NULL for now";
	}
	
	public void set_Next_Piece(Board_Piece next) {
		next_Piece = next;
	}
	
	public int get_Space_Number() {return space_Number;}		//Where am I?
		
	public Board_Piece get_Next_Piece() {return next_Piece;}	//What is next?
	
}
