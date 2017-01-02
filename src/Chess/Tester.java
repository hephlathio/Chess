package Chess;

public class Tester {
	private static void asciiGUITest() {
		Game testGame = Game.newGame();
		AsciiGUI ag = new AsciiGUI(testGame.getBoard());
		System.out.println(ag.draw());
	}
	
	public static void main(String[] args) {
		asciiGUITest();
	}
}
