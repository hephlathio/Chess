package Chess;

import java.util.ArrayList;

public abstract class Piece {
	private boolean isWhite; //THAT'S RACIST!
	private Square currentSquare;
		
	public Piece(boolean isWhite, Square currentSquare) {
		this.isWhite = isWhite;
		this.currentSquare = currentSquare;
	}
	//need different logic for all pieces
	public ArrayList<Square> possibleMoves(){
		ArrayList<Square> possibleSquares = new ArrayList<Square>();
		//for all opponent pieces
		//if can take king
		//illegal move
		return possibleSquares;
	}
}
