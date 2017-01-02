package Chess;

public class Tester {
	private static void asciiGUITest() {
		Board testBoard = new Board();
		testBoard.init();
		AsciiGUI ag = new AsciiGUI(testBoard);
		System.out.println(ag.draw());
	}
	
	public static void main(String[] args) {
		asciiGUITest();
	}
}
