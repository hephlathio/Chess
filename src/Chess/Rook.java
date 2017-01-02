package Chess;

public class Rook extends Piece {
	private boolean hasMoved;
	public Rook(boolean isWhite, Square currentSquare) {
		super(isWhite, currentSquare);
		representation = 'R';
	}
	//TODO implement en-passant
}


