package Chess;

public class Pawn extends Piece {
	private boolean hasMoved;
		public Pawn(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			representation = 'p';
	}
	//TODO implement en-passant
}
