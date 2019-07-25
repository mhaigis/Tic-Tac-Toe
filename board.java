import java.util.ArrayList;
import java.util.Arrays;


public class Board {

	public ArrayList<Character> board;
	
	
	public Board(){
		this.board = new ArrayList<Character>();
		board.addAll(Arrays.asList('1','2','3','4','5','6','7','8','9'));
	}
	
	//character who played last wins, this just tells if the game is over
	public boolean gameover(){
		boolean over = false;
		if(board.get(0)==board.get(1) && board.get(1)==board.get(2)
				|| board.get(3)==board.get(4) && board.get(4)==board.get(5)
				|| board.get(6)==board.get(7) && board.get(7)==board.get(8)
				|| board.get(0)==board.get(3) && board.get(3)==board.get(6)
				|| board.get(1)==board.get(4) && board.get(4)==board.get(7)
				|| board.get(2)==board.get(5) && board.get(5)==board.get(8)
				|| board.get(0)==board.get(4) && board.get(4)==board.get(8)
				|| board.get(2)==board.get(4) && board.get(4)==board.get(6)){
			over = true;
		}
		return over;
	}
	
	//puts a character in the desired index
	public void add(int i, char character){
		i = i-1;
		board.remove(i);
		board.add(i, character);
	}
	
	public void printBoard(){
		System.out.println(board.get(0)+" "+board.get(1)+" "+board.get(2));
		System.out.println(board.get(3)+" "+board.get(4)+" "+board.get(5));
		System.out.println(board.get(6)+" "+board.get(7)+" "+board.get(8));
	}
	
	public static void main(String [] args){

	}
}
