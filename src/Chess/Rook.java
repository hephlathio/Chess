package Chess;

public class Rook extends Piece {
	private boolean hasMoved;
	public Rook(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		moveDirs = new Dir[] {Dir.UP, Dir.DOWN, Dir.LEFT, Dir.RIGHT};
		representation = 'r';
	}
}


