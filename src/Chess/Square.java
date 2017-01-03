package Chess;

public class Square {
	private int x, y; //0 indexed, use getName to get chess convention name.
	private Piece piece; //or as function
	private Square[] neighbours = new Square[8];
	public Square() {
	}
	public void setPiece(Piece piece){
		this.piece = piece;
	}
	public Piece getPiece(){
		return piece;
	}
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Set the neighboring square in direction d
	public void setNeighbour(Dir d, Square neighbour){
		neighbours[d.ordinal()] = neighbour;
	}
	
	//Looks in a direction for up to length tiles and returns the first piece it sees or the square it ends on.
	public Square look(Dir d, int length){
		if (length == 0) {return this;}
		Square neighbour = neighbours[d.ordinal()];
		if (neighbour == null) {return this;}
		if (neighbour.piece != null) {return neighbour;}
		return neighbour.look(d, length-1);
	}
	
	public Square look(Dir d) {return this.look(d, 8);}

	/*
	 * Looks in direction for the first piece. Returns true if this piece is represented by representation and false otherwise. 
	 * Representations:
	 * 'x' = any piece
	 * 'X' = no piece
	 * 'y' = white piece
	 * 'Y' = black piece
	 * 'p'/'P' = White/Black pawn
	 * 'r'/'R' = White/Black rook
	 * 'n'/'N' = White/Black knight
	 * 'b'/'B' = White/Black bishop
	 * 'q'/'Q' = White/Black Queen
	 * 'k'/'K' = White/Black King 
	 * 
	 * */
	public Boolean seek(Dir d, char representation, int length) {
		Square foundSquare = look(d, length);
		Piece foundPiece = foundSquare.getPiece();
		if (foundPiece == null) {return (representation == 'X');}
		if (representation == 'x') {return true;}
		if (representation == foundPiece.getRepresentation()) return true;
		if (foundPiece.owner.isWhite() && representation == 'y') return true;
		if (representation == 'Y') return true;
		return false;
		
	}
	
	public String getName() {return (char)('a' + y) + "" + (x+1);}
}