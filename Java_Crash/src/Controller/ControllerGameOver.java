package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.SoundLoader;
import View.GameOverPanel;

public class ControllerGameOver implements KeyListener{

	GameOverPanel g;
	SoundLoader s = new SoundLoader();
	
	public ControllerGameOver(GameOverPanel go){
		this.g = go;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			s.playSelection();
			if (g.scelta == 1) {
				g.scelta = 0;
			} else {
				g.scelta++;;
			}
			g.repaint();
			break;
		case KeyEvent.VK_UP:
			s.playSelection();
			if (g.scelta == 0) {
				g.scelta = 1;
			} else {
				g.scelta--;
			}
			g.repaint();
			break;
		case KeyEvent.VK_ENTER:
			s.playSelection();
			s.stopGameOver();
			s.playTheme();
			if(g.scelta == 1)
				g.showMenu();
			else {
				g.showGame();
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
