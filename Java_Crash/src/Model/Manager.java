package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import View.LevelPanel;


public class Manager {
 Tile tile[][] = new Tile[20][200];
 Vector<Box> casse = new Vector<Box>();
 Vector<Wumpa> fruit = new Vector<Wumpa>();
 Vector<Crystal> crystal = new Vector<Crystal>();
 static Vector<Enemy> enemy = new Vector<Enemy>();
 Vector<Arrow> arrow = new Vector<Arrow>();
 Vector<Box> tnt = new Vector<Box>();
 Crash crash = new Crash(250, 450, 40 , 90, Direction.RIGHT);
 Aku aku = new Aku(crash.getX()-20, crash.getY()-20,30,30, crash.getDirezione());
 SoundLoader s = null;
 public int animation = 0;
 boolean falling = false;
 int sound = 0;
 Boolean broken = false;
 Boolean isWall = false;
 public Boolean complete = false;
 Integer wumpaCont;
 Integer wumpaTot;
 Integer boxCont;
 Integer boxTot;
 public Boolean crystalGUI = false;
 public Boolean gemGUI = false;
 public Boolean end = false;
 public Boolean detonated = false;
 public Boolean Rpressed = false;
 public Boolean Lpressed = false;
 public Boolean pause = false;
 static public Boolean lvl1complete = false;
 
public void updateFall() {
	new Thread() {
		@Override
		public void run() {
		   while(!end) {
				fall();
				updateAku() ;
				endLevel();
				if(crash.isFalling) {
				  if(Rpressed)
					fallRight();
				  if(Lpressed)
					fallLeft();
				}
				if(crash.getIsDead()) {
					reset();
					s.stopTheme();
					if(crash.isInvincible)
						s.stopInvincible();
				}
				try {
					sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		   }
		};
	}.start();
}
 
public void sUpdateGame() {
	end = false;
	 try {
		CreateMap(LevelPanel.level);
	} catch (IOException e) {
		e.printStackTrace();
	}
	 updateFall();
	 updateIntersezione();
}


public void updateIntersezione() {
	new Thread() {
		@Override
		public void run() {
		   while(!end) {
			   intersezioneTail();
			   intersezioneEnemy();
			   intersezioneTnt();
			   intersezione();
			   intersezioneWumpaAndCrystal();
			   updateEnemy();
				try {
					sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		   }
		};
	}.start();
}


public void fall() {
	if(!isOnGround()) { 
	  if(!crash.isjumping && !crash.isjumpingR){
		crash.setVelocityY(crash.getVelocityY()+ crash.getGravity());
		 crash.setY((int) (crash.getY() + crash.getVelocityY()));
		 if(!crash.isFalling && !crash.isjumping && !crash.isjumpingR) {
				crash.setisFalling(true);
				crash.setRundx(13);
				crash.setRunsx(13);
		 }
		 if (crash.getVelocityY() >= crash.getMaxVelocityY()) {
			crash.setVelocityY(crash.getMaxVelocityY());
	     }
	  }
    } 
}
 
public boolean isOnGround() {
	for (int i = 0; i < 16; i++) {
		for (int j = 0; j < 183; j++) {
			if(crash.getRectangle().intersects(getMap()[i][j].getRectangleBup()) && getMap()[i][j].getType() == TileType.Ground){
				if(crash.getisFalling()){
					crash.setRundx(0);
					crash.setRunsx(0);
					crash.setisFalling(false);
					crash.setisJumping(false);
					crash.setY((int) getMap()[i][j].getRectangleBup().getY()-80);
				}
				else {
					crash.setY((int) getMap()[i][j].getRectangleBup().getY()-80);
				}
				isWall = false;
				return true;
			}
		}
	}
 return false;
}
 
 
public Vector<Box> getCasse() {
	return casse;
}

public Vector<Crystal> getCristal() {
	return crystal;
}

public Vector<Enemy> getEnemy(){
	return enemy;
}

public Vector<Arrow> getArrow(){
	return arrow;
}

public Vector<Box> getTnt(){
	return tnt;
}

public Tile[][] getMap(){
	return tile;
}

public Crash getCrash() {
	return crash;
}

public Aku getAku() {
	return aku;
}

public Integer getWumpaCont() {
	return wumpaCont;
}
public Integer getBoxCont() {
	return boxCont;
}

public Integer getWumpaTot() {
	return wumpaTot;
}

public void setBoxCont(Integer boxCont) {
	this.boxCont = boxCont;
}

public Integer getBoxTot() {
	return boxTot;
}

public void setBoxTot(Integer boxTot) {
	this.boxTot = boxTot;
}

public void CreateMap(int l) throws IOException {
	end = false;
BufferedReader in = null;
	File f = new File("text/Map_level_" + l + ".txt");
	try {
	int i = 0;
		in = new BufferedReader(new FileReader(f));
		String line = null;
		Boolean fine = false;
		 while(!fine) {
			line = in.readLine();
			if(line == null) {
				fine = true;
				break;
			}
			for(int j = 0; j < line.length()-1; j++) {
				if(line.charAt(j) == 'C') {
				 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Crash);
			     crash.setX(j*50);
			     crash.setY(i*50);
				}
				if(line.charAt(j) == '0') {
				 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Null);
				}
				if(line.charAt(j) == '1') {
						getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Ground);
				}
				if(line.charAt(j) == '2') {
						getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Terra);
				}
				if(line.charAt(j) == '3') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.BoxBase);
					 Box b = new Box(j * 50, (i * 50) + 10, 40, 40,BoxType.BASE , Direction.STOP);
					 casse.add(b);
				}
				if(line.charAt(j) == '4') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.BoxMask);
					 Box b = new Box(j * 50, (i * 50) + 10, 40, 40,BoxType.MASK , Direction.STOP);
					 casse.add(b);
				}
				if(line.charAt(j) == '5') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.BoxTnt);
					 Box b = new Box(j * 50, (i * 50) + 10, 40, 40,BoxType.TNT , Direction.STOP);
					 tnt.add(b);
				}
				if(line.charAt(j) == '6') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Dinosauro);
					 Enemy b = new Enemy(j * 50, i * 50, 70, 110,Direction.RIGHT, TypeEnemy.DINOSAURO);
					 enemy.add(b);
				}
				if(line.charAt(j) == '7') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Wumpa);
					 Wumpa w = new Wumpa(j*50, i*50, 30,30,Direction.STOP);
					 fruit.add(w);
				}
				if(line.charAt(j) == '8') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Crystal);
					 Crystal w = new Crystal(j*50, i*50, 30,60,Direction.STOP, true);
					 crystal.add(w);
				}	
				if(line.charAt(j) == '9') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Cerbottana);
					 Enemy b = new Enemy(j * 50, i * 50, 50, 100,Direction.LEFT, TypeEnemy.CERBOTTANA);
					 enemy.add(b);
					 arrow.add(b.getA());
				}
				if(line.charAt(j) == 'G') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 50, Direction.STOP, TileType.Gem);
					 Crystal w = new Crystal(j*50, i*50, 50,30,Direction.STOP, false);
					 crystal.add(w);
				}
				if(line.charAt(j) == 'E') {
					 getMap()[i][j] = new Tile(j * 50, i * 50, 50, 100, Direction.STOP, TileType.Portale);
				}
		   }
		   i++;	
		 }		
	}finally {
		if(in != null)
			in.close();
	}
	boxTot = casse.size() + tnt.size();
	wumpaTot = getWumpas().size(); 
}
	

