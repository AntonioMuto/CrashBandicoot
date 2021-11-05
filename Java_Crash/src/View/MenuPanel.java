package View;
	
import java.awt.Graphics;
import javax.swing.JPanel;
import Controller.ControllerMenu;
import Model.Manager;
import Model.SoundLoader;


public class MenuPanel extends JPanel{
 
private static final long serialVersionUID = -8140042421642478766L;

public PanelChanger changer;
ControllerMenu c;
public int scelta = 0;
Images img = null;
SoundLoader s = null;
Manager man = new Manager();

 public MenuPanel(PanelChanger changer) {
    this.img = new Images();
    this.c = new ControllerMenu(this);
    this.addKeyListener(c);
	this.s = new SoundLoader();
    this.setSize(1100,700);
	this.setFocusable(true);
	this.changer = changer;
	this.setVisible(true);
 }
 
			
 public void startGame() {
   changer.showGame();
 }
 
 public void showLevels() {
   changer.showLevels();
 }


@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
		
		if(scelta == 0) {
			g.drawImage(img.getMenu1(), 0,0,1100,700, null);
		}
		if(scelta == 1) {
			g.drawImage(img.getMenu2(), 0, 0,1100,700, null);
		}
		if(scelta == 2) {
			g.drawImage(img.getMenu3(), 0, 0,1100,700, null);
		}
 	}

}
