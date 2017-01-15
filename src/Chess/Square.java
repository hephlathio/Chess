package Chess;

import java.util.ArrayList;
import java.util.List;

public class Square {
	private int x, y; //0 indexed, use getName to get chess convention name.
	private Piece piece; //or as function
	private Square[] neighbours = new Square[8];
	private Square[] knightSquares = new Square[8];
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
	
	public Square getNeighbour(Dir d){
		return neighbours[d.ordinal()];
	}
	
	public void setKnightSquare(KnightMove km, Square knightNeighbour){
		knightSquares[km.ordinal()] = knightNeighbour;
	}
	
	public Square getKnightSquare(KnightMove km){
		return knightSquares[km.ordinal()];
	}
	
	
	//Think about where its called from
	public List<Square> getPaths(){
		List<Square> possibleFields = new ArrayList<Square>();
		//if pawn: Do special
		for (Dir d: this.piece.getDirs()){
			int moveLength = this.piece.getMoveLength(d);
			List<Square> dPath = getPath(d, moveLength);
			dPath.remove(0);
			Piece foundPiece = dPath.get(dPath.size() - 1).getPiece();
			if (foundPiece != null && foundPiece.getOwner() == this.getPiece().getOwner()) dPath.remove(dPath.size() - 1);
			possibleFields.addAll(dPath);
		}
		return possibleFields;
	}
	
	public List<Square> getPath(Dir d) {return getPath(d, 8);}
	
	public List<Square> getPath(Dir d, int length){
		List<Square> currentPath = new ArrayList<Square>();
		Square neighbour = neighbours[d.ordinal()];
		currentPath.add(this);
		if (length != 0 && neighbour != null) {
			if (neighbour.piece != null) currentPath.add(neighbour);
			else currentPath.addAll(neighbour.getPath(d, length-1));
		}
		return currentPath;
	}
	
	public Square look(Dir d) {return this.look(d, 8);}

	//Looks in a direction for up to length tiles and returns the first piece it sees or the square it ends on.
	public Square look(Dir d, int length){
		if (length == 0) {return this;}
		Square neighbour = neighbours[d.ordinal()];
		if (neighbour == null) {return this;}
		if (neighbour.piece != null) {return neighbour;}
		return neighbour.look(d, length-1);
	}
	
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
	public List<Square> getRelevantSquares(){
		ArrayList<Square> relevantSquares = new ArrayList<Square>(); 
		for (Dir d : Dir.values()) relevantSquares.add(look(d));
		for (KnightMove km : KnightMove.values()) if(km != null) relevantSquares.add(getKnightSquare(km));
		return relevantSquares;
	}
	
	public String toString() {return (char)('a' + y) + "" + (x+1);}
}