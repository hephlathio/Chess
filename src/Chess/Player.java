package Chess;

import java.util.Map;

public class Player {
	private Player opponent;
	//Map of pieces controlled mapped to type
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public void setOpponent(Player opponent){
		this.opponent = opponent; 
	}
	public Player getOpponent(){
		return opponent;
	}
	public Square getKingPosition(){
		//TODO make function
		return new Square();
	}
}
