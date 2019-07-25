import java.util.Scanner;

public class Play {

	protected char PlayerString;
	protected char CompString;
	protected boolean playerturn;
	
	public Play(){
		
		boolean PlayGame=true;
		Player human = new Player("Human");
		Player comp = new Player("Computer");
		while(PlayGame){
			setUp();
			
			//set up players
			human.setchar(PlayerString);
			comp.setchar(CompString);
			
			//set up board
			Board board = new Board();
			
			if(!this.playerturn){
				TestBoard t = new TestBoard(board, human, comp);
				int go = t.compturn(t)+1;
				board.add(go, comp.character);
			}
			
			boolean GameOver = false;
			while(!GameOver){
				playermove(board);
				if(board.gameover()){
					System.out.println("*********");
					System.out.println("You win!");
					human.wins();
					GameOver=true;
					break;
				}
				TestBoard t = new TestBoard(board,human,comp);
				if(t.openspaces(t.this_board).size()==0){
					break;
				}
				int go = t.compturn(t)+1;
				board.add(go,comp.character);
				if(board.gameover()){
					System.out.println("*********");
					System.out.println("You lose :(");
					comp.wins();
					GameOver=false;
					break;
				}
				t = new TestBoard(board,human,comp);
				if(t.openspaces(t.this_board).size()==0){
					break;
				}
			}
			board.printBoard();
			System.out.println("*********");
			System.out.println("HUMAN: "+human.score+" COMPUTER: "+comp.score);
			PlayGame = playAgain();
			
		}
		
		System.out.println("Thank you for playing.");
	}
	
	public boolean playAgain(){
		Scanner sc = new Scanner(System.in);
		boolean playagain = true;
		System.out.println("Would you like to play again? 'Y' or 'N'");
		if(sc.nextLine().equals("N")){
			playagain = false;
		}
		return playagain;
	}
	
	public void setUp(){ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to go first? `Y` for Yes, `N` for No");
		boolean PlayerFirst = true;
		if(sc.nextLine().equals("N")){
			PlayerFirst = false;
		}
		System.out.println("Would you like to be `X` or `O`?");
		char playerchar = sc.next().charAt(0);
		
		this.playerturn=PlayerFirst;
		this.PlayerString = playerchar;
		if(PlayerString=='X'){
			this.CompString = 'O';
		}else{
			this.CompString='X';
		}
	}
	
	public void playermove(Board board){
		Scanner sc = new Scanner(System.in);
		board.printBoard();
		System.out.println("Where would you like to go?");
		String move = sc.nextLine();
		int intmove = Integer.parseInt(move);
		board.add(intmove, PlayerString);
	}
	
	public static void main(String [] args){
		Play play = new Play();
	}
	
}
