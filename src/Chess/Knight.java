package Chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
		public Knight(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			representation = 'n';
	}
		
		public List<Square> getPossibleMoves(){
			List<Square> possibleMoves = new ArrayList<Square>();
			for (KnightMove kd : KnightMove.values()){
				Square candidate = getCurrentSquare().getKnightSquare(kd);
				if (candidate != null && candidate.getPiece() != null && !shareOwner(candidate.getPiece())) {
					possibleMoves.add(candidate);
				}
			}
			return possibleMoves;
		}
}