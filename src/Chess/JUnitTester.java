package Chess;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTester {
	
//	private void lookTest() {
//		Game testGame = Game.newGame();
//		Square testSquare = testGame.getBoard().boardSquares[1][1];
//		//Assert.assertEquals(testSquare, )
//		System.out.println(testSquare);
//		System.out.println(testSquare.look(Dir.UP, 8));
//		System.out.println(testSquare.look(Dir.UP, 4));
//		System.out.println(testSquare.seek(Dir.UP, 'P', 8));	
//	}
//	
	@Test
	public void lookSeekTest() {
		Game testGame = Game.newGame();
		Square testSquare = testGame.getBoard().boardSquares[1][1];
		//Assert.assertEquals(testSquare, )
		assertEquals(testSquare.toString(), "b2");
		assertEquals(testSquare.look(Dir.UP, 8).toString(), "b7");
		assertEquals(testSquare.look(Dir.UP, 4).toString(), "b6");
		assertEquals(testSquare.seek(Dir.UP, 'P', 8), true);
	}
	@Test
	public void dirTest() {
		Game testGame = Game.newGame();
		Piece testPiece = testGame.getBoard().boardSquares[0][0].getPiece();
		Piece testPiece2 = testGame.getBoard().boardSquares[0][3].getPiece();
		Piece testPiece3 = testGame.getBoard().boardSquares[1][0].getPiece();
		Assert.assertNotNull(testPiece.getDirs());
		Assert.assertNotNull(testPiece2.getDirs());
		assertEquals(testPiece3.getDirs()[0],Dir.UP);
		}
	@Test
	public void pawnTest(){
		Game testGame = Game.newGame();
		Piece testPawn = testGame.getBoard().boardSquares[1][2].getPiece();
		assertEquals(testPawn.getCurrentSquare().getPiece().getPaths().size(), 2);
		testGame.getBoard().boardSquares[2][1].setPiece(new Pawn(testGame.getPlayers()[1], testGame.getBoard().boardSquares[2][1]));

		//Tests for pawn able to take other pieces diagonally
		assertEquals(testPawn.getCurrentSquare().getPiece().getPaths().size(), 3);
		assertEquals(testPawn.getDirs().length, 2);
		
		testGame.getBoard().boardSquares[2][3].setPiece(new Pawn(testGame.getPlayers()[0], testGame.getBoard().boardSquares[2][3]));
		assertEquals(testPawn.getCurrentSquare().getPiece().getPaths().size(), 3);
		assertEquals(testPawn.getDirs().length, 2);
		
		testGame.getBoard().boardSquares[2][2].setPiece(new Pawn(testGame.getPlayers()[0], testGame.getBoard().boardSquares[2][2]));
//		AsciiGUI ag = new AsciiGUI(testGame.getBoard());
//		System.out.println(ag.draw());

		assertEquals(testPawn.getCurrentSquare().getPiece().getPaths().size(), 1);
		assertEquals(testPawn.getDirs().length, 1);
		
	}
	
	@Test
	public void pathTest() {
		Game testGame = Game.newGame();
		testGame.getBoard().boardSquares[3][3].setPiece(new Rook(testGame.getPlayers()[0], testGame.getBoard().boardSquares[3][3]));
		
		assertEquals(testGame.getBoard().boardSquares[3][3].getPiece().getPaths().size(), 11);
	}
	@Test
	public void playerTest(){
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
