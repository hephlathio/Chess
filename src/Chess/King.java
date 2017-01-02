package Chess;

public class King extends Piece {
	private boolean hasMoved;
		public King(boolean isWhite, Square currentSquare) {
			super(isWhite, currentSquare);
			representation = 'K';
	}
	//TODO implement en-passant
}