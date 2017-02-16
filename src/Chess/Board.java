package Chess;

//Should initialize squares, and be gateway for calling for them

public class Board {
	public Square[][] boardSquares; //lol square brackets
	private Player white, black;
	private King whiteKing, blackKing;
	
	
	public Board(Player white, Player black) {
		setWhite(white);
		setBlack(black);
	}
	
	public void init(){
		//TODO implement board initialization
		initEmptyBoard();
	}
	
	//Initializes from loaded game
	public void init(char[][] charBoard){
		initEmptyBoard();
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				Piece piece = Piece.createPiece(charBoard[x][y], white, black, boardSquares[x][y]);
				boardSquares[x][y].setPiece(piece);
				if(piece != null && piece.representation=='k'){
					if(piece.owner.isWhite()) 	whiteKing = (King) piece;
					else 						blackKing = (King) piece;
				}
			}
		}
	}
	
	private void initEmptyBoard(){
		boardSquares = new Square[8][8];
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				boardSquares[x][y] = new Square();
				boardSquares[x][y].setCoords(x, y);
			}
		}
		setNeighbours();
		setKnightNeighbours();
	}
	
	private void setNeighbours(){
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				for (Dir d : Dir.values()) {
					int[] delta = d.toCoords();
					if (x + delta[0] >= 0 && x + delta[0] < 8 && y + delta[1] >= 0 && y + delta[1] < 8)
						boardSquares[x][y].setNeighbour(d, boardSquares[x + delta[0]][y + delta[1]]);
				}	
			}
		}
	}
	private void setKnightNeighbours(){
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				for (KnightMove km : KnightMove.values()) {
					int[] delta = km.toCoords();
					if (x + delta[0] >= 0 && x + delta[0] < 8 && y + delta[1] >= 0 && y + delta[1] < 8)
						boardSquares[x][y].setKnightSquare(km, boardSquares[x + delta[0]][y + delta[1]]);
				}	
			}
		}
	}
	
	//TODO Move to game, get it in constructor
	private void setWhite(Player player) {
		this.white = player;
	}
	
	private void setBlack(Player player) {
		this.black = player;
	}
	
	public Square stringToSquare(String s){
		char col = s.charAt(0);
		char row = s.charAt(1);
		return boardSquares[row - '1'][col - 'a'];
	}

	public boolean doMove(Square from, Square to) {
		boolean legalMove = isLegal(from, to);
		if (legalMove) move(from, to);
		return legalMove;
	}

	private boolean isLegal(Square from, Square to) {
		Piece p = from.getPiece();
		if (p == null) return false;
		return p.isLegalMove(to);
	}
		
		//TODO: Lookup in list

	
	public void doCastleShort(Player player){
		if(player.isWhite() && whiteKing.canCastleShort()){
			move(boardSquares[0][4], boardSquares[0][6]);
			move(boardSquares[0][7], boardSquares[0][5]);
		}
		else if (blackKing.canCastleShort()){
			move(boardSquares[7][4], boardSquares[7][6]);
			move(boardSquares[7][7], boardSquares[7][5]);
		}
	}
	public void doCastleLong(Player player){
		if(player.isWhite() && whiteKing.canCastleLong()){
			move(boardSquares[0][4], boardSquares[0][2]);
			move(boardSquares[0][0], boardSquares[0][3]);
		}
		else if (blackKing.canCastleLong()){
			move(boardSquares[7][4], boardSquares[7][2]);
			move(boardSquares[7][0], boardSquares[7][3]);
		}
	}
	
	private void move(Square startSquare, Square endSquare){
		endSquare.setPiece(startSquare.getPiece());
		startSquare.setPiece(null);
	}
}
