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
	
	//Looks in a direction for up to length tiles and returns the first piece it sees.
	public Square look(Dir d, int length){
		if (length == 0) {return null;}
		Square neighbour = neighbours[d.ordinal()];
		if (neighbour == null) {return null;}
		if (neighbour.piece != null) {return neighbour;}
		return neighbour.look(d, length-1);
	}
	
	public String getName() {return (char)('a' + y) + "" + (x+1);}
}