

public class Monster {
	
	private String name;
	private int dir;
	private int xPos;
	private int yPos;
	private char[][] board;
	private int time = 0;
	private int timeWeak = 0;
	//private boolean isDead = false;
	private int prisonTime = 0;

	private boolean canUp, canDown, canLeft, canRight = true;
	
	/**
	 * Default constructor
	 */
	public Monster() {
		name = "Pinky";
//		isAlive = true;
//		monsterMode = false;
//		timeWeak = 0;
//		speed = 5;
//		prisonTime = 0;
		xPos = 0;
		yPos = 0;	
		
	}
	
	public Monster(String name, int x, int y, char[][] b) {
		this.name = name;
		xPos = x;
		yPos = y;
		board = b;
		
	}

	public String getName() {
		return this.name;
	}

	public int getxPos() {
		return xPos;
	}


	public int getyPos() {
		return yPos;
	}

	public void move() {
		time++;
		if(time % 5 == 0) {
			int tempX = Math.round(xPos);
			int tempY = Math.round(yPos);
			canUp = true;
			canDown = true;
			canLeft = true;
			canRight = true;
			
			if(dir == 0 ) {
				if(board[tempX+1][tempY] == '#') {
					canRight = false;
					dir = (int) Math.floor(Math.random() * 4);
				}
				else {
					xPos += 1;
				}
			}
			else if(dir == 1 ) {
				if(board[tempX-1][tempY] == '#') {
					canLeft = false;
					dir = (int) Math.floor(Math.random() * 4);
				}
				else {
					xPos -= 1;
				}
			}
			else if(dir == 2 ) {
				if(board[tempX][tempY-1] == '#') {
					canUp = false;
					dir = (int) Math.floor(Math.random() * 4);
				}
				else {
					yPos -= 1;
				}
			}
			else if(dir == 3 ) {
				if(board[tempX][tempY+1] == '#') {
					canUp = false;
					dir = (int) Math.floor(Math.random() * 4);
				}
				else {
					yPos += 1;
				}
			}
			else {
				dir = (int) Math.floor(Math.random() * 4);
			}
		}
	}

	public boolean getWeak() {
		if(timeWeak == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean isDead() {
		if(prisonTime == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	
	

}
