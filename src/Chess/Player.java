package Chess;

import java.util.Map;

public class Player {
	private Player opponent;
	private boolean white;
	private Piece king;
	
	public void setOpponent(Player opponent){
		this.opponent = opponent; 
	}
	public Player getOpponent(){
		return opponent;
	}
	public void setKing(Piece king){
		this.king = king; 
	}
	public Square getKingPosition(){
		return king.getCurrentSquare();
	}
	
	public void setIsWhite(boolean isWhite) {
		this.white = isWhite;
	}
	
	public boolean isWhite() {
		return white;
	}
	
	public void move() {
		//wait move
		//read move
		//list next
		//calc next
	}
}
