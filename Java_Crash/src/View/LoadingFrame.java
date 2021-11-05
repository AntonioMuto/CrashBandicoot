package View;


import javax.swing.JFrame;

import Model.SoundLoader;

public class LoadingFrame extends JFrame {

	Images img = new Images();
	LoadPanel loadPanel;
	SoundLoader s =  new SoundLoader();
	private static final long serialVersionUID = -1405456006692227978L;

	public LoadingFrame(){
		loadPanel = new LoadPanel();
		s.playLoading();
		setTitle("LOADING...");
		setSize(1100, 700);
		setVisible(true);
		setResizable(false);
		add(loadPanel);
		loadPanel.repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void close() {
		dispose();
		s.stopLoading();
	}
	
}
