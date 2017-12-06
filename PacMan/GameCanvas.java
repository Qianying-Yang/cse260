import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class GameCanvas extends Canvas{
	
	private GameData data;
	private int w;
	private int h;
	private int pixel = 20;
	
	public GameCanvas(GameData data) {
		this.data = data;
		w = data.getWidth();
		h = data.getHeight();
		this.setSize(w, h);	
	}
	
//	public void paintPlayer(Graphics g) {
//		paint(data.getP().getPlayer().getGraphics());
//		g.drawImage(data.getP().getPlayer(), 0, 0, null);	
//	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		//fills the rectangle
		g.fillRect(0, 0, getWidth(), getHeight());
		//g.setColor(Color.WHITE);
		
		//draws the player
		g.setColor(Color.YELLOW);
		g.fillArc(data.getP().getPlayerX()*pixel, data.getP().getPlayerY()*pixel,
				pixel, pixel, 4*data.getP().getMouth(), 360-8*data.getP().getMouth());
		g.setColor(Color.BLACK);
		g.drawArc(data.getP().getPlayerX()*pixel, data.getP().getPlayerY()*pixel,
				pixel, pixel, 4*data.getP().getMouth(), 360-8*data.getP().getMouth());
		g.fillOval(data.getP().getPlayerX()*pixel + pixel/4, 
				data.getP().getPlayerY()*pixel + pixel/4,
				pixel/10, pixel/10);
		
		//iterate through loop display the map.
		for(int i = 0; i<w; i++) {
			for(int j = 0; j<h; j++) {
				char cell = data.getelement(i, j);
				if(cell == '#') {
					g.setColor(Color.DARK_GRAY);
					g.fillRect(i*pixel, j*pixel, pixel, pixel);
					
				}
				else if(cell == 'o') {
					g.setColor(Color.YELLOW);
					//g.drawOval(i*pixel, j*pixel, pixel, pixel);
					g.fillOval(i*pixel, j*pixel, pixel, pixel);
					
				}
				else if(cell == '.') {
					g.setColor(Color.YELLOW);
					//g.drawOval(i*pixel + pixel/3, j*pixel + pixel/3, pixel/3, pixel/3);
					g.fillOval(i*pixel + pixel/3, j*pixel + pixel/3, pixel/3, pixel/3);
							
				}
				else if(cell == ' ') {
					//does nothing
					continue;
				}
				else {
					System.err.println("INVALID MAP INPUT");
					break;
				}
			}
		}
		
		//draws the monsters
				for(int i = 0; i< data.getMonsters().size(); i++) {
					Monster m = data.getMonsters().get(i);
					if(m.getName().equals("Pinky")) {	
						g.setColor(Color.PINK);
					}
					else if(m.getName().equals("Inky")) {
						
						g.setColor(Color.CYAN);
					}
					else if(m.getName().equals("Clyde")) {
						g.setColor(Color.ORANGE);
					}
					else if(m.getName().equals("Blinky")) {
						g.setColor(Color.RED);
					}
					g.fillOval(m.getxPos()*pixel, m.getyPos()*pixel, pixel, pixel);
					g.fillRect(m.getxPos()*pixel, m.getyPos()*pixel + pixel/2, pixel, pixel/2);
					g.setColor(Color.WHITE);
					//eyes
					g.fillRect(m.getxPos()*pixel + pixel/3, m.getyPos()*pixel + pixel/2, 
							pixel/5, pixel/5);
					g.fillRect(m.getxPos()*pixel + 2 * pixel/3, 
							m.getyPos()*pixel + pixel/2, pixel/5, pixel/5);
				}
			
	}

}
