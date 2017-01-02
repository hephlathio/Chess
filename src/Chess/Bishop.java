package Chess;

public class Bishop extends Piece {
	public Bishop(boolean isWhite, Square currentSquare) {
		super(isWhite, currentSquare);
		representation = 'B';
	}
	//TODO implement en-passant
}