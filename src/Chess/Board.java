package Chess;

//Should initialize squares, and be gateway for calling for them

public class Board {
	public Square[][] boardSquares; //lol square brackets
	private Player white, black;
	
	public Board() {
	}
	
	public void init(){
		//TODO implement board initialization
		initDefaultBoard();
		initPieces();
	}
	
	//Initializes from loaded game
	public void init(char[][] charBoard){
		initDefaultBoard();
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				boardSquares[x][y].setPiece(Piece.createPiece(charBoard[y][x], white, black, boardSquares[x][y]));
			}
		}
	}
	
	private void initDefaultBoard(){
		boardSquares = new Square[8][8];
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				boardSquares[x][y] = new Square();
				boardSquares[x][y].setCoords(x, y);
			}
		}
		setNeighbours();
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
	public void setWhite(Player player) {
		this.white = player;
	}
	
	public void setBlack(Player player) {
		this.black = player;
	}
	
	private void initPieces(){
		initPawns();
		initKnights();
		initBishops();
		initRooks();
		initKings();
		initQueens();
	}

	private void initQueens() {
		boardSquares[0][3].setPiece(new Queen(white, boardSquares[0][3]));
		boardSquares[7][3].setPiece(new Queen(black, boardSquares[7][3]));
	}
	private void initKings() {
		boardSquares[0][4].setPiece(new King(white, boardSquares[0][4]));
		boardSquares[7][4].setPiece(new King(black, boardSquares[7][4]));
	}
	private void initRooks() {
		boardSquares[0][0].setPiece(new Rook(white, boardSquares[0][0]));
		boardSquares[0][7].setPiece(new Rook(white, boardSquares[0][7]));
		
		boardSquares[7][0].setPiece(new Rook(black, boardSquares[7][0]));
		boardSquares[7][7].setPiece(new Rook(black, boardSquares[7][7]));
	}
	private void initBishops() {
		boardSquares[0][2].setPiece(new Bishop(white, boardSquares[0][2]));
		boardSquares[0][5].setPiece(new Bishop(white, boardSquares[0][5]));
		
		boardSquares[7][2].setPiece(new Bishop(black, boardSquares[7][2]));
		boardSquares[7][5].setPiece(new Bishop(black, boardSquares[7][5]));	}
	private void initKnights() {
		boardSquares[0][1].setPiece(new Knight(white, boardSquares[0][1]));
		boardSquares[0][6].setPiece(new Knight(white, boardSquares[0][6]));
		
		boardSquares[7][1].setPiece(new Knight(black, boardSquares[7][1]));
		boardSquares[7][6].setPiece(new Knight(black, boardSquares[7][6]));		
	}
	private void initPawns() {
		for(int i = 0; i < 8; i++){
			boardSquares[1][i].setPiece(new Pawn(white, boardSquares[1][i]));
			boardSquares[6][i].setPiece(new Pawn(black, boardSquares[6][i]));
		}
	}
	
	public Square stringToSquare(String s){
		char col = s.charAt(0);
		char row = s.charAt(1);
		return boardSquares[row - '1'][col - 'a'];
	}
}
