package Chess;

public class AsciiGame extends Game{
	
	public static Player[] getDefaultPlayers(){
		return new Player[]{new CommandLinePlayer(), new CommandLinePlayer()};		
	}
	
	public void draw(){
		if (gui == null) gui = new AsciiGUI(getBoard());
		gui.draw();
	}
	
	public static void main(String[] args){
		Player testPlayer1 = new CommandLinePlayer();
		Player testPlayer2 = new CommandLinePlayer();
		Game testGame = new AsciiGame();
		testGame.newGame(testPlayer1, testPlayer2);
		testGame.play();
	}
}
