package Chess;

public class Knight extends Piece {
	private boolean hasMoved;
		public Knight(boolean isWhite, Square currentSquare) {
			super(isWhite, currentSquare);
			representation = 'k';
	}
	//TODO implement en-passant
}