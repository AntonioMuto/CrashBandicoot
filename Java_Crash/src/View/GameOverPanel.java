package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import Controller.ControllerGameOver;
import Model.SoundLoader;


public class GameOverPanel  extends JPanel {

private static final long serialVersionUID = 829897174436798024L;

public static final Color BROWN = new Color(102,51,0);
	public PanelChanger changer;
	ControllerGameOver c;
    SoundLoader s = null;
	Images img = new Images();
	public int scelta = 0;
	
	public GameOverPanel(PanelChanger changer) {
		this.changer = changer;
		this.c = new ControllerGameOver(this);
		this.addKeyListener(c);
		this.s = new SoundLoader();
	 	this.img = new Images();
		this.setSize(700,400);
		this.setFocusable(true);
		this.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		
		if(scelta == 0) {
			g.drawImage(img.getGameOverSi(), 0,0,1100,700, null);
		}
		if(scelta == 1) {
			g.drawImage(img.getGameOverNo(), 0, 0,1100,700, null);
		}
		g.setFont(new Font("Crash-a-Like", Font.PLAIN, 80));
		g.setColor(BROWN);
		g.drawString("GAME OVER", 420, 70);	
 	}

	public void showMenu() {
		changer.showMenu();
	}

	public void showGame() {
		changer.showGame();
	}
	

}
