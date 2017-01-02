package Chess;

public class Game {
	private Board board;
	private Player white, black;
	
	public static Game newGame() {
		Game game = new Game();
		game.initPlayers();
		game.initBoard();
		return game;
	}
	
	public static Game loadGame() {
		//TODO
		return null;
	}
	
	public void saveGame() {
		//TODO
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
		board.init();
	}
	
	public Board getBoard(){
		return board;
	}
}
