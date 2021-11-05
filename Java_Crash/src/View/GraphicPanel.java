package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Aku;
import Model.Arrow;
import Model.Box;
import Model.BoxType;
import Model.Crash;
import Model.Crystal;
import Model.Direction;
import Model.Enemy;
import Model.Manager;
import Model.TileType;
import Model.TypeEnemy;
import Model.Wumpa;

public class GraphicPanel extends JPanel {

	private static final long serialVersionUID = 2420221890130352491L;
	
	public static final Color BROWN = new Color(102,51,0);
	public static final Color ORANGE = new Color(255,153,0);
	public static final Color BLACK = new Color(0,0,0);
	static int WIDTH;
	static int HEIGHT;
	Manager man = null;
	Crash crash = null;
	Aku aku = null;
	Images img = new Images();
	Controller controller;
	int cont = 0;
	Sfondo bg = null;
	public int width = 1081;
	static public int scelta = 0;
	int current = 0;
	int totali = 0;
	int progress = 0;
	Boolean map = false;
	Double y = 0.0;
	public static PanelChanger changer;
	
	public GraphicPanel(Manager m,PanelChanger changer) {
		GraphicPanel.WIDTH = 1100;
		GraphicPanel.HEIGHT = 700;
		GraphicPanel.changer =  changer;
		this.man = m;
		this.controller = new Controller(man);
		this.crash = m.getCrash();
		this.aku = m.getAku();
		this.bg = new Sfondo(null);
		this.addKeyListener(controller);
		this.setFocusable(true);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Font/crash-a-like.ttf")));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(crash.getTileX(), cont, WIDTH, HEIGHT);
		if(man.pause) {
			if(scelta == 0 && man.gemGUI == false && man.crystalGUI == false) {
				g.drawImage(img.getPauseR__(), 0, 0,1100,700, null);
			}
			if(scelta == 0 && man.gemGUI == true && man.crystalGUI == true) {
				g.drawImage(img.getPauseRGC(), 0, 0,1100,700, null);
			}
			if(scelta == 0 && man.gemGUI == true && man.crystalGUI == false) {
				g.drawImage(img.getPauseRG_(), 0, 0,1100,700, null);
			}
			if(scelta == 0 && man.gemGUI == false && man.crystalGUI == true) {
				g.drawImage(img.getPauseR_C(), 0, 0,1100,700, null);
			}
			if(scelta == 1 && man.gemGUI == false && man.crystalGUI == false) {
				g.drawImage(img.getPauseQ__(), 0, 0,1100,700, null);
			}
			if(scelta == 1 && man.gemGUI == true && man.crystalGUI == true) {
				g.drawImage(img.getPauseQGC(), 0, 0,1100,700, null);
			}
			if(scelta == 1 && man.gemGUI == true && man.crystalGUI == false) {
				g.drawImage(img.getPauseQG_(), 0, 0,1100,700, null);
			}
			if(scelta == 1 && man.gemGUI == false && man.crystalGUI == true) {
				g.drawImage(img.getPauseQ_C(), 0, 0,1100,700, null);
			}
			
			g.setFont(new Font("Crash-a-Like", Font.PLAIN, 80));
			String wumpa = String.valueOf(man.getWumpaCont());
			String boxDistrutte = String.valueOf(man.getBoxCont());
			current = (man.getBoxCont()+man.getWumpaCont()+(Math.abs(man.getCristal().size()-2)));
			totali = (man.getBoxTot()+man.getWumpaTot()+man.getCristal().size());
			progress = (int)(current*100)/totali;
			String Sprogress = String.valueOf(progress);
			g.setColor(ORANGE);
			g.drawString(wumpa, 990, 580);
			g.drawString(boxDistrutte , 760, 580);
			g.setColor(BLACK);
			g.drawString(Sprogress + " %", 900, 190);
		}
		else {
		Graphics2D g2 = (Graphics2D) g.create();
		bg.draw(g2);
		if (crash.getX() > WIDTH / 2) {
			bg.setPosition(-crash.getX() + WIDTH / 2, y);
		}
		if (crash.getX() > WIDTH / 2) {
			if(crash.getX() < 8600) {
				g.translate(-(int) crash.getX() + WIDTH / 2, 0);
			}
			else {
				g.translate(-8060, 0);
			}
		}
		if (crash.getY() < HEIGHT / 2 ) {
			g.translate(0,-(int) crash.getY() + HEIGHT / 2);
		}
		 
		disegnaMap(g);
		disegnaCommands(g);
		disegnaBoxes(g);
		disegnaTnt(g);
		disegnaEnemy(g);
		disegnaArrow(g);
		disegnaCrystal(g);
		disegnaWumpa(g);
		disegnaPlayer(g);
		if(aku.getStato() != 0)
		disegnaAku(g);
		disegnaUI(g2);
		}
	}	
	
	
	public void disegnaCommands(Graphics g) {
		 g.drawImage(img.getWoodCommands(), 0, 10, 530,410,null);
	}

	
	public void disegnaUI(Graphics g2) {
			g2.drawImage(img.getWumpaGUI(),20,20, 60, 60, null);
			g2.drawImage(img.getBoxGUI(),400,20, 60, 60, null);
			if(man.crystalGUI == false)
			g2.drawImage(img.getunloCrystalGUI(),1000,20, 40, 60, null);
			if(man.crystalGUI == true)
			g2.drawImage(img.getCrystalGUI(),1000,20, 40, 60, null);
			if(man.gemGUI == false)
			g2.drawImage(img.getUnlogemGUI(),920,40, 60, 40, null);
			if(man.gemGUI == true)
			g2.drawImage(img.getGemGUI(),920,40, 60, 40, null);
			String wumpa = String.valueOf(man.getWumpaCont());
			String boxTotali = String.valueOf(man.getBoxTot());
			String boxDistrutte = String.valueOf(man.getBoxCont());
			g2.setFont(new Font("Crash-a-Like", Font.PLAIN, 80));
			g2.setColor(ORANGE);
			g2.drawString(wumpa, 100, 70);
			g2.setColor(BROWN);
			g2.drawString(boxDistrutte + "/ ", 590, 70);	
			g2.drawString(boxTotali, 500, 70);
	}
	
