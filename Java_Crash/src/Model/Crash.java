package Model;

import java.awt.Rectangle;

public class Crash extends Map_Object{
 public int x , y , width, height;
 int rundx = 0; // movimenti dx;
 int runsx = 0; // movimenti sx;
 int spin = 0;
 double velocityY = 0;
Direction d ;
 public double maxVelocityY = 10;
 public double gravity;
 Boolean fermo = true;
 Boolean isjumping = false;
 public Boolean isjumpingR = false;
 Boolean isFalling = false;
 Boolean isSpinning = false;
 Boolean strisciadx = false;
 Boolean strisciasx = false;
 public Boolean isRunning = false;
 public Boolean isCrouch = false;
 Boolean isInvincible = false;
 Boolean isDead = false;
 Boolean damage = false;
 
public Crash(int x, int y, int width, int height, Direction d) {
	super(x,y,width, height, d);
	this.gravity = 9.5;
	this.velocityY = 0;
}

public double getMaxVelocityY() {
	return maxVelocityY;
}

public void setMaxVelocityY(double maxVelocityY) {
	this.maxVelocityY = maxVelocityY;
}

public double getVelocityY() {
	return velocityY;
}

public void setVelocityY(double speed) {
	this.velocityY = speed;
}

public double getGravity() {
	return gravity;
}

public void setGravity(double gravity) {
	this.gravity = gravity;
}

public Boolean getFermo() {
	return fermo;
}
public void setFermo(Boolean fermo) {
	this.fermo = fermo;
}

public Boolean getDamage() {
	return damage;
}

public void setDamage(Boolean damage) {
	this.damage = damage;
}

public Boolean getisRunning() {
	return isRunning;
}
public void setisRunning(Boolean x) {
	this.isRunning = x;
}

public Boolean getIsDead() {
	return isDead;
}

public void setIsDead(Boolean isDead) {
	this.isDead = isDead;
}

public int getRundx() {
	return rundx;
}
public int getRunsx() {
	return runsx;
}

public void setRunsx(int x) {
	runsx = x;
}

public void setRundx(int x) {
	rundx = x;
}

public Direction getDirezione() {
	return d;
}
public void setDirezione(Direction direzione) {
	this.d = direzione;
}

public void runDx() {
	if(rundx == 1) {
		sleep(20);
		rundx = 2;
		return;
    }
	if(rundx == 2) {
		sleep(20);
		rundx = 3;
	    return;
	}   
	else {
	sleep(20);	
	 rundx = 1;
	 return;
	}
}

public void spin() {
	if(runsx == 5 || rundx  == 5) {
		runsx = 4;
		rundx = 4;
		return;
    }
	else {
		runsx = 5;
		rundx = 5;
	    return;
	}   
}

public void lookR(){
   this.setDirezione(Direction.RIGHT);
}

public void lookS(){
	this.setDirezione(Direction.LEFT);
}

public void still() {
	rundx = 0;
	runsx = 0;
}

public void runSx() {
	
	if(runsx == 1) {
		sleep(20);
		runsx = 2;
		return;
    }
	if(runsx == 2) {
		sleep(20);
		runsx = 3;
	    return;
	}   
	else {
		sleep(20);
	 runsx = 1;
	 return;
	}
}

public void down() {
   rundx = 6;
   runsx= 6;
}

public void jump(){
	if(runsx == 7 || rundx == 7) {
		runsx = 8;
		rundx = 8;
		isjumping = true;
		return;
    }
	if(runsx == 8 || rundx == 8) {
		runsx = 9;
		rundx = 9;
	    return;
	}
	if(runsx == 9 || rundx == 9) {
		isjumping = false;
        isFalling = true;
        runsx = 13;
        rundx = 13;
	    return;
	}
	else {
	 rundx = 7;
	 runsx = 7; 
	 isjumping = true;
	 return;
	}
 }

public void bounce() {
	if(runsx == 7 || rundx == 7) {
		runsx = 8;
		rundx = 8;
		isjumping = true;
		return;
    }
	if(runsx == 8 || rundx == 8) {
		runsx = 9;
		rundx = 9;
		isjumping = false;
	    return;
	}
	if(runsx == 9 || rundx == 9) {
        isFalling = true;
        runsx = 13;
        rundx = 13;
	    return;
	}
	else {
	 rundx = 7;
	 runsx = 7; 
	 return;
	}
}

public Boolean getisFalling() {
	return isFalling;
}

public void setisFalling(boolean x) {
	isFalling = x;
}

public Boolean getisSpinning() {
	return isSpinning;
}

public void setisSpinning(boolean x) {
	isSpinning = x;
}

public Boolean getisJumping() {
	return isjumping;
}

public void setisJumping(boolean x) {
	isjumping = x;
}

public Boolean getisjumpingR() {
	return isjumpingR;
}

public void setisJumpingR(boolean x) {
	isjumpingR = x;
}

public void fallRight() {
	rundx = 13;
	return;
}

public void fallLeft() {
	runsx = 13;
	return;
}

public void jumpR() {                             
	if(runsx == 14 || rundx == 14) {
		runsx = 15;
		rundx = 15;
		isjumpingR = true;
		return;
    }
	if(runsx == 15 || rundx == 15) {
		this.isRunning = false;
		runsx = 16;
		rundx = 16;
	    return;
	}
	if(runsx == 16 || rundx == 16) {
        runsx = 17;
        rundx = 17;
	    return;
	}
	if(runsx == 17 || rundx == 17) {
		isjumpingR = false;
        isFalling = true;
        runsx = 13;
        rundx = 13;
	    return;
	}
	else {
	 rundx = 14;
	 runsx = 14; 
	 this.isRunning = true;
	 isjumpingR = true;
	 return;
	}
}

public void jumpRight() {
	rundx = 9;
	this.setDirezione(Direction.RIGHT);
	this.setX(this.getX()+10);
	this.setisFalling(true);
	this.isRunning = true;
}

public void jumpLeft() {
	runsx = 9;
	this.setDirezione(Direction.LEFT);
	this.setX(this.getX()-10);
	this.setisFalling(true);
	this.isRunning = true;
}


public Rectangle getRectangle() {
	if(isCrouch) {
      Rectangle r = new Rectangle(this.getX()+8, this.getY()+35,this.getWidth()-15,this.getHeight()-40);
      return r;
	}
	else {
	Rectangle r = new Rectangle(this.getX()+8, this.getY()+10,this.getWidth()-15,this.getHeight()-15);
	return r;
	}
}

public int getTileX() {
	return (this.getX()/ 50) + 1;
}

public int getTileX(int x) {
	return (x/ 50) + 1;
}

public int getTileY(int y) {
	return (y/ 50) + 1;
}


public int getTileY() {
	return (this.getY()/ 50) + 1;
}




}
