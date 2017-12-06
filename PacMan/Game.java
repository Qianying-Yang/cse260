import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game {
	
	private static JFrame frame = new JFrame();
	private static GameData board = new GameData();
	private static GameCanvas map = new GameCanvas(board);
	
	public static void main(String[] args) {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 800);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		//frame.add(welcome());
		
		frame.add(map);
		frame.addKeyListener(board.getP());	
		while(board.gameOver() == 0) {
			board.start();
			map.repaint();
			try {
				Thread.sleep(50);
			}catch(InterruptedException e){
				
			}
			
		}
		if(board.gameOver() == 1) {
			JOptionPane.showMessageDialog(frame,
				    "YOU LOST!!!");
		}
		else if(board.gameOver() == 2) {
			JOptionPane.showMessageDialog(frame,
				    "YOU WIN!!!");
		}
		
	}
	
//	public static JPanel welcome() {
//		JPanel welcomePane = new JPanel();
//		BoxLayout layout = new BoxLayout(welcomePane, 0);
//		welcomePane.setLayout(layout);
//		//背景设为黑色
//		welcomePane.setBackground(Color.BLACK);
//		//标题为pacman
//		JLabel welcome_label = new JLabel("PAC MAN");
//		welcome_label.setFont(new Font("Chalkduster", Font.BOLD, 48));
//		welcome_label.setForeground(Color.YELLOW);
//		welcomePane.add(welcome_label);
//		
//		JButton start_button = new JButton("Start");
//		start_button.setBackground(Color.BLACK);
//		start_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
//		start_button.setForeground(Color.BLUE);
//		//start_button.setOpaque(true);
//		start_button.setBorderPainted(false);
//		
//		start_button.addActionListener(new ActionListener() {
//	         @Override
//	         public void actionPerformed(ActionEvent arg0) {
//	            //starts new game
//	        	 System.out.println("New Game");
//	         }
//	      });
//		
//		welcomePane.add(start_button);
//		
//		JButton con_button = new JButton("Continue");
//		con_button.setBackground(Color.BLACK);
//		con_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
//		con_button.setForeground(Color.BLUE);
//		//con_button.setOpaque(true);
//		con_button.setBorderPainted(false);
//		
//		con_button.addActionListener(new ActionListener() {
//	         @Override
//	         public void actionPerformed(ActionEvent arg0) {
//	            //loads previous game
//	        	 System.out.println("Continue Game");
//	         }
//	      });
//		
//		welcomePane.add(con_button);

//		JButton about_button = new JButton("About");
//		about_button.setBackground(Color.BLACK);
//		about_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
//		about_button.setForeground(Color.BLUE);
//		//about_button.setOpaque(true);
//		about_button.setBorderPainted(false);
//		
//		about_button.addActionListener(new ActionListener() {
//	         @Override
//	         public void actionPerformed(ActionEvent arg0) {
//	            //prints the about of the game
//	        	 System.out.println("About the Game");	
//	         }
//	      });
//		
//		welcomePane.add(about_button);
		
//		JButton stats_button = new JButton("Stats");
//		stats_button.setBackground(Color.BLACK);
//		stats_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
//		stats_button.setForeground(Color.BLUE);
//		//stats_button.setOpaque(true);
//		stats_button.setBorderPainted(false);
//		
//		stats_button.addActionListener(new ActionListener() {
//	         @Override
//	         public void actionPerformed(ActionEvent arg0) {
//	            //stats of the game.
//	        	 System.out.println("Stats");
//	         }
//	      });
		
//		return welcomePane;		
//}


	
	

}