public Manager(){
	this.wumpaCont = 0;
	this.boxCont = 0;
	this.s = new SoundLoader();
 }
 
public Vector<Wumpa> getWumpas(){
	return fruit;
}

public Vector<Box> getBoxes(){
	return casse;
}
 

public void moveRight() {
			if((crash.getRectangle(crash.getX()+12,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()][crash.getTileX()].getRectangleBleft()) || crash.getRectangle(crash.getX()+12,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()][crash.getTileX()].getRectangleBleft()) ) && getMap()[crash.getTileY()][crash.getTileX()].getType() == TileType.Ground){
				crash.setDirezione(Direction.RIGHT);
				crash.setRundx(0);
				return;
			}
			
			if((crash.getRectangle(crash.getX()+12,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()-1][crash.getTileX()].getRectangleBleft()) || crash.getRectangle(crash.getX()+12,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()-1][crash.getTileX()].getRectangleBleft()) ) && getMap()[crash.getTileY()-1][crash.getTileX()].getType() == TileType.Ground){
				crash.setDirezione(Direction.RIGHT);
				crash.setRundx(0);
				return;
			}
	
 for(int i = 0; i < this.getBoxes().size(); i++) {
	 if(crash.getRectangle(crash.getX()+20,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(this.getBoxes().elementAt(i).getRectangleBleft())){
		
	   	crash.setDirezione(Direction.RIGHT);
	   	crash.setRundx(0);
	   return;
	 }
 }
 for(int i = 0; i < this.getTnt().size(); i++) {
	   if(crash.getRectangle(crash.getX()+20,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(this.getTnt().elementAt(i).getRectangleBleft())){
		  if(getTnt().elementAt(i).getType() == BoxType.TNT || getTnt().elementAt(i).getType() == BoxType.TNT3 || getTnt().elementAt(i).getType() == BoxType.TNT2 || getTnt().elementAt(i).getType() == BoxType.TNT1 ) { 
		   crash.setDirezione(Direction.RIGHT);
		   crash.setRundx(0);
		   return;
		  }
	   }
 }
   if(!crash.isSpinning) {
 	 crash.setX(crash.getX()+10);
	 crash.runDx();
	 sleep(10);
   }	 
   
}

public void moveLeft() {
	
	if((crash.getRectangle(crash.getX(),crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()][crash.getTileX()-1].getRectangleBleft()) || crash.getRectangle(crash.getX(),crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()][crash.getTileX()-1].getRectangleBRight()) ) && (getMap()[crash.getTileY()][crash.getTileX()-1].getType() == TileType.Ground || getMap()[crash.getTileY()][crash.getTileX()-1].getType() == TileType.Terra)){
		crash.setDirezione(Direction.LEFT);
		crash.setRundx(0);
		return;
	}
	
	if((crash.getRectangle(crash.getX(),crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()-1][crash.getTileX()-1].getRectangleBleft()) || crash.getRectangle(crash.getX(),crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(getMap()[crash.getTileY()-1][crash.getTileX()-1].getRectangleBRight()) ) && (getMap()[crash.getTileY()-1][crash.getTileX()-1].getType() == TileType.Ground || getMap()[crash.getTileY()-1][crash.getTileX()-1].getType() == TileType.Terra)){
		crash.setDirezione(Direction.LEFT);
		crash.setRundx(0);
		return;
	}
	
	
	 for(int i = 0; i < this.getBoxes().size(); i++) {
		   if(crash.getRectangle(crash.getX()-5,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(this.getBoxes().elementAt(i).getRectangleBRight())){
			   
			   crash.setDirezione(Direction.LEFT);
				crash.setRunsx(0);
			return;
		   }
		 }
	 for(int i = 0; i < this.getTnt().size(); i++) {
		   if(crash.getRectangle(crash.getX()-5,crash.getY()+10,crash.getWidth()-15,crash.getHeight()-15).intersects(this.getTnt().elementAt(i).getRectangleBRight())){
			  if(getTnt().elementAt(i).getType() == BoxType.TNT || getTnt().elementAt(i).getType() == BoxType.TNT3 || getTnt().elementAt(i).getType() == BoxType.TNT2 || getTnt().elementAt(i).getType() == BoxType.TNT1 ) { 
			   crash.setDirezione(Direction.LEFT);
			   crash.setRunsx(0);
			   return;
			  }
		   }
	 }
	 if(crash.getX()-10 > 0) {	 
		 crash.setX(crash.getX()-10);
		 crash.runSx();
		 sleep(10);
	 }
	 
}

