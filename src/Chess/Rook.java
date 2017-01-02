package Chess;

public class Rook extends Piece {
	private boolean hasMoved;
	public Rook(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		representation = 'r';
	}
}


