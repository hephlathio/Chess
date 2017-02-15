package Chess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	private Board board;
	private Player white, black;
	private Player currentPlayer;
	public static String filePath = "../Chess/games/testGame.txt";
	
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
	
	public static Game newGame(Player white, Player black) {
		Game game = new Game();
		game.initNewGame(white, black);
		return game;
	}
	
	public void initNewGame(Player white, Player black) {
		initPlayers(white, black);
		initBoard();
		currentPlayer = white;
	}
	public void initPlayers(Player white, Player black){
		this.white = white;
		this.black = black;
		white.setIsWhite(true);
		black.setIsWhite(false);
		white.setGame(this);
		black.setGame(this);
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
	
	public static Game loadGame(String filePath) {
		Game game = new Game();
		game.initNewGame();
				
		char[][] charBoard = new char[8][8];
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))){
			for(int y = 0; y < 8; y++){
				String line = br.readLine();
				for(int x = 0; x < 8; x++){
					charBoard[y][x] = line.charAt(x);
				}
			}
			game.getBoard().init(charBoard);

		//TODO Create default game if file not found
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return game;
	}
	
	public void saveGame() {
		//TODO
	}
	
	public void initPlayers(){
		white = new TestPlayer(new String[][]{{"a2", "a3"},{"b2", "c5"}});
		black = new Player();
		white.setIsWhite(true);
		black.setIsWhite(false);
		white.setGame(this);
		black.setGame(this);
	}

	public void initBoard(){
		board = new Board(); //TODO 1 line instead of 3 here
		board.setWhite(white);
		board.setBlack(black);
		board.init();
	}
	
	public Board getBoard(){
		return board;
	}
	
	public Player[] getPlayers(){
		return new Player[]{white, black};
	}
}