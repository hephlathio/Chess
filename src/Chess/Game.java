package Chess;

public class Game {
	private Board board;
	private Player white, black;
	private Player currentPlayer;
	
	public static Game newGame() {
		Game game = new Game();
		game.initNewGame();
		return game;
	}
	
	public void initNewGame() {
		initPlayers();
		initBoard();
		currentPlayer = white;
	}
	
	public void play() {
		boolean playing = true;
		while (playing) {
			currentPlayer.move();
			//playing = Board.playing
			//Clock.hit
			currentPlayer = currentPlayer.getOpponent();
		}
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