public void spinR() {
	new Thread() {
		@Override
		public void run() {
			animation = 0;
			crash.setisSpinning(true);
			try {
				while (animation < 14 && !end){
					crash.spin();
					animation++;
					if(crash.getDirezione() == Direction.RIGHT && getMap()[crash.getTileY(crash.getY())][crash.getTileX(crash.getX()+5)].getType() != TileType.Terra  && getMap()[crash.getTileY(crash.getY())][crash.getTileX(crash.getX()+5)].getType() != TileType.Ground ) {
						crash.setX(crash.getX()+5);
					}
					if(crash.getDirezione() == Direction.LEFT && crash.getX()-5 > 0 && getMap()[crash.getTileY(crash.getY())][crash.getTileX(crash.getX()-55)].getType() != TileType.Terra  && getMap()[crash.getTileY(crash.getY())][crash.getTileX(crash.getX()-55)].getType() != TileType.Ground ) { 
						crash.setX(crash.getX()-5);
					}
						sleep(40);
				}
				crash.rundx = 0;
				crash.runsx = 0;
				crash.setisSpinning(false);
			} catch (InterruptedException e) {
			}
		};
	}.start();
}

public void spin() {
	new Thread() {
		@Override
		public void run() {
			animation = 0;
			crash.setisSpinning(true);
			try {
				while (animation < 14 && !end){
					crash.spin();
					animation++;
					sleep(40);
				}
				crash.setisSpinning(false);
				if(crash.getisFalling()) {
				 crash.rundx = 13;
				 crash.runsx = 13;				}
				else {
				crash.rundx = 0;
				crash.runsx = 0;
				}
			} catch (InterruptedException e) {
			}
		};
	}.start();
}

public void moveDino(int i) {
	Enemy e = enemy.elementAt(i);
  if(e.getX() - crash.getX() <= 800 && !e.getWalking()) {	
	  e.setWalking(true);
   	new Thread() {
		@Override
		public void run() {
			try {
				while (!end && !e.dead) {
					  if(e.getDirezione() == Direction.RIGHT) {
						  if(e.getX()+5 <= e.getSpawn()+40){
						     e.setX(e.getX()+5);
						       e.moveDino();
						       sleep(100);
					      } 
						  else {
							  e.setDirezione(Direction.LEFT);
						  }
					  }
					  if(e.getDirezione() == Direction.LEFT) {
						  if(e.getX()-5 > e.getSpawn()-40){
							  e.setX(e.getX()-5);  
							  e.moveDino();
							  sleep(100);
						  }
						  else {
							  e.setDirezione(Direction.RIGHT);
						  }
					  }
				}
			} catch (InterruptedException e) {
			}

		};
	}.start();
  }
}


