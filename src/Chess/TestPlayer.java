package Chess;

public class TestPlayer extends Player {
	private String[][] moves;
	private int moveNr;
	public TestPlayer(String[][] moves) {
		this.moves = moves;
		moveNr = 0;
	}
	
	@Override
	public Square[] move() {
		if (moveNr >= moves.length) return null;
		Square[] move = new Square[] {	game.getBoard().stringToSquare(moves[moveNr][0]),
										game.getBoard().stringToSquare(moves[moveNr][1])};
		moveNr++;
		return move;
	}
}
