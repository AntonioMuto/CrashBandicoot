package View;

import java.awt.Graphics;
import java.awt.Image;

public class Sfondo {

	Images img = new Images();
	public static Image bg;
	private int x;
	private double moveScale = 0.6; // 0.3 to move

	public Sfondo(Graphics g) {
		bg = img.getBg();
	}

	public void setPosition(double x, double y) {
		this.x = (int) ((x * moveScale) % 1081);
	}

	public void draw(Graphics g) {
	    	g.drawImage(bg, x, 0, 1081, 660, null);  
		if (x < 0) {
			g.drawImage(bg, x + 1081, 0, 1081, 660, null);
		}
		if (x > 0) {
			g.drawImage(bg, x - 1081, 01, 1081, 660, null);
		}
	}
	
	public void setBg(int i) {
		  if(i == 1)	
		    	bg = img.getBg();
		  if(i == 2)	
		    	bg = img.getBgSnow();
	}

}
