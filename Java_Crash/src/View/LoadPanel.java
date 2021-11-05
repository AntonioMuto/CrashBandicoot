package View;

import java.awt.Graphics;

import javax.swing.JPanel;

import Model.SoundLoader;

public class LoadPanel extends JPanel {

	private static final long serialVersionUID = -6234257509422473305L;
	
	Images img = null;
	SoundLoader s = null;
	
	
	public LoadPanel(){
		this.img = new Images();
		this.s = new SoundLoader();
	    this.setSize(1100,700);
		this.setFocusable(true);
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setFocusable(true);
		this.setVisible(true);
		this.requestFocusInWindow();
			g.drawImage(img.getLoading(), 0,0,1100,700, null);
		}
 	}
	
