package Chess;

//Represents spatial directions. Enumerated clockwise from up (accesses with dir.ordinal()). 
//DOWN -> UP is positive x direction and LEFT -> RIGHT is positive y direction.
public enum Dir {
	UP,
	UPRIGHT,
	RIGHT,
	DOWNRIGHT,
	DOWN,
	DOWNLEFT,
	LEFT,
	UPLEFT;
	
	//Represents the direction in coordinates. Binary coordinates used so these can be employed to indexation.
	public int[] toCoords() {
		switch(this) {
		case UP:
			return new int[]{1,0};
		case UPRIGHT:
			return new int[]{1,1};
		case RIGHT:
			return new int[]{0,1};
		case DOWNRIGHT:
			return new int[]{-1,1};
		case DOWN:
			return new int[]{-1,0};
		case DOWNLEFT:
			return new int[]{-1,-1};
		case LEFT:
			return new int[]{0,-1};
		case UPLEFT:
			return new int[]{1,-1};
		default:
			return null;
		}
	}

	public Dir toLocal(Piece piece) {
		if (!piece.owner.isWhite()) return Dir.values()[(this.ordinal() + 4) % 8];
		else return this;
	}
}
