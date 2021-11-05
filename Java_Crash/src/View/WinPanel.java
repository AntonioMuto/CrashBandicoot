package View;

import java.awt.Graphics;
import javax.swing.JPanel;
import Controller.ControllerWin;
import Model.Manager;
import Model.SoundLoader;

public class WinPanel extends JPanel{
	
	private static final long serialVersionUID = -8140042421642478766L;

	public PanelChanger changer;
	ControllerWin w;
	Images img = null;
	SoundLoader s = null;
	Manager man = new Manager();

	 public WinPanel(PanelChanger changer) {
	    this.img = new Images();
	    this.w = new ControllerWin(this);
	    this.addKeyListener(w);
		this.s = new SoundLoader();
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
			g.drawImage(img.getEndLevel(), 0,0,1100,700, null);
	 	} 
	 
  public void showMenu() {
	  changer.showMenu();
  }
	
}
