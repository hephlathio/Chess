package Chess;

public class Knight extends Piece {
	private boolean hasMoved;
		public Knight(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			representation = 'n';
	}
	//TODO implement en-passant
}