import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomePane extends JPanel { 
	
	private static GridLayout layout = new GridLayout(0, 1);
	private static JLabel welcome_label = new JLabel("PAC MAN", JLabel.CENTER);
	private static JButton start_button = new JButton("NEW GAME");
	private static JButton con_button = new JButton("CONTINUE");
	private static JButton about_button = new JButton("ABOUT");
	private static JButton stats_button = new JButton("Statistics");
	private static JFrame frame;
	
	
	public WelcomePane(JFrame frame) {
		this.setLayout(layout);
		//背景设为黑色
		this.setBackground(Color.BLACK);
		//标题为pacman
		welcome_label.setFont(new Font("Chalkduster", Font.BOLD, 48));
		welcome_label.setForeground(Color.YELLOW);
		this.add(welcome_label);
		
		gameButton();
		aboutButton();
		statButton();
		this.frame = frame;
	}

	private void gameButton() {
		start_button.setBackground(Color.BLACK);
		start_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
		start_button.setForeground(Color.BLUE);
		//start_button.setOpaque(true);
		start_button.setBorderPainted(false);
		
		start_button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            //starts new game
	        	 System.out.println("New Game");
	         }
	      });
		
		this.add(start_button);
		
		con_button.setBackground(Color.BLACK);
		con_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
		con_button.setForeground(Color.BLUE);
		//con_button.setOpaque(true);
		con_button.setBorderPainted(false);
		
		con_button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            //loads previous game
	        	 System.out.println("Continue Game");
	         }
	      });
		
		this.add(con_button);

	}
	
	private void aboutButton() {
		about_button.setBackground(Color.BLACK);
		about_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
		about_button.setForeground(Color.BLUE);
		//about_button.setOpaque(true);
		about_button.setBorderPainted(false);
		
		about_button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            //prints the about of the game
	        	 System.out.println("About the Game");	
	        	 AboutPane about = new AboutPane();
	        	 frame.add(about);
	         }
	      });
		
		this.add(about_button);
	}
	
	private void statButton() {
		stats_button.setBackground(Color.BLACK);
		stats_button.setFont(new Font("Chalkduster", Font.PLAIN, 24));
		stats_button.setForeground(Color.BLUE);
		//stats_button.setOpaque(true);
		stats_button.setBorderPainted(false);
		
		stats_button.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            //stats of the game.
	        	 System.out.println("Stats");
	         }
	      });
		
		this.add(stats_button);
	}

}
