package Chess;

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
	private void initDefaultBoard(){
		boardSquares = new Square[8][8];
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				boardSquares[x][y] = new Square();
			}
		}
	}
	
	public void setWhite(Player player) {
		white = player;
		player.setIsWhite(true);
	}
	
	public void setBlack(Player player) {
		black = player;
		player.setIsWhite(false);
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
}
