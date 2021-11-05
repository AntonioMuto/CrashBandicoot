package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.SoundLoader;
import View.WinPanel;

public class ControllerWin implements KeyListener {

	WinPanel w;
	SoundLoader s = new SoundLoader();
	
	public ControllerWin(WinPanel win) {
		this.w = win;
	}

		public void keyPressed(KeyEvent e) {
		   if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			   s.stopEndlevel();
			   s.playTheme();
			   s.playSelection();
			   w.showMenu();
		   }
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	
}
