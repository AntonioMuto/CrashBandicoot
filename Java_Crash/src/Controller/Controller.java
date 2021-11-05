package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.Direction;
import Model.Manager;
import Model.SoundLoader;
import View.GraphicPanel;


public class Controller implements KeyListener {

	Manager man = null;
	SoundLoader s = null;
    Boolean spacePr = false;
    Boolean rightPr = false;	
    Boolean spaceRe = false;
    Boolean rightRe = false;
    Boolean leftRe = false;
    Boolean leftPr = false;
    int animation = 0;
    Boolean isJumping = false;
    Boolean isjumpingup = false;
    Boolean isfalling = false;
	Boolean shiftPr = false;
	
	public Controller( Manager m) {
		this.man = m;
		this.s = new SoundLoader();
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
	     if(!man.pause) {
			man.getCrash().setDirezione(Direction.LEFT);
			leftPr = true;
			man.Lpressed = true;
			if(!man.getCrash().getisJumping() && !man.getCrash().getisFalling()) {
				man.getCrash().isRunning = true;
				   man.moveLeft();
			}
			if(man.getCrash().getisFalling()) {
				   man.fallLeft();
			}
	     }
			break;
		case KeyEvent.VK_RIGHT:
		  if(!man.pause) {
			man.getCrash().setDirezione(Direction.RIGHT);
			rightPr = true;
			man.Rpressed = true;
			if(!isJumping && !man.getCrash().isjumpingR && !man.getCrash().getisFalling()) {
				man.getCrash().isRunning = true;
				man.moveRight();
			}
			if(man.getCrash().getisFalling()) {
			   man.fallRight();
			}
			break;
		  }
		case KeyEvent.VK_SHIFT:
	     if(!man.pause && !shiftPr) {
	    	 shiftPr = true;
		  if(!man.getCrash().getisjumpingR()) {	
		  if(leftPr) {
			  s.playSpin();
			  man.spinR();
			  break;
		  }
		  if(rightPr) {
			  s.playSpin();
			  man.spinR();
			  break;
		  }
		  if(!man.getCrash().getisSpinning()) {
			if(!man.getCrash().getisJumping()) {
						s.playSpin();
						man.spin();
						man.getCrash().setRundx(0);
						man.getCrash().setRunsx(0);
			}
		  }
		  }
	     }
			break;
		case KeyEvent.VK_DOWN:
		if(!man.pause) {	
			if(!isJumping && !man.getCrash().isjumpingR) {
		       man.getCrash().isCrouch = true;
				man.abbassa();
			}
		}
		else {
		 s.playSelection();	
		  if(GraphicPanel.scelta == 0) 
			  GraphicPanel.scelta = 1;
		  else 
			  GraphicPanel.scelta = 0;
		}
			break;
		case KeyEvent.VK_SPACE:
	    if(!man.pause) {
		 if(!man.getCrash().getisjumpingR() && !man.getCrash().getisFalling()) {	
		   if(!man.getCrash().getisJumping()) {
			  if(leftPr) {
				 isJumping = true;
				 man.jumpL();
				 isJumping = false;
				 break;
		      }
			  if(rightPr){
				 isJumping = true;
				 man.jumpR();
				 isJumping = false;
				 break;
			  }
			  if(!leftPr && !rightPr && !man.getCrash().isjumpingR && !man.getCrash().getisSpinning()) {
			     spacePr = true;
				 man.jump();
				 break;
			  }
		    }	
		  }
	     }
		    break;
		case KeyEvent.VK_ESCAPE:
		  if(!man.pause) 
			man.pause = true;
		  else
			man.pause = false;
		  break;
		case KeyEvent.VK_ENTER:
			  if(man.pause && GraphicPanel.scelta == 0) {
				s.playSelection();
				man.pause = false;
			  }
		      if(man.pause && GraphicPanel.scelta == 1) {
		    	s.playSelection();
		    	man.pause = false;  
				man.end = true;
				s.stopTheme();
				man.reset();
				GraphicPanel.showMenu();
				s.playTheme();
		      }
			  break;
		case KeyEvent.VK_UP:
			if(man.pause) {
			 s.playSelection();	
			  if(GraphicPanel.scelta == 0) 
				  GraphicPanel.scelta = 1;
			  else 
				  GraphicPanel.scelta = 0;
			}
			 break;
		default:
			man.standStill();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
	 case KeyEvent.VK_RIGHT:
		 if(!man.pause) {
		 	man.Rpressed = false;
		 	man.getCrash().isRunning = false;
			rightRe = true;
			rightPr = false;
			if(!man.getCrash().getisSpinning() && !man.getCrash().getisjumpingR() && !man.getCrash().getisFalling()) {
			  rightRe = false;
			  man.standStill();
			}
		 }
			break;
		  case KeyEvent.VK_LEFT:
			  if(!man.pause) { 
			  	man.Lpressed = false;
			  	man.getCrash().isRunning = false;
				leftRe = true;
				leftPr = false;
				if(!man.getCrash().getisSpinning() && !man.getCrash().getisjumpingR() && !man.getCrash().getisFalling()) {
				  leftRe = false;
				  man.standStill();
				}
			  }
			break;
		  case KeyEvent.VK_SHIFT:
			  shiftPr = false;
			  if(!man.pause) {
				if(!man.getCrash().getisJumping() && !man.getCrash().getisSpinning()) { 
				   man.standStill();
				}
			  }
				break;
			case KeyEvent.VK_DOWN:
			  if(!man.pause) {
				man.getCrash().isCrouch = false;
				if(!isJumping) {
				 man.standStill();
				}
			  }
				break;
			case KeyEvent.VK_SPACE:
			  if(!man.pause) {
				spaceRe = false;
				spacePr = false;
				if(!isJumping && !man.getCrash().getisjumpingR() && !man.getCrash().getisJumping()) {
				 man.standStill();
				}
			  }
				break;
			default:
				man.standStill();
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}