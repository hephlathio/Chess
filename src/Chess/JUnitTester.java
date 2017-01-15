package Chess;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTester {

	@Test
	public void test() {
		playerTest();
	}
	
	private void lookTest() {
		Game testGame = Game.newGame();
		Square testSquare = testGame.getBoard().boardSquares[1][1];
		//Assert.assertEquals(testSquare, )
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
	private static void playerTest(){
		Player testPlayer1 = new TestPlayer(new String[][]{{"a2", "a3"},{"b2", "c5"}});
		Player testPlayer2 = new TestPlayer(new String[][]{{"a2", "a3"},{"b2", "c5"}});
		Game testGame = Game.newGame(testPlayer1, testPlayer2);
		Square[] testMove = testPlayer1.move();
		assertEquals(testMove[0].toString(), "a2");
		assertEquals(testMove[1].toString(), "a3");
		testMove = testPlayer1.move();
		assertEquals(testMove[0].toString(), "b2");
		assertEquals(testMove[1].toString(), "c5");
	}
	

}
