package Chess;

public class Bishop extends Piece {
	public Bishop(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		moveDirs = new Dir[] {Dir.UPLEFT, Dir.DOWNLEFT, Dir.DOWNRIGHT, Dir.UPRIGHT};
		representation = 'b';
	}
	//TODO implement en-passant
}