public void lookR() {
	
	crash.lookR();
	aku.setDirezione(Direction.RIGHT);
}

public void lookS() {
	
	crash.lookS();
	aku.setDirezione(Direction.LEFT);
}

public void standStill(){
	crash.still();
}

public void abbassa() {
	
	crash.down();
}

public void jump() {
	new Thread() {
		@Override
		public void run() {
			animation = 0;
			try {
				while ((animation < 31 || isOnGround()) && !end) {
					if(broken || isWall) {
						broken = false;
						isWall = false;
						break;
					}
					if(animation == 0 || animation == 10 || animation == 20 || animation == 30 )
						crash.jump();
					 crash.setY(crash.getY()-3);
					animation++;
					sleep(6);
				}
				if(crash.getRundx() != 13 && crash.getRunsx() != 13) {
					crash.setRundx(13);
					crash.setRunsx(13);
					crash.setisFalling(true);
					crash.setisJumping(false);
				}
			} catch (InterruptedException e) {
			}

		};
	}.start();
}

public void bounce() {
	new Thread() {
		@Override
		public void run() {
			animation = 0;
			try {
				while ((animation < 31 || isOnGround()) && !end) {
					if(animation == 0 || animation == 10 || animation == 20 || animation == 30 )
					crash.bounce();
					 crash.setY(crash.getY()-4);
					animation++;
					sleep(5);
					
				}
				crash.setisFalling(true);
				crash.setisJumpingR(false);
				crash.setisJumping(false);
				broken = false;
				if(crash.getRundx() != 13 && crash.getRunsx() != 13) {
					crash.setRundx(13);
					crash.setRunsx(13);
					crash.setisFalling(true);
					crash.setisJumpingR(false);
				}
			} catch (InterruptedException e) {
			}

		};
	}.start();
}

public void sleep(int x) {
	try {
	    Thread.sleep(1* x);
	} catch (InterruptedException ie) {
	    Thread.currentThread().interrupt();
	}
}

public void shootArrow(Enemy en) {
	 int cont = 0;
	   while(cont < 300) {	
		   en.getA().shootArrow();
		   en.getA().flying = true;
		   en.getA().setX(en.getA().getX()-1);
		   intersezioneArrow(en);
		   if(!en.getA().getFlying())
			  break;
		   sleep(4);
		   cont++;
		}
	   en.getA().flying = false;
	   en.getA().setX(en.getX());
	   en.getA().setY(en.getY()+30);
}


public void damageCrash() {
	s.playAkuVanish();
	new Timer().scheduleAtFixedRate( 
		        new TimerTask() {
		        	int cont = 0;
		            @Override
		            public void run() {
		            	crash.setDamage(true);
		            	if(cont == 4)
		            		cancel();
		            	cont++;
		            }
		        }, 
		        0,300
		);
	  new Timer().schedule( 
		        new TimerTask() {
		        	int cont  = 0;
		            @Override
		            public void run() {
		            	crash.setDamage(false);
		            	if(cont == 4)
		            		cancel();
		            	cont++;
		            }
		        }, 
		        100,300
		);
}



public void intersezioneArrow(Enemy en) {
	if(crash.getRectangle().intersects(en.getA().getRectangle()) &&  en.getA().getFlying()) {
	   if(crash.isInvincible) {
		   en.getA().setFlying(false);
		   return;
	   }
	   if(aku.getStato() == 0) {
		crash.setIsDead(true);
		en.getA().setFlying(false);
		s.stopTheme();
		end = true;
		reset();
	   }
		else {
			aku.setStato(aku.getStato()-1);
			damageCrash();
		 en.getA().setFlying(false);
		}
	}
}

public void endLevel() {
	for (int i = 0; i < 16; i++) {
		for (int j = 0; j < 183; j++) {
			if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getMap()[i][j].getRectangle())  && getMap()[i][j].getType() == TileType.Portale){
				complete = true;
				lvl1complete = true;
				s.stopTheme();
				s.playEndLevel();
				if(crash.isInvincible)
					s.stopInvincible();
				end = true;
				reset();
			}
		}
	}
}

