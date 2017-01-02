package Chess;

import java.util.ArrayList;

public abstract class Piece {
	protected boolean isWhite; //THAT'S RACIST!
	protected Square currentSquare;
	protected char representation;
		
	public Piece(boolean isWhite, Square currentSquare) {
		this.isWhite = isWhite;
		this.setCurrentSquare(currentSquare);
	}
	//need different logic for all pieces
	public ArrayList<Square> possibleMoves(){
		ArrayList<Square> possibleSquares = new ArrayList<Square>();
		//for all opponent pieces
		//if can take king
		//illegal move
		return possibleSquares;
	}
	
	public char getRepresentation() {
		return representation;
	}
	
	public void setRepresentation(char representation) {
		this.representation = representation;
	}
}
	public Square getCurrentSquare() {
		return currentSquare;
	}
	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}
}
