
public class Player {

	protected String name;
	protected char character;
	protected int score;
	
	public Player(String name){
		this.name=name;
		this.score=0;
	}
	
	public void setchar(char character){
		this.character=character;
	}
	
	public void wins(){
		this.score++;
	}
}