public void attackCerb(int i){
	Enemy en = enemy.elementAt(i);
	en.walking = true;
   new Thread() {
		@Override
		public void run() {
			try {
				while (!end && en.walking) {
					 if(en.getX() - crash.getX() < 200 && en.dead == false) {
						 if(en.attack) {
						  en.attack = false;
						  en.getA().flying = true;
						  shootArrow(en);
						 }
						 else {
						  en.attackCerb();
						  sleep(100);
						 }
					 }
					 else {
						en.walking = false;
			     		en.setAnimation(0);
			     		en.attack = false;
			     	}
				  }
			}catch (InterruptedException e) {
			}
		};
	}.start();
}

public void updateEnemy() {
	for(int i = 0; i < enemy.size(); i++){
		if(enemy.elementAt(i).getType() == TypeEnemy.DINOSAURO)
			moveDino(i);
		if(enemy.elementAt(i).getType() ==  TypeEnemy.CERBOTTANA && !enemy.elementAt(i).getWalking()){
			if(enemy.elementAt(i).getX() - crash.getX() < 200)
				attackCerb(i);
		}
	}	
}

public void updateAku() {
	if(crash.getDirezione() == Direction.RIGHT) {
		   aku.setX(crash.getX()-20);
		   aku.setY(crash.getY()-20);
	}
	if(crash.getDirezione() == Direction.LEFT ) {	
		   aku.setX(crash.getX()+40);
		   aku.setY(crash.getY()-20);
	}
}


public void intersezioneEnemy() {
	for(int i = 0; i < this.getEnemy().size() ; i++) {
		if(crash.getRectangle(crash.getX()+5, crash.getY(), crash.getWidth()+5,crash.getHeight()).intersects(this.getEnemy().elementAt(i).getRectangle()) && this.getEnemy().elementAt(i).getType() != TypeEnemy.DEAD ){
			killEnemy(i);
		}
	}
}


public void intersezioneWumpaAndCrystal(){
	
	for(int i = 0; i < this.getWumpas().size() ; i++) {
    	if(crash.getRectangle().intersects(this.getWumpas().elementAt(i).getRectangle())) {
    		if(getWumpas().size() != 0) {
    			this.getWumpas().remove(i);
    			s.playWumpa();
    			wumpaCont++;
    		}
    	}
	}
	  
	for(int i = 0; i < this.getCristal().size(); i++) {
		if(crash.getRectangle().intersects(this.getCristal().elementAt(i).getRectangle())) {
			if(this.getCristal().elementAt(i).getColor()){
				this.getCristal().remove(i);
				crystalGUI = true;
				s.playCrystal();
			}
			else {
				this.getCristal().remove(i);
				gemGUI = true;
				s.playCrystal();
			}
		}
	}
}


public void intersezione() {
	if(crash.getY() > 750) {
		crash.setIsDead(true);
		end = true;
		s.stopTheme();
		reset();
	 }
	
	if(!casse.isEmpty()) {
		for(int i = 0; i < casse.size(); i++)
			gestisciBox(i, casse.elementAt(i).getType());
	}
	
	if(!tnt.isEmpty()) {
		for(int i = 0; i < tnt.size(); i++)
			gestiscitnt(i);
	}
	
}

public void fallLeft() {
	
	if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getMap()[crash.getTileY()][crash.getTileX()-1].getRectangle()) && (getMap()[crash.getTileY()][crash.getTileX()-1].getType() == TileType.Ground || getMap()[crash.getTileY()][crash.getTileX()-1].getType() == TileType.Terra) || isWall || crash.getX()-10 < 0){
	 return;
	}
	else {
	crash.setDirezione(Direction.LEFT);
	crash.setX(crash.getX()-10);
	crash.fallLeft();
	}
}

