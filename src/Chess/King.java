package Chess;

public class King extends Piece {
	private boolean hasMoved;
		public King(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			moveDirs = new Dir[] {Dir.UP, Dir.UPRIGHT, Dir.UPLEFT, Dir.DOWN, Dir.DOWNLEFT, Dir.DOWNRIGHT, Dir.LEFT, Dir.RIGHT};
			representation = 'k';
	}
	//TODO implement en-passant
}