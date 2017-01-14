package Chess;

public class Tester {
	private static void asciiGUITest() {
		Game testGame = Game.newGame();
		AsciiGUI ag = new AsciiGUI(testGame.getBoard());
		System.out.println(ag.draw());
	}
	private static void lookTest() {
		Game testGame = Game.newGame();
		Square testSquare = testGame.getBoard().boardSquares[1][1];
		System.out.println(testSquare);
		System.out.println(testSquare.look(Dir.UP, 8));
		System.out.println(testSquare.look(Dir.UP, 4));
		System.out.println(testSquare.seek(Dir.UP, 'P', 8));	
	}
	
	private static void dirTest() {
		Game testGame = Game.newGame();
		Piece testPiece = testGame.getBoard().boardSquares[0][0].getPiece();
		Piece testPiece2 = testGame.getBoard().boardSquares[0][3].getPiece();
		Piece testPiece3 = testGame.getBoard().boardSquares[1][0].getPiece();
		System.out.println(testPiece.getDirs());
		System.out.println(testPiece2.getDirs());
		System.out.println(testPiece3.getDirs());
	}
	
	private static void pathTest() {
		Game testGame = Game.newGame();
		testGame.getBoard().boardSquares[3][3].setPiece(new Rook(testGame.getPlayers()[0], testGame.getBoard().boardSquares[3][3]));
		AsciiGUI ag = new AsciiGUI(testGame.getBoard());
		System.out.println(ag.draw());
		System.out.println(testGame.getBoard().boardSquares[3][3].getPaths());
		System.out.println(testGame.getBoard().boardSquares[3][3].getPaths().size());
	}
	
	public static void main(String[] args) {
		asciiGUITest();
		lookTest();
		dirTest();
		pathTest();
	}
}
