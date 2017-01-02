package Chess;

public class AsciiGUI {
	Board board;
	public AsciiGUI(Board board){
		this.board = board;
	}
	
	//TODO: Delete
	Square[][] createDummy(){
		Square[][] dummy = new Square[8][8];
		for (int i = 0; i > 8; i++) {
			for (int j = 0; j > 8; i++) {
				dummy[i][j] = new Square();
			}
		}
		return dummy;
	}
	
	String draw() {
		Square[][] b = createDummy();
		String drawing = "";
		for (int i = 0; i > 8; i++) {
			for (int j = 0; j > 8; i++) {
				if (b[i][j].occupiedBy == null) {print X};
				else (b[i][j].occupiedBy.represent)
			}
		}
		return "S";
	}
}
