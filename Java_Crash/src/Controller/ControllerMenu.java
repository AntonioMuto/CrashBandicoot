package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Model.SoundLoader;
import View.MenuPanel;

public class ControllerMenu implements KeyListener{
 
	MenuPanel m;
	SoundLoader s = new SoundLoader();
	
	public ControllerMenu(MenuPanel menu) {
	 this.m = menu;
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			s.playSelection();
			if (m.scelta == 2) {
				m.scelta = 0;
			}
			else {
				m.scelta++;;
			}
			m.repaint();
			break;
		case KeyEvent.VK_LEFT:
			s.playSelection();
			if (m.scelta == 0) {
				m.scelta = 2;
			}
			else {
				m.scelta--;
			}
			m.repaint();
			break;
		case KeyEvent.VK_ENTER:
			s.playSelection();
			if(m.scelta == 0) {
			  m.startGame();
			}
			if(m.scelta == 1) {
			 m.showLevels();	
			}
			if(m.scelta == 2) {
				try {
					final int i = JOptionPane.showConfirmDialog(null, "Do you really want to exit?", "Exit?",
							JOptionPane.YES_NO_OPTION);
					if (i == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				} catch (Exception e1) {
				}
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
