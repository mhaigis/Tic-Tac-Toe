import java.util.ArrayList;
import java.util.Arrays;


public class TestBoard {

	protected ArrayList<Character> this_board;
	protected char playerChar;
	
	public TestBoard(Board b, Player player, Player comp){
		this_board = makeboard(b,player.character, comp.character);
		
	}
	public TestBoard(TestBoard b, int add, char c){
		ArrayList<Character> board = new ArrayList<Character>();
		for(int i=0; i<b.this_board.size(); i++){
			board.add(b.this_board.get(i));
		}
		board.remove(add);
		board.add(add,c);
		this_board=board;
	}
	public TestBoard(){
		ArrayList<Character> board = new ArrayList<Character>();
		board.addAll(Arrays.asList('c','p','c','p','p','6','c','c','9'));
		this_board=board;
		
	}
	
	public int compturn(TestBoard b){
		int play = -2;
		int max = -2;
		ArrayList<Integer> opens = openspaces(b.this_board);
		ArrayList<Integer> values = new ArrayList<Integer>();
		for(int i=0; i<opens.size(); i++){
			TestBoard newboard = new TestBoard(b,opens.get(i),'c');
			values.add(newboard.minimax(newboard, 'p'));
		}
		
		for(int i=0; i<opens.size(); i++){
			if(values.get(i)>max){
				
				max = values.get(i);
				play = opens.get(i);
			}
		}
		return play;
	}
	
	public int minimax(TestBoard b, char thischar){
		if(b.gameover()=='p'){
			return -1;
		}else if(b.gameover() == 'c'){
			return 1;
		}else if(openspaces(b.this_board).size()==0){
			return 0;
		}
		if(thischar=='p'){
			int min = 2;
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int i=0; i<openspaces(b.this_board).size(); i++){
				TestBoard newboard = new TestBoard(b,openspaces(b.this_board).get(i),'p');
				values.add(newboard.minimax(newboard,'c'));
			}
			for(int i=0; i<openspaces(b.this_board).size(); i++){
				if(values.get(i)<min){
					min = values.get(i);
				}
			}
			return min;
		}else{
			int max = -2;
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int i=0; i<openspaces(b.this_board).size(); i++){
				TestBoard newboard = new TestBoard(b,openspaces(b.this_board).get(i),'c');
				values.add(newboard.minimax(newboard,'p'));
			}
			for(int i=0; i<openspaces(b.this_board).size(); i++){
				if(values.get(i)>max){
					max = values.get(i);
				}
				
			}
			return max;
		}
		
	}
	public char gameover(){
		char over = 'x';
		if(this_board.get(0)==this_board.get(1) && this_board.get(1)==this_board.get(2) && this_board.get(0)=='c'
				|| this_board.get(3)==this_board.get(4) && this_board.get(4)==this_board.get(5)&& this_board.get(5)=='c'
				|| this_board.get(6)==this_board.get(7) && this_board.get(7)==this_board.get(8)&& this_board.get(8)=='c'
				|| this_board.get(0)==this_board.get(3) && this_board.get(3)==this_board.get(6)&& this_board.get(6)=='c'
				|| this_board.get(1)==this_board.get(4) && this_board.get(4)==this_board.get(7)&& this_board.get(7)=='c'
				|| this_board.get(2)==this_board.get(5) && this_board.get(5)==this_board.get(8)&& this_board.get(8)=='c'
				|| this_board.get(0)==this_board.get(4) && this_board.get(4)==this_board.get(8)&& this_board.get(8)=='c'
				|| this_board.get(2)==this_board.get(4) && this_board.get(4)==this_board.get(6)&& this_board.get(6)=='c'){
			over = 'c';
		}else if(this_board.get(0)==this_board.get(1) && this_board.get(1)==this_board.get(2) && this_board.get(0)=='p'
				|| this_board.get(3)==this_board.get(4) && this_board.get(4)==this_board.get(5)&& this_board.get(5)=='p'
				|| this_board.get(6)==this_board.get(7) && this_board.get(7)==this_board.get(8)&& this_board.get(8)=='p'
				|| this_board.get(0)==this_board.get(3) && this_board.get(3)==this_board.get(6)&& this_board.get(6)=='p'
				|| this_board.get(1)==this_board.get(4) && this_board.get(4)==this_board.get(7)&& this_board.get(7)=='p'
				|| this_board.get(2)==this_board.get(5) && this_board.get(5)==this_board.get(8)&& this_board.get(8)=='p'
				|| this_board.get(0)==this_board.get(4) && this_board.get(4)==this_board.get(8)&& this_board.get(8)=='p'
				|| this_board.get(2)==this_board.get(4) && this_board.get(4)==this_board.get(6)&& this_board.get(6)=='p'){
			over = 'p';
		}
		return over;
	}
	public ArrayList<Integer> openspaces(ArrayList<Character> b){
		ArrayList<Integer> opens= new ArrayList<Integer>();
		for(int i=0; i<b.size(); i++){
			if(b.get(i)!='p' && b.get(i)!='c'){
				opens.add(i);
			}
		}
		return opens;
	}
	
	public ArrayList<Character> makeboard(Board b, char playerchar, char compchar){
		ArrayList<Character> newboard = new ArrayList<Character>();
		for(int i=0; i<b.board.size(); i++){
			if(b.board.get(i)== playerchar){
				newboard.add('p');
			}else if(b.board.get(i)==compchar){
				newboard.add('c');
			}else{
				newboard.add(b.board.get(i));
			}
		}
		return newboard;
	}

	




}
