package Chess;

import java.util.ArrayList;

public class Pawn extends Piece {
	private boolean hasMoved;

		public Pawn(Player owner, Square currentSquare) {
			super(owner, currentSquare);
			moveDirs = new Dir[] {Dir.UP.toLocal(this), Dir.UPLEFT.toLocal(this), Dir.UPRIGHT.toLocal(this)};
			representation = 'p';
			hasMoved = false;
	}
		
		public Dir[] getDirs(){
			ArrayList<Dir> dirList = new ArrayList<Dir>();
			dirList.add(moveDirs[0]);
			Square upleftSquare = this.currentSquare.getNeighbour(moveDirs[1]);
			Square uprightSquare = this.currentSquare.getNeighbour(moveDirs[2]);
			Piece upleftPiece = (upleftSquare == null) ? null:upleftSquare.getPiece();
			Piece uprightPiece = (uprightSquare == null) ? null:uprightSquare.getPiece();
			if (upleftPiece != null && upleftPiece.owner != this.owner) dirList.add(moveDirs[1]);
			if (uprightPiece != null && uprightPiece.owner != this.owner) dirList.add(moveDirs[2]);
			Dir[] dirArray = new Dir[dirList.size()];
			dirList.toArray(dirArray);
			return dirArray;
		}
		@Override
		public int getMoveLength(Dir d){
			if (hasMoved == false && d == moveDirs[0]) return 2;
			return 1;
		}
	
	//TODO implement en-passant
}
