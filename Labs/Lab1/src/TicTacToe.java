import java.util.Scanner;

public class TicTacToe {
	private static String userSymbol = "X";
	private static String compSymbol = "O";
	private final static String win = "YOU WON!!!";
	private final static String lose = "YOU LOST!!!";
	private final static String draw = "Game ended. It's a draw :/";
	private static String[][] board = new String[3][3];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		initiallize();
	}
		
	public static void initiallize() {	
		boolean isValid = false;
		System.out.print("Hi, Welcome to Tic-Tac-Toe!\n"
						+ "Please enter X or O to begin: ");
		while(isValid = true) {
			userSymbol = sc.next();
			if(userSymbol.equals("O")) {
				compSymbol = "X";
				isValid = true;
				compMove();
			}
			else if(userSymbol.equals("X")) {
				isValid = true;
				//prompts input location from user
				start();
			}
			else {
				System.out.print("Please enter a valid symbol(X or O): ");
			}
		}
	}
	
	private static void compMove() {
		int row = (int) (Math.random()*3);
		int col = (int) (Math.random()*3);
		while(!(isValid(row, col))) {
			row = (int) (Math.random()*3);
			col = (int) (Math.random()*3);
		}
		board[row][col] = compSymbol;
		printTable();
		start();
		
	}


	public static boolean isValid(int row, int col) {
		if(row > 3 || col > 3) {
			return false;
		}
		else if(board[row][col] != null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean isEnd() {
		boolean result = true;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(board[i][j] == null) {
					result = false;
				}
			}
		}
		return result;
	}
	
//	public static boolean isWin() {
//		if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
//			return true;
//		}
//		else if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])) {
//			return true;
//		}
//		else if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
//			return true;
//		}
//		else if(board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2])) {
//			return true;
//		}
//		else if(board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2])) {
//			return true;
//		}
//		else if(board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2])) {
//			return true;
//		}
//		else if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
//			return true;
//		}
//		else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	public static void start() {
		int row = 0;
		int col = 0;
		
		//while game does not end
		while(!(isEnd())) {
			System.out.print("\nPlease enter the row of your move: ");
			row = sc.nextInt()-1;
			System.out.print("Please enter the column of your move: ");
			col = sc.nextInt()-1;
			while(isValid(row, col)) {
				board[row][col] = userSymbol;
				printTable();
				System.out.println("\nSystem makes the following move: ");
				compMove();		
			}	
		}
	}
	
	private static void printTable() {
		for(int i = 0; i<3; i++) {
			System.out.print("\n");
			for(int j = 0; j<3; j++) {
				if(board[i][j] == null) {
					System.out.print("|_");
				}
				else {
					System.out.print("|" + board[i][j]);
				}
			}
		}
	}
	
	

}
