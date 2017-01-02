package Chess;

public class Bishop extends Piece {
	public Bishop(Player owner, Square currentSquare) {
		super(owner, currentSquare);
		representation = 'B';
	}
	//TODO implement en-passant
}