package Chess;

public class Game {
	private Board board;
	private Player white, black;
	public Game() {
		initPlayers();
		initBoard();
	}

	public void initPlayers(){
		white = new Player();
		black = new Player();
		white.setIsWhite(true);
		black.setIsWhite(false);
	}

	public void initBoard(){
		board = new Board();
		board.setWhite(white);
		board.setBlack(black);
	}
}
