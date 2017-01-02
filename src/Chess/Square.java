package Chess;

public class Square {
	private int x, y; //Let's 1-index these fellows!
	private Piece piece; //or as function
	public Square() {
		// TODO Auto-generated constructor stub
	}
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	public Piece getPiece(){
		return piece;
	}
}