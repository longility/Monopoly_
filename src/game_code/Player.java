package game_code;

public class Player {

	int my_Player_Number;
	Board_Piece current_Position;
	
	public Player(int player_Num, Board_Piece start_Piece) {
		my_Player_Number = player_Num;
		current_Position = start_Piece;
	}
	
	public int get_My_Number() {return my_Player_Number;}
	
	
	public Board_Piece get_My_Piece() {return current_Position;}
	
	public void move_One_Position() {current_Position = current_Position.get_Next_Piece();}
}
