package Chess;

public class King extends Piece {
	public boolean hasMoved;
		public King(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			moveDirs = new Dir[] {Dir.UP, Dir.UPRIGHT, Dir.UPLEFT, Dir.DOWN, Dir.DOWNLEFT, Dir.DOWNRIGHT, Dir.LEFT, Dir.RIGHT};
			representation = 'k';
			hasMoved = false;
	}
		@Override
		public int getMoveLength(Dir d) {
			return 1;
		}
		
	public boolean canCastleShort() {
		Piece leftPiece = currentSquare.look(Dir.LEFT).getPiece();
		
		//TODO Check for check
		if(!hasMoved && (leftPiece.representation=='r' && !leftPiece.hasMoved)){
			return true;
		}
		return false;
	}
	public boolean canCastleLong() {
		Piece rightPiece = currentSquare.look(Dir.RIGHT).getPiece();
		
		//TODO Check for check
		if(!hasMoved && (rightPiece.representation=='r' && !rightPiece.hasMoved)){
			return true;
		}
		return false;
	}
}
		
	//TODO implement en-passant