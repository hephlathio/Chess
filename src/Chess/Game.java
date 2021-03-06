package Chess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Game {
	private Board board;
	private Player white, black;
	private Player currentPlayer;
	public static String defaultPath = "../Chess/games/testGame.txt";
	public static String defaultSavePath = "../Chess/games/saveGame.txt";
	public AsciiGUI gui;
	
	public static Game createGame() {
		return loadGame(defaultPath);
	}
	
	public static Game loadGame(String filePath){
		Player[] wb = getDefaultPlayers();
		return loadGame(filePath, wb[0], wb[1]);
	}
	
	public static Player[] getDefaultPlayers(){
		return new Player[]{new DummyPlayer(), new DummyPlayer()};
	}


	public static Game loadGame(String filePath, Player white, Player black) {
		Game game = new Game();
		game.load(filePath, white, black);
		return game;
	}
	
	public void load(String filePath, Player white, Player black){
		initNewGame(white, black);
		
		char[][] charBoard = new char[8][8];
		
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))){
			for(int y = 7; y >= 0; y--){
				String line = br.readLine();
				for(int x = 0; x < 8; x++){
					charBoard[y][x] = line.charAt(x);
				}
			}
			getBoard().init(charBoard);

		//TODO Create default game if file not found
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
	}
	

	
	public void saveGame(){
		saveGame(defaultSavePath);
	}
	
	public void saveGame(String savePath) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(savePath)))){
			for (int y = 7; y >= 0; y--) {
				StringBuilder sb = new StringBuilder();
				for (int x = 0; x < 8; x++) {
					if (board.boardSquares[y][x].getPiece() == null) {sb.append("x");}
					else {sb.append(board.boardSquares[y][x].getPiece().getRepresentation());}
				}
				bw.write(sb.toString());
				if(y > 0) bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Used for testing with different player types
	//-----------------------------------------------------
	public static Game createGame(Player white, Player black) {
		Game game = loadGame(defaultPath, white, black);
		return game;
	}
	
	public void newGame(Player white, Player black){
		load(defaultPath, white, black);
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
		white.setOpponent(black);
		black.setOpponent(white);
	}
	//----------------------------------------------------
	public void initBoard(){
		board = new Board(white, black);
		board.init();
	}
	
	public void play() {
		boolean playing = true;
		while (playing) {
			draw();
			boolean noLegalMoveMade = true;
			while(noLegalMoveMade){
				Square[] proposedMove = currentPlayer.move();
				if (proposedMove != null) noLegalMoveMade = !board.doMove(proposedMove[0], proposedMove[1]);
				else {
					playing = false;
					noLegalMoveMade = false;
				}
			}
			//playing = Board.playing
			//Clock.hit
			currentPlayer = currentPlayer.getOpponent();
		}
	}
	
	public void draw(){}
	
	public Board getBoard(){
		return board;
	}
	
	public Player[] getPlayers(){
		return new Player[]{white, black};
	}
}