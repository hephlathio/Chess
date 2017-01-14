package Chess;


public class Queen extends Piece {
	private boolean hasMoved;
	public Queen(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		moveDirs = new Dir[] {Dir.UP, Dir.UPRIGHT, Dir.UPLEFT, Dir.DOWN, Dir.DOWNLEFT, Dir.DOWNRIGHT, Dir.LEFT, Dir.RIGHT};
		representation = 'q';
	}
	//TODO implement en-passant

}
