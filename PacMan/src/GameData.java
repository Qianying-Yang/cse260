import java.util.ArrayList;

public class GameData {
	
	private static char[][] board = new char[35][35];
	private static String startboard = "###################################"
									 + "#o..##.........#.........##......o#"
									 + "#..............#..........#...#####"
								 	 + "#..............#####......#.......#"
									 + "#####..............#............###"
									 + "#...#.......########.....##.......#"
									 + "#...#.......#......#......####..#.#"
									 + "#...........#......#......#.....#.#"
									 + "#.................##......#.....###"
									 + "#..###............................#"
									 + "#..##............####...##........#"
									 + "#....#####.......#..............###"
									 + "#....##...........##..............#"
									 + "#.....#..............########.....#"
									 + "#######.....................#.....#"
									 + "#.............####..........#.....#"
									 + "#.............#  #....#.....#######"
									 + "#.............   #....#.......#...#"
									 + "#..#..........#  #....#.......#...#"
									 + "#..#..........####....#.......#...#"
									 + "#..#####..............#####.......#"
									 + "#......#..................#.......#"
									 + "#......#..................###.....#"
									 + "#......#....###########.....#.....#"
									 + "#......#.......#......#...........#"
									 + "##.............#......###########.#"
									 + "#....#.........#..................#"
									 + "#....#####...............####.....#"
									 + "######...................#........#"
									 + "#.................#####..#........#"
									 + "#.................#...............#"
									 + "#.......#...###########.......#...#"
									 + "#.......#...#.............#####...#"
									 + "#o....#.....#.................#..o#"
									 + "###################################";
	
	//2D array
	//private static ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
	private int time;
	private static Player p;
	private ArrayList<Monster> mons = new ArrayList<Monster>();
	
	/**
	 * Default constructor
	 */
	public GameData() {
		for(int i = 0; i<35; i++)
		{
			for(int j = 0; j<35; j++) {
				int index = i*35 + j;
				char c = startboard.charAt(index);
				board[i][j] = c;
			}
		}
		time = 0;
		p = new Player(board);
		Monster m1 = new Monster("Pinky", 13, 10, board);
		Monster m2 = new Monster("Blinky", 14, 15, board);
		Monster m3 = new Monster("Inky", 15, 20, board);
		
		mons.add(m1);
		mons.add(m2);
		mons.add(m3);
		
	}
	
	/**
	 * A method that generates random maps.
	 */
	public static void randomMap() {
		for(int i = 0; i<board.length; i++) {
			for(int j = 0; j<board[0].length; j++) {
				if(i == 0) {
					board[i][j] = '#';
				}
				else if(i == 34) {
					board[i][j] = '#';
				}
				else if(j == 34) {
					board[i][j] = '#';
				}
				else if(j == 0) {
					board[i][j] = '#';
				}
				else if(j == board.length/2 && 
						(i == board[0].length/2-2 || i == board[0].length/2+2)) {
					board[i][j] = '#';			
				}
				else if((j == board.length/2 - 1 || j == board.length/2 + 1) 
						&& i < board[0].length/2+2 && i > board[0].length/2-2) {
					board[i][j] = '#';
					
				}
				else {
					int random = (int)Math.floor((Math.random() * 100) + 1);
					//System.out.println(random);
					if(random%100 == 0) {
						board[i][j] = 'o';
					}
					else if(random%15 == 0 || random%8 == 0) {
						board[i][j] = '#';
					}			
					else {
						board[i][j] = '.';
					}
				}
			}
		}		
		
	}
	
	public boolean containBeans() {
		for(int i = 0; i<34; i++) {
			for(int j = 0; j<34; j++) {
				if(board[i][j] == '.') {
					return false;
				}
			}
		}
		return true;
	}
	
	public int getWidth() {
		return board.length;
	}

	public int getHeight() {
		return board[0].length;
	}
	
	public char getelement(int i, int j) {
		return board[i][j];
	}
	
	public int gameOver() {
		//lose
		if(p.isDead()) {
			return 1;
		}
		//one more case, when all beans are eaten.
		else if(containBeans() == true) {
			return 2;
		}
		//game is not yet over
		else {
			return 0;
		}
	}
	
	public void start() {
		time++;	
		if(time % 5 == 0) {
			p.move();
		}
		for(int i = 0; i<mons.size(); i++) {
			mons.get(i).move();
			
			//detect collision
			if(mons.get(i).getxPos() == p.getPlayerX() && mons.get(i).getyPos() == p.getPlayerY()) {
				if(mons.get(i).getWeak() == false && mons.get(i).isDead() == false) {
					System.out.println("Game Over");
					p.dead();
				}
			}
		}
		
	}

	public char[][] getBoard() {
		return board;
	}

	public static void setBoard(char[][] board) {
		GameData.board = board;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Player getP() {
		return p;
	}

	public static void setP(Player p) {
		GameData.p = p;
	}

	public ArrayList<Monster> getMonsters() {
		return mons;
	}


}
