import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.imageio.ImageIO;
 
public class Player implements KeyListener {
	private static int playerX;
	
	private static int playerY;
	private static int dir;
	private static int lives;
	private static final int RIGHT = 0, LEFT = 1, UP = 2, DOWN = 3, STILL = 4;
//	private Image player;
//	private static int picWidth;
//	private static int picHeight;
	private char[][] board;

	private int mouth = 10;
	
	public Player(char[][] b) {
		playerX = 1;
		playerY = 1;
		dir = STILL;
//		try {
//		    player = ImageIO.read(new File("openPac.png"));
//		    picWidth = player.getWidth(null);
//		    picHeight = player.getHeight(null);
//		} catch (IOException e) {
//			System.err.println("NO SUCH IMAGE FOUND!!!");
//		}
		lives = 3;
		board = b;
	}
	
	public int getPlayerX() {
		return playerX;
	}

	public static void setPlayerX(int playerX) {
		Player.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public static void setPlayerY(int playerY) {
		Player.playerY = playerY;
	}

	public static int getDir() {
		return dir;
	}

	public static void setDir(int dir) {
		Player.dir = dir;
	}
	
	public void dead() {
		lives--;
	}
	
	public static int getLives() {
		return lives;
	}
	
	public int getMouth() {
		return mouth;
	}

	public static void setLives(int lives) {
		Player.lives = lives;
	}

	public boolean isDead() {
		if(lives == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void move() {

		//eats the beans
		if(board[playerX][playerY] == '.') {
			board[playerX][playerY] = ' ';	
		}
		else if(board[playerX][playerY] == 'o') {
			//power bean!!!!!!!
			board[playerX][playerY] = ' ';	
		}	

		if(dir == RIGHT && board[playerX+1][playerY] == '#') {
			//do nothing
			dir = STILL;
		}
		else if(dir == LEFT && board[playerX-1][playerY] == '#') {
			//do nothing
			dir = STILL;
		}
		else if(dir == UP && board[playerX][playerY-1] == '#') {
			//do nothing
			dir = STILL;
		}
		if(dir == DOWN && board[playerX][playerY+1] == '#') {
			//do nothing
			dir = STILL;
		}
		else {
			if(dir == RIGHT) {
				playerX += 1;
			}
			else if(dir == LEFT) {
				playerX -= 1;
			}
			else if(dir == UP) {
				playerY -= 1;
			}
			else if(dir == DOWN) {
				playerY += 1;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_RIGHT) {
			dir = RIGHT;
		}
		else if(key == KeyEvent.VK_LEFT) {
			dir = LEFT;
		}
		else if(key == KeyEvent.VK_UP) {
			dir = UP;
		}
		else if(key == KeyEvent.VK_DOWN) {
			dir = DOWN;
		}
		else {
			dir = STILL;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
