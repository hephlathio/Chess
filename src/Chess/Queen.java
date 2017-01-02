package Chess;


public class Queen extends Piece {
	private boolean hasMoved;
	public Queen(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		representation = 'q';
	}
	//TODO implement en-passant

}