	public void disegnaMap(Graphics g) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 183; j++) {
				if (man.getMap()[i][j].getType() == TileType.Ground) {
					if(LevelPanel.level == 1)
						g.drawImage(img.getGroundTyle(), man.getMap()[i][j].getX(),	man.getMap()[i][j].getY(), man.getMap()[i][j].getWidth(), man.getMap()[i][j].getHeight(), null);
					else
						g.drawImage(img.getGroundTyleSnow(), man.getMap()[i][j].getX(),	man.getMap()[i][j].getY(), man.getMap()[i][j].getWidth(), man.getMap()[i][j].getHeight(), null);						
				}
				if (man.getMap()[i][j].getType() == TileType.Terra) {
					if(LevelPanel.level == 1)
						g.drawImage(img.getTerraTyle(), man.getMap()[i][j].getX(),man.getMap()[i][j].getY(), man.getMap()[i][j].getWidth(), man.getMap()[i][j].getHeight(), null);
					else
						g.drawImage(img.getTerraTyleSnow(), man.getMap()[i][j].getX(),man.getMap()[i][j].getY(), man.getMap()[i][j].getWidth(), man.getMap()[i][j].getHeight(), null);						
				}
				if (man.getMap()[i][j].getType() == TileType.Portale) {
					g.drawImage(img.getPortalEnd(), man.getMap()[i][j].getX(),man.getMap()[i][j].getY(), man.getMap()[i][j].getWidth(), man.getMap()[i][j].getHeight(), null);						
				}
			}
		}
	}

	public void disegnaArrow(Graphics g) {
		for (int i  = 0; i < man.getArrow().size(); i++) {
		  Arrow x = man.getArrow().elementAt(i);
			if(x.flying) {
				g.drawImage(img.getArrow(),x.getX(),x.getY(),x.getWidth(),x.getHeight(), null);
			}
		}
	}

	public void disegnaEnemy(Graphics g) {
		for (int i  = 0; i < man.getEnemy().size(); i++) {
			Enemy x = man.getEnemy().elementAt(i);
			if (x.getType() == TypeEnemy.DEAD) {
				g.drawImage(img.getHitEnemy(), x.getX(), x.getY(), x.getWidth(),x.getHeight(), null);
			}
			if (x.getType() == TypeEnemy.DINOSAURO) {
				if (x.getDirezione() == Direction.LEFT) {
					switch (x.getAnimation()) {
					case 0:
						g.drawImage(img.getDinoWalk1sx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					case 1:
						g.drawImage(img.getDinoWalk2sx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					case 2:
						g.drawImage(img.getDinoWalk3sx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					default:
						break;
					}
				}
				if (x.getDirezione() == Direction.RIGHT) {
					switch (x.getAnimation()) {
					case 0:
						g.drawImage(img.getDinoWalk1dx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					case 1:
						g.drawImage(img.getDinoWalk2dx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					case 2:
						g.drawImage(img.getDinoWalk3dx(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
						break;
					default:
						break;
					}
				}
			}
			if (x.getType() == TypeEnemy.CERBOTTANA) {
				switch (x.getAnimation()) {
				case 0:
					g.drawImage(img.getCerbottana1(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
					break;
				case 1:
					g.drawImage(img.getCerbottana2(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
					break;
				case 2:
					g.drawImage(img.getCerbottana3(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
					break;
				default:
					break;
				}
			}
		}
	}

	public void disegnaWumpa(Graphics g) {
		for (int i  = 0; i < man.getWumpas().size(); i++) {
			Wumpa x = man.getWumpas().elementAt(i);
			g.drawImage(img.getWumpa(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);
		}
	}

	public void disegnaCrystal(Graphics g) {
		for (int i  = 0; i < man.getCristal().size(); i++) {
		  Crystal x = man.getCristal().elementAt(i);
			if(x.getColor())
			g.drawImage(img.getCrystal(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);
			else {
			g.drawImage(img.getGem(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);				
			}
		}
	}

	public void disegnaBoxes(Graphics g) {
		for (int i  = 0; i < man.getBoxes().size(); i++) {
			Box x = man.getBoxes().elementAt(i);
			if (x.getType() == BoxType.BASE)
				g.drawImage(img.getBoxBase(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
			if (x.getType() == BoxType.DESTROYED)
				g.drawImage(img.getBrokenBox(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
			if (x.getType() == BoxType.MASK)
				g.drawImage(img.getMaskBox(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
		}
	}

	public void disegnaTnt(Graphics g) {
		for (int i  = 0; i < man.getTnt().size(); i++) {
			Box x = man.getTnt().elementAt(i);
			if (x.getType() == BoxType.TNT)
				g.drawImage(img.getBoxTNT(), x.getX(), x.getY(), x.getWidth(),x.getHeight(),null);
			if (x.getType() == BoxType.TNT3)
				g.drawImage(img.getTnt3(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);
			if (x.getType() == BoxType.TNT2)
				g.drawImage(img.getTnt2(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);
			if (x.getType() == BoxType.TNT1)
				g.drawImage(img.getTnt1(), x.getX(), x.getY(), x.getWidth(), x.getHeight(),null);
			if (x.getType() == BoxType.EXPLOSED)
				g.drawImage(img.getExplosion(), x.getX() - 40, x.getY()-10, x.getWidth() + 80,x.getHeight() + 20,null);
		}
	}

	public void disegnaAku(Graphics g) {
		if (crash.getDirezione() == Direction.LEFT) {
			if(aku.getStato() == 1) 
			g.drawImage(img.getAkusx(), aku.getX(), aku.getY(), aku.getWidth(), aku.getHeight(),null);
			if(aku.getStato() == 2)
			g.drawImage(img.getAku2(), aku.getX(), aku.getY()-10, aku.getWidth()+10, aku.getHeight()+10,null);
			if(aku.getStato() == 3) {
			 if(!crash.isCrouch)	
			    g.drawImage(img.getAku2(), crash.getX()-10, crash.getY()-10, aku.getWidth()+30, aku.getHeight()+30,null);
			 else
			    g.drawImage(img.getAku2(), crash.getX()-10, crash.getY()+10, aku.getWidth()+30, aku.getHeight()+30,null);
			}
		}
		if (crash.getDirezione() == Direction.RIGHT) {
			if(aku.getStato() == 1)
			g.drawImage(img.getAkudx(), aku.getX(), aku.getY(), aku.getWidth(),aku.getHeight(),null);
			if(aku.getStato() == 2)
			g.drawImage(img.getAku2dx(), aku.getX(), aku.getY()-10, aku.getWidth()+10,aku.getHeight()+10,null);	
			if(aku.getStato() == 3) {
			  if(!crash.isCrouch)	
			    g.drawImage(img.getAku2dx(), crash.getX()-10, crash.getY()-10, aku.getWidth()+30,aku.getHeight()+30,null);	
			  else
			    g.drawImage(img.getAku2dx(), crash.getX()-10, crash.getY()+10, aku.getWidth()+30, aku.getHeight()+30,null);
			}
		}
	}

	public void disegnaPlayer(Graphics g) {
	 if(!crash.getDamage())
		if (crash.getDirezione() == Direction.LEFT) {
			switch (crash.getRunsx()) {
			case 0:
				g.drawImage(img.getCrashsx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 1:
				g.drawImage(img.getRunsx1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 2:
				g.drawImage(img.getRunsx2(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 3:
				g.drawImage(img.getRunsx3(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 4:
				g.drawImage(img.getSpin1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 5:
				g.drawImage(img.getSpin2(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 6:
				g.drawImage(img.getDownsx(), crash.getX(), crash.getY()+30, crash.getWidth(),crash.getHeight()-30,null);
				break;
			case 7:
				g.drawImage(img.getJumpup1sx(), crash.getX(), crash.getY(),crash.getWidth(), crash.getHeight(),null);
				break;
			case 8:
				g.drawImage(img.getJumpup2sx(), crash.getX(), crash.getY(),crash.getWidth(), crash.getHeight(),null);
				break;
			case 9:
				g.drawImage(img.getJumpup3sx(), crash.getX(), crash.getY(),crash.getWidth(), crash.getHeight(),null);
				break;
			case 10:
				g.drawImage(img.getCrashsx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 11:
				g.drawImage(img.getDown1sx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 12:
				g.drawImage(img.getDown2sx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 13:
				g.drawImage(img.getJumpS5(), crash.getX() + 10, crash.getY(),crash.getWidth() + 20, crash.getHeight(),null);
				break;
			case 14:
				g.drawImage(img.getJumpS1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 15:
				g.drawImage(img.getJumpS2(), crash.getX(), crash.getY(),crash.getWidth() - 10, crash.getHeight(),null);
				break;
			case 16:
				g.drawImage(img.getJumpS3(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 17:
				g.drawImage(img.getJumpS4(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			default:
				break;
			}
		} else {
			switch (crash.getRundx()) {
			case 0:
				g.drawImage(img.getCrashdx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 1:
				g.drawImage(img.getRundx1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 2:
				g.drawImage(img.getRundx2(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 3:
				g.drawImage(img.getRundx3(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 4:
				g.drawImage(img.getSpin1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 5:
				g.drawImage(img.getSpin2(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 6:
				g.drawImage(img.getDowndx(), crash.getX(), crash.getY()+30, crash.getWidth(),crash.getHeight()-30,null);
				break;
			case 7:
				g.drawImage(img.getJumpup1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 8:
				g.drawImage(img.getJumpup2(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 9:
				g.drawImage(img.getJumpup3(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 10:
				g.drawImage(img.getCrashdx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 11:
				g.drawImage(img.getDown1dx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 12:
				g.drawImage(img.getDown2dx(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 13:
				g.drawImage(img.getJumpR5(), crash.getX() - 10, crash.getY(),crash.getWidth() + 20, crash.getHeight(),null);
				break;
			case 14:
				g.drawImage(img.getJumpR1(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 15:
				g.drawImage(img.getJumpR2(), crash.getX(), crash.getY(),crash.getWidth() - 10, crash.getHeight(),null);
				break;
			case 16:
				g.drawImage(img.getJumpR3(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			case 17:
				g.drawImage(img.getJumpR4(), crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight(),null);
				break;
			default:
				break;
			}
		}
	}

  public void updatePaint() {
	  new Thread() {
		  boolean update = true;
			@Override
			public void run() {
			   while(update) {	
					if(man.getCrash().getIsDead()) { 
						showGameOver();
						update = false;
						man.getCrash().setIsDead(false);
						man.end = true;
						return;
					}
					if(man.complete) {
					    showWin();
					    update = false;
					    man.complete = false;
					}
					else 
					repaint();
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			   }
			};
		}.start();
	}
  
  public void startUpdateGame() {
	  man.sUpdateGame();
  }
  
  public void showGameOver() {
	  changer.showLose();
  }
  
  public void showWin() {
	  changer.showWin();
  }

  public static void showMenu() {
	  changer.showMenu();
  }
    
}
