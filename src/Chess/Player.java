package Chess;

import java.util.Map;

public class Player {
	private Player opponent;
	private boolean isWhite;
	private Piece king;
	public Player(boolean isWhite) {
		this.isWhite = isWhite;
	}
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
}
