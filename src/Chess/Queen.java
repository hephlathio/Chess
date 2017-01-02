package Chess;


public class Queen extends Piece {
	private boolean hasMoved;
	public Queen(boolean isWhite, Square currentSquare) {
		super(isWhite, currentSquare);
		representation = 'Q';
	}
	//TODO implement en-passant

}
