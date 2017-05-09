package Chess;

import java.util.Scanner;

public class CommandLinePlayer extends Player{

	@Override
	public Square[] move() {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Make a move " + (isWhite() ? "white":"black") + " player");
		
		Square[] move = null;
		
		while(move == null){
			String moveString = s.nextLine();
			String[] squares = moveString.split(" ");
			
			if (squares.length != 2 || squares[0].length() != 2 || squares[1].length() != 2) System.out.println("Please give the move on the form: square1 square2. For example e2 e4");
			else{
				move = new Square[] {game.getBoard().stringToSquare(squares[0]), game.getBoard().stringToSquare(squares[1])};		
				if (move[0] == null || move[1] == null) move = null;
			}
		}

		return move;
	}
}
