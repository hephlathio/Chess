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
		System.out.println(testSquare.getName());
		System.out.println(testSquare.look(Dir.UP, 8).getName());
		System.out.println(testSquare.look(Dir.UP, 4).getName());
		System.out.println(testSquare.seek(Dir.UP, 'P', 8));
		
	}
	
	
	public static void main(String[] args) {
		asciiGUITest();
		lookTest();
	}
}