public void jumpL() {
	if(crash.getDirezione() == Direction.LEFT && getMap()[crash.getTileY(crash.getY()+1)][crash.getTileX(crash.getX()-55)].getType() != TileType.Terra  && getMap()[crash.getTileY(crash.getY()+1)][crash.getTileX(crash.getX()-55)].getType() != TileType.Ground ) {	
		new Thread() {
			@Override
			public void run() {
				animation = 0;
				try {
					while (animation < 50 && !broken && !isWall && !end) {
						if(crash.getDirezione() == Direction.LEFT){
								crash.setX(crash.getX()-2);
								crash.setY(crash.getY()-2);
								
								  if(animation == 0 || animation == 10 || animation == 20 || animation == 30)	
									crash.jumpR();
								  	animation++;
								  	sleep(10);
						}
						if(crash.getDirezione() == Direction.RIGHT){
								crash.setY(crash.getY()-2);
								crash.setX(crash.getX()+2);
								
								  if(animation == 0 || animation == 10 || animation == 20 || animation == 30)
								  	crash.jumpR();
								  	animation++;
								  	sleep(10);
						}
					  }
					  broken = false;
					  isWall = false;
					crash.setisJumpingR(false);
					if(crash.getRundx() != 13 && crash.getRunsx() != 13) {
						crash.setRundx(13);
						crash.setRunsx(13);
						crash.setisFalling(true);
						crash.setisJumping(false);
						crash.setisJumpingR(false);
					}
				} catch (InterruptedException e) {
				}

			};
		}.start();
	  }
}
  public void jumpR() {
	  if(crash.getDirezione() == Direction.RIGHT) {	
		new Thread() {
			@Override
			public void run() {
				animation = 0;
				try {
					while (animation < 50 && !broken && !isWall && !end) {
						if(crash.getDirezione() == Direction.LEFT){
								crash.setX(crash.getX()-2);
								crash.setY(crash.getY()-2);
								
								 if(animation == 0 || animation == 10 || animation == 20 || animation == 30)	
									crash.jumpR();
								 animation++;
								 sleep(10);
						}
						if(crash.getDirezione() == Direction.RIGHT){
								crash.setY(crash.getY()-2);
								crash.setX(crash.getX()+2);
								
								  if(animation == 0 || animation == 10 || animation == 20 || animation == 30) {		
								   	crash.jumpR();
								  }
								  animation++;
								  sleep(10);
						}
					  }
					  broken = false;
					  isWall = false;
					  crash.setisJumpingR(false);
					if(crash.getRundx() != 13 && crash.getRunsx() != 13) {
						crash.setRundx(13);
						crash.setRunsx(13);
						crash.setisFalling(true);
						crash.setisJumping(false);
						crash.setisJumpingR(false);
					}
				} catch (InterruptedException e) {
				}

			};
		}.start();
	  }
}
	
public void killEnemy(int i) {
	if(crash.isFalling || crash.isSpinning || crash.isInvincible) {
		getEnemy().elementAt(i).setType(TypeEnemy.DEAD);
		getEnemy().elementAt(i).dead = true;
		s.playEnemyHit();
		sleep(300);
		getEnemy().elementAt(i).getA().setFlying(false);
		if(i < getEnemy().size()) {
			if(getEnemy().elementAt(i).getType() == TypeEnemy.CERBOTTANA)
				getArrow().remove(i);
			getEnemy().remove(i);
		}
		return;
	}
	else {  		
		if(aku.getStato() == 0) {
			crash.setIsDead(true);
			s.stopTheme();
			reset();
			end = true;
			return;
		}
		if(aku.getStato() == 1 || aku.getStato() == 2) {
			aku.setStato(aku.getStato()-1);
			s.playEnemyHit();
			damageCrash();
			getEnemy().elementAt(i).setType(TypeEnemy.DEAD);
			getEnemy().elementAt(i).dead = true;
			sleep(300);
			getEnemy().elementAt(i).getA().setFlying(false);
			if(i < getEnemy().size()) {
				if(getEnemy().elementAt(i).getType() == TypeEnemy.CERBOTTANA)
					getArrow().remove(i);
				getEnemy().remove(i);
			}
			return;
		}
	}
}


public void gestiscitnt(int i) {
	if(crash.isInvincible) {	
		if(crash.getDirezione() == Direction.RIGHT && crash.getRectangle(crash.getX()+10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getTnt().elementAt(i).getRectangle()) && getTnt().elementAt(i).getType() != BoxType.EXPLOSED){
			this.getTnt().elementAt(i).setType(BoxType.EXPLOSED);
			s.playTntExplosion();
			broken = true;
			sleep(150);
			if(i < getTnt().size()) {
				 getTnt().remove(i);
				boxCont++;
			}
			return;
		}
		if(crash.getDirezione() == Direction.LEFT && crash.getRectangle(crash.getX()-10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getTnt().elementAt(i).getRectangle()) && getTnt().elementAt(i).getType() != BoxType.EXPLOSED){
			this.getTnt().elementAt(i).setType(BoxType.EXPLOSED);
			s.playTntExplosion();
			broken = true;
			sleep(150);
			if(i < getTnt().size()) {
				 getTnt().remove(i);
				boxCont++;
			}
			return;
		}	
}
	
	 Vector<Box> tnt = getTnt();
	if(this.getTnt().elementAt(i).getType() == BoxType.TNT){
				if(crash.getRectangle().intersects(this.getTnt().elementAt(i).getRectangleBounce()) &&  crash.getisFalling()) {	
					s.playTnt();
					bounce();
					getTnt().elementAt(i).setType(BoxType.TNT3);
					detonated = true;
					 new Timer().schedule( 
						        new TimerTask() {
						            @Override
						            public void run() {
						            	tnt.elementAt(i).setType(BoxType.TNT2);
						            }
						        }, 
						        1500 
						);
					 new Timer().schedule( 
						        new TimerTask() {
						            @Override
						            public void run() {
						            	tnt.elementAt(i).setType(BoxType.TNT1);
						            }
						        }, 
						        2500 
						);
					 new Timer().schedule( 
						        new TimerTask() {
						            @Override
						            public void run() {
						            	tnt.elementAt(i).setType(BoxType.EXPLOSED);
						            	sleep(200);
						            	if(crash.getX() > tnt.elementAt(i).getX() - 100 && crash.getX() < tnt.elementAt(i).getX() + 100 ) {
						            		 if(aku.getStato() != 0) {  
						            			   s.playTntExplosion();
						            			   aku.setStato(aku.getStato()-1);
						            			   damageCrash();
						            			   sleep(150);
						            			   if(i< tnt.size()) {
						            				   tnt.remove(i);
						            				   boxCont++;
						            				   return;
						            			   }
						            			  }
						            			  else {
						            				  s.playTntExplosion();
						            				  crash.setIsDead(true);
						            				  s.stopTheme();
						            				  cancel();
						            				  reset();
						            				  end = true;
						            			  }
						            	}
						            	else {
							            	sleep(1000);
							            	if(i<getTnt().size()) {
							            		getTnt().remove(i);
							            		boxCont++;
							            	}
						            	}
						            }
						        }, 
						        3500 
						);
				}
	}
}

