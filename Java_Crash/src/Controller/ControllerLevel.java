package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Model.Manager;
import Model.SoundLoader;
import View.LevelPanel;

public class ControllerLevel implements KeyListener {

	LevelPanel lp;
	SoundLoader s = new SoundLoader();

	
	public ControllerLevel(LevelPanel l) {	
		this.lp = l;
	}
	

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			s.playSelection();
			if (lp.scelta == 1) {
				lp.scelta = 0;
			} else {
				lp.scelta = 1;
			}
			lp.repaint();
			break;
		case KeyEvent.VK_DOWN:
			s.playSelection();
			if (lp.scelta == 0) {
				lp.scelta = 1;
			} else {
				lp.scelta = 0;
			}
			lp.repaint();
			break;
		case KeyEvent.VK_ENTER:
			s.playSelection();
			if(lp.scelta == 0) {
				LevelPanel.level = 1;
				lp.startGame();
				lp.bg.setBg(1);
			}
			else {
			  if(Manager.lvl1complete) {	
				LevelPanel.level = 2;
				lp.startGame();
				lp.bg.setBg(2);
			  }
			  else {
				  JOptionPane.showInternalMessageDialog(null, "you must first complete the level 'Under Muntain' to unlock this",
						  "LOCKED", JOptionPane.INFORMATION_MESSAGE);
			  }
			}
			break;
		case KeyEvent.VK_ESCAPE:
			s.playSelection();
			lp.showMenu();
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
