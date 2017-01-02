package Chess;

public class Pawn extends Piece {
	private boolean hasMoved;
		public Pawn(boolean isWhite, Square currentSquare) {
			super(isWhite, currentSquare);
			representation = 'p';
	}
	//TODO implement en-passant
}
