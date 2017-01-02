package Chess;


public class Queen extends Piece {
	private boolean hasMoved;
	public Queen(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		representation = 'Q';
	}
	//TODO implement en-passant

}
