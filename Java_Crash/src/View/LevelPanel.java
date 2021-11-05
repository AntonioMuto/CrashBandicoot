package View;

import java.awt.Graphics;
import javax.swing.JPanel;
import Controller.ControllerLevel;
import Model.Manager;
import Model.SoundLoader;

public class LevelPanel extends JPanel {

	private static final long serialVersionUID = -8140042421642478766L;

	public PanelChanger changer;
	ControllerLevel l;
	public int scelta = 0;
	Images img = null;
	SoundLoader s = null;
	public Sfondo bg = null;
	public static int level = 1;
	
	
	 public LevelPanel(PanelChanger changer) {
		    this.img = new Images();
		    this.l =  new ControllerLevel(this);
		    this.addKeyListener(l);
		    this.s = new SoundLoader();
		    this.bg = new Sfondo(null); 
			this.setSize(1100,700);
			this.setFocusable(true);
			this.changer = changer;
			this.setVisible(true);
	 }
	
	 @Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setFocusable(true);
			this.setVisible(true);
			this.requestFocusInWindow();
			
			if(scelta == 0) {
				g.drawImage(img.getMenuLvl1(), 0,0,1100,700, null);
			}
			if(scelta == 1) {
			  if(Manager.lvl1complete)
				g.drawImage(img.getMenuLvl2(), 0, 0,1100,700, null);
			  else {
				g.drawImage(img.getMenuLvl2Locked(), 0, 0,1100,700, null);
			  }
			}
	 	}
	
	public void startGame() {
		changer.showGame();
	}
	
	public void showMenu() {
		changer.showMenu();
	}

	
}
