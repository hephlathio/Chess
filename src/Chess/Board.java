package Chess;

public class Board {
	public Square[][] boardSquares; //lol square brackets
	public Board() {
	}
	public void init(){
		//TODO implement board initialization
	}
	
	private void initDefaultBoard(){
		boardSquares = new Square[8][8];
		for(int y = 0; y < 8; y++){
			for(int x = 0; x < 8; x++){
				boardSquares[x][y] = new Square();
			}
		}
	}
	private void initPieces(){
		
	}
}
