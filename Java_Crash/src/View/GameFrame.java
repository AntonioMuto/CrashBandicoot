package View;

import javax.swing.JFrame;

import Model.Manager;
import Model.SoundLoader;

public class GameFrame extends JFrame implements PanelChanger {
	
	private static final long serialVersionUID = -6741405303768867598L;
	public SoundLoader s = null;
	public MenuPanel mp;
	public GraphicPanel graphicpanel;
	public GameOverPanel GoPanel;
	public LevelPanel levelPanel;
	public WinPanel winPanel;
	public Manager man = new Manager();
	
	
	public static void main(String[] args) {
//		LoadingFrame l = new LoadingFrame();
//	   if(l.isActive()) {	
		new GameFrame();
//		l.close();
//	   }
	}
	
	public GameFrame(){
	 setTitle("Crash Bandicoot");
	 setSize(1100,700);
	 setResizable(false);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.s = new SoundLoader();
	 mp = new MenuPanel(this);
	 GoPanel = new GameOverPanel(this);
	 graphicpanel = new GraphicPanel(man,this);
	 levelPanel = new LevelPanel(this);
	 winPanel = new WinPanel(this);
	 setVisible(true);
	 showMenu();
	 s.playTheme();
	}
	
	@Override
	public void showGame() {
		getContentPane().removeAll();
		getContentPane().add(graphicpanel);
		revalidate();
		graphicpanel.startUpdateGame();
		graphicpanel.updatePaint();
		graphicpanel.requestFocus();
	}
	
	@Override
	public void showMenu() {
		getContentPane().removeAll();
		getContentPane().add(mp);
		revalidate();
		mp.requestFocus();
		mp.repaint();
	}
	
	@Override
	public void showLose() {
		getContentPane().removeAll();
		getContentPane().add(GoPanel);
		revalidate();
		GoPanel.requestFocus();
		GoPanel.repaint();
		s.playGameOver();
	}

	@Override
	public void showLevels() {
		getContentPane().removeAll();
		getContentPane().add(levelPanel);
		revalidate();
		levelPanel.repaint();
		levelPanel.requestFocus();
	}

	@Override
	public void showWin() {
		getContentPane().removeAll();
		getContentPane().add(winPanel);
		revalidate();
		winPanel.repaint();
		winPanel.requestFocus();
	}


	
	
}
