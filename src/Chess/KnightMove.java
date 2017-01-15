package Chess;

public enum KnightMove { //First direction is the one that is moved twice
	UPLEFT, 
	UPRIGHT, 
	RIGHTUP, 
	RIGHTDOWN,
	DOWNRIGHT,
	DOWNLEFT,
	LEFTDOWN,
	LEFTUP;


	public int[] toCoords() {
		switch(this) {
		case UPLEFT:
			return new int[]{2,-1};
		case UPRIGHT:
			return new int[]{2,1};
		case RIGHTUP:
			return new int[]{1,2};
		case RIGHTDOWN:
			return new int[]{-1,2};
		case DOWNRIGHT:
			return new int[]{-2,1};
		case DOWNLEFT:
			return new int[]{-2,-1};
		case LEFTDOWN:
			return new int[]{-1,-2};
		case LEFTUP:
			return new int[]{1,-2};
		default:
			return null;
		}
	}
}
