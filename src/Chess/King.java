package Chess;

public class King extends Piece {
	private boolean hasMoved;
		public King(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			representation = 'k';
	}
	//TODO implement en-passant
}