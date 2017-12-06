import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class AboutPane extends JPanel{
	
	private BoxLayout layout = new BoxLayout(this, 1);
	private static JLabel title = new JLabel("PAC MAN", JLabel.CENTER);
	private static JTextPane description;
	private static JLabel control = new JLabel("Control: ", JLabel.CENTER);
	private static JTextPane control_des;
	private static JButton back = new JButton("Back");
	
	public AboutPane() {
		this.setLayout(layout);
		//背景设为黑色
		this.setBackground(Color.BLACK);
		//标题为pacman
		title.setFont(new Font("Chalkduster", Font.BOLD, 48));
		title.setForeground(Color.YELLOW);
		//title.setPreferredSize(getPreferredSize());
		this.add(title);
		
		description = new JTextPane();
		description.setText("Pac Man is an arcade game developed by Namco "
				+ "and first released in Japan"
				+ "In May 1980. This is a computer implementation of the game."
				+ "Your task is to eat all the beans in the map. "
				+ "You have three lives!"
				+ "The monsters will be moving around the maze to eat you! "
				+ "Avoid them!!"
				+ "But you can kill the monsters by bumping into them "
				+ "after you eat the mighty poweful beans "
				+ "that are in the maze. After you eat the power beans, "
				+ "you will have 8 seconds of super power!!"
				+ "If you kill the monsters during super power time, "
				+ "the monster will die. But behold! For that "
				+ "they will reborn in the center of the map "
				+ "ready to hunt you again!!!!");
		description.setFont(new Font("Chalkduster", Font.ITALIC, 20));
		description.setEditable(false);
		description.setForeground(Color.WHITE);
		description.setBackground(Color.BLACK);
		this.add(description);
		
		control.setFont(new Font("Chalkduster", Font.BOLD, 48));
		control.setForeground(Color.YELLOW);
		this.add(control);
		
		control_des = new JTextPane();
		control_des.setText("You can use the direction key on keyboard to "
				+ "control the direction of your character. \n"
				+ "UP: character moves upward until collide into a monster"
				+ "or reach the top of the maze or reach a wall.\n"
				+ "DOWN: character moves downward until collide into a monster"
				+ "or reach the bottom of the maze or reach a wall.\n"
				+ "LEFT: character moves left until collide into a monster"
				+ "or reach the left bound of the maze or reach a wall.\n"
				+ "RIGHT: character moves right until collide into a monster"
				+ "or reach the right bound of the maze or reach a wall.\n");
		control_des.setFont(new Font("Chalkduster", Font.ITALIC, 20));
		control_des.setBackground(Color.BLACK);
		control_des.setForeground(Color.WHITE);
		this.add(control_des);
		
		back.setBackground(Color.BLACK);
		back.setFont(new Font("Chalkduster", Font.PLAIN, 24));
		back.setForeground(Color.BLUE);
		back.setBorderPainted(false);
		
		back.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent arg0) {
	            //prints the about of the game
	        	 System.out.println("GO BACK TO MAIN PAGE");	 
	         }
	      });
		this.add(back);
		
	}

}
