package Chess;

import java.util.ArrayList;

public abstract class Piece {
	protected Player owner; //No longer racist
	protected Square currentSquare;
	protected char representation;
		
	public Piece(Player owner, Square currentSquare) {
		this.owner = owner;
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
		return owner.isWhite() ? representation:Character.toUpperCase(representation);
	}
	
	public void setRepresentation(char representation) {
		this.representation = representation;
	}
	
	public Square getCurrentSquare() {
		return currentSquare;
	}
	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}
}