public void playAudio(BoxType b){
	if(b == BoxType.MASK) {
		if(aku.getStato() >= 0 && aku.getStato() < 3) {
			s.playAkuBox();
			aku.setStato(aku.getStato()+1);
		}
		if(aku.getStato() == 3) {
		   crash.isInvincible = true;
		   s.playInvincible();
		   new Timer().schedule( 
			        new TimerTask() {
			            @Override
			            public void run() {
			               if(crash.isInvincible) {
			            	   aku.setStato(aku.getStato()-1);
			            	   s.playAkuVanish();
			            	   crash.isInvincible = false;
			               }
			            }
			        }, 
			        20400 
			);
		}
	} 
	if(b == BoxType.BASE || b == BoxType.DESTROYED)
	    s.playBrakeBox();
}


public void intersezioneBounce(int i, BoxType b) {
 if(!broken) {	
	if(crash.getDirezione() == Direction.LEFT){
		if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleBounce()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED) {
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			broken = true;
			if(crash.getisFalling())
				this.bounce();
			b = BoxType.DESTROYED;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;				
			}
		}
	}
	else if(crash.getDirezione() == Direction.RIGHT) {
		if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleBounce()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED ) {		   			
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			broken = true;
			if(crash.getisFalling())
				this.bounce();
			b = BoxType.DESTROYED;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;				
			}
		}
	}
 }
}

public void intersezioneTestata(int i, BoxType b) {
  if(!broken) {	
	if(crash.getDirezione() == Direction.LEFT){
		if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleTestata()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED) {
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			broken = true;
			b = BoxType.DESTROYED;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;
			}
		}
	}
	else if(crash.getDirezione() == Direction.RIGHT) {
		if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleTestata()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED) {		   			
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			broken = true;
			b = BoxType.DESTROYED;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;
			}
		}
	}
  }
}

public void intersezioneSpin(int i, BoxType b) {
	if(crash.getDirezione() == Direction.LEFT && crash.isSpinning){
		if((crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleBRight()) && b != BoxType.DESTROYED)){
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			b = BoxType.DESTROYED;
			broken = true;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;
			}
			broken = false;
		}
	}
	if(crash.getDirezione() == Direction.RIGHT && crash.isSpinning) {
		if((crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleBleft()) && b != BoxType.DESTROYED)) {		   			
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			b = BoxType.DESTROYED;
			broken = true;
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
				boxCont++;
			}
			broken = false;
		}
	}
}

public void intersezioneLeft(int i, BoxType b) {
 if(crash.getDirezione() == Direction.RIGHT ) {
		if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(),crash.getHeight()).intersects(this.getBoxes().elementAt(i).getRectangleBleft()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED) {		   			
			isWall = true;
			crash.setRundx(13);
			crash.setRunsx(13);
			crash.setisFalling(true);
			crash.setisJumping(false);
			crash.setisJumpingR(false);
		}
	}
}

public void fallRight() {
	
	if(crash.getRectangle(crash.getX(), crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getMap()[crash.getTileY()][crash.getTileX()].getRectangle()) && (getMap()[crash.getTileY()][crash.getTileX()].getType() == TileType.Ground || getMap()[crash.getTileY()][crash.getTileX()].getType() == TileType.Terra) || isWall ){
      return; 
	}
	else {
		crash.setDirezione(Direction.RIGHT);
		crash.setX(crash.getX()+10);
		crash.fallRight();
	}
}


