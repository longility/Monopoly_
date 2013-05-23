package game_code;
import java.util.Random;

public class Game_Mechanics {

	static Player player_One;
	static Player player_Two;
	static Player player_Three;
	
	public static void main(String[] args) {
		System.out.println("Start");
		
		Board_Piece start = new Board_Piece(0); //Starting Piece "0"
		Board_Piece previous = start; 	//For linked list purposes
		Board_Piece next;				//For linked list purposes
		for(int i=1; i<40; i++) { 			//Creates a board of length 40
			next = new Board_Piece(i);
			previous.set_Next_Piece(next);
			previous = next;
		}
		previous.set_Next_Piece(start);		//Finishes wrapping the board having piece 39 point to 0
		
		/*
		for(int i=0; i<45; i++) {			//Testing
			System.out.println(start.get_Space_Number());
			start = start.get_Next_Piece();
		} */
		
		player_One = 	new Player(1,start);
		player_Two = 	new Player(2,start);
		player_Three = 	new Player(3,start);		
		
		for(int i=0; i<20; i++) {
			System.out.println("-------------- Turn " + i + "-------------");
			take_A_Turn(player_One,i);
			//take_A_Turn(player_Two,i);
			//take_A_Turn(player_Three,i);	
		}
	}
	
	public static void take_A_Turn(Player player,int turn) {
		int roll_Two_Dice;
		
		System.out.println("Player " +player.get_My_Number()+ " on space " + player.current_Position.get_Space_Number());
		
		roll_Two_Dice = roll_Me_Die(player.get_My_Number(),turn) + roll_Me_Die(player.get_My_Number(),turn+1);
		System.out.println("Player " +player.get_My_Number()+ " rolled a total of " + roll_Two_Dice);
		
		for(int i=0; i<roll_Two_Dice; i++) {
			player.move_One_Position();
		}
		
		System.out.println("Player " +player.get_My_Number()+ " landed on " + player.current_Position.get_Space_Number() + "\n");
	} 
	
	public static int roll_Me_Die(int player_num, int turn_num) {
		Random generator = new Random(player_num + turn_num);
		int random_Roll = generator.nextInt(6);
		random_Roll += 1;
		return random_Roll;
	}

}
