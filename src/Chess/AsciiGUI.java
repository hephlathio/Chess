package Chess;

public class AsciiGUI {
	Board board;
	public AsciiGUI(Board board){
		this.board = board;
	}
	
	String draw() {
		Square[][] b = board.boardSquares;
		StringBuilder drawing = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (b[i][j].getPiece() == null) {drawing.append("X");}
				else {drawing.append(b[i][j].getPiece().getRepresentation());}
			}
			drawing.append("\n");
		}
		return drawing.toString();
	}
}