public void gestisciBox(int i, BoxType b) {
	      if(crash.isInvincible) {
	    	  intersezioneBoxInvincible(i,b);
	    	  return;
	      }	
	      if(crash.getisjumpingR()) {
			intersezioneTestata(i,b);
		    intersezioneLeft(i,b);
		    return;
		  }
		  if(crash.getisJumping()) {
			intersezioneTestata(i,b);
		  	intersezioneLeft(i,b);
		  	return;
		  }
		  if(crash.getisFalling()) {
			intersezioneBounce(i,b);
		  	return;
		  }
		  if(crash.getisSpinning()) {
			intersezioneSpin(i,b);
			return;
		  }	   
	}
	
public void intersezioneTnt() {
  for(int i = 0; i < tnt.size(); i++) {
   if(crash.isSpinning && !crash.isInvincible ) {	  
     if(crash.getDirezione() == Direction.RIGHT) {	    
	   if(crash.getRectangle(crash.getX()+10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getTnt().elementAt(i).getRectangle()) && getTnt().elementAt(i).getType() != BoxType.EXPLOSED){
		  if(aku.getStato() != 0) {  
		   s.playTntExplosion();
		   aku.setStato(aku.getStato()-1);
		   this.getTnt().elementAt(i).setType(BoxType.EXPLOSED);
		   damageCrash();
		   sleep(150);
		   if(i<this.getTnt().size()) {
			   this.getTnt().remove(i);
			   boxCont++;
		   }
		  }
		  else {
			  s.playTntExplosion();
			  crash.setIsDead(true);
			  s.stopTheme();
			  reset();
			  end = true;
		  }
	   }
     }
  	if(crash.getDirezione() == Direction.LEFT) {
	   if(crash.getRectangle(crash.getX()-10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getTnt().elementAt(i).getRectangle()) && getTnt().elementAt(i).getType() != BoxType.EXPLOSED){
		  if(aku.getStato() != 0) {  
			s.playTntExplosion();
			aku.setStato(aku.getStato()-1);
			this.getTnt().elementAt(i).setType(BoxType.EXPLOSED);
			damageCrash();
			sleep(150);
			if(i<this.getTnt().size()) {
				this.getTnt().remove(i);
			    boxCont++;
			}
		  }
		  else {
			  s.playTntExplosion();
			  crash.setIsDead(true);
			  s.stopTheme();
			  reset();
			  end = true;
		  }
	   }
    }
   }
  }
}


public void intersezioneTail() {
	for (int i = 0; i < 16; i++) {
		for (int j = 0; j < 183; j++) {
		  if(getMap()[i][j].getType() == TileType.Ground || getMap()[i][j].getType() == TileType.Terra) {	
			if(crash.getRectangle(crash.getX()-20,crash.getY(),crash.getWidth(),crash.getHeight()).intersects(getMap()[i][j].getRectangleBleft()) ||  crash.getRectangle(crash.getX()+20,crash.getY(),crash.getWidth(),crash.getHeight()).intersects(getMap()[i][j].getRectangleBRight()) || crash.getX()-2 < 0 || crash.getRectangle().intersects(getMap()[i][j].getRectangleBDown())  ) {
				isWall = true;
			}
		  }
		}
	}
}

public void intersezioneBoxInvincible(int i, BoxType b) {
  if(crash.isInvincible) {	
	  if(crash.getDirezione() == Direction.RIGHT) {
		if(crash.getRectangle(crash.getX()+10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getBoxes().elementAt(i).getRectangle()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED){
			playAudio(b);
			this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
			sleep(150);
			if(i<this.getBoxes().size()) {
				this.getBoxes().remove(i);
			    boxCont++;
			}
		}
	  }
	  if(crash.getDirezione() == Direction.LEFT) {
			if(crash.getRectangle(crash.getX()-10, crash.getY(), crash.getWidth(), crash.getHeight()).intersects(getBoxes().elementAt(i).getRectangle()) && getBoxes().elementAt(i).getType() != BoxType.DESTROYED){
				playAudio(b);
				this.getBoxes().elementAt(i).setType(BoxType.DESTROYED);
				sleep(150);
				if(i<this.getBoxes().size()) {
					this.getBoxes().remove(i);
				    boxCont++;
				}
			}
	  }
  }
}


public void reset() {
	casse.clear();
	tnt.clear();
	fruit.clear();
	enemy.clear();
	arrow.clear();
	crystal.clear();
	crash.setX(250);
	crash.setY(450);
	crash.setDirezione(Direction.RIGHT);
	wumpaCont = 0;
	boxCont = 0;
	boxTot = 0;
	aku.setStato(0);
	crystalGUI = false;
	gemGUI = false;
	if(crash.isInvincible) {
	crash.isInvincible = false;
	s.stopTheme();
	s.stopInvincible();
	}
}


}
