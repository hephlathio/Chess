package Chess;

//Simple GUI/TUI for creating an ASCII representation of the current gamestate of a chess game.
public class AsciiGUI {
	Board board;
	public AsciiGUI(Board board){
		this.board = board;
	}
	
	//Returns a string representing the chess board. White is represented by lowercase letters, black upper case.
	String draw() {
		Square[][] b = board.boardSquares;
		StringBuilder drawing = new StringBuilder();
		drawing.append("  ---------------\n");
		for (int i = 7; i >= 0; i--) {
			drawing.append(i+1 + "|");
			for (int j = 0; j < 8; j++) {
				if (b[i][j].getPiece() == null) {drawing.append("X");}
				else {drawing.append(b[i][j].getPiece().getRepresentation());}
				drawing.append((j == 7) ? "|":" ");
			}
			drawing.append("\n");
		}
		drawing.append("  ---------------\n");
		drawing.append("  ");
		for (char c = 'a'; c < 'i'; c += 1) {drawing.append(c + " ");}
		drawing.append("\n");
		return drawing.toString();
	}
}
