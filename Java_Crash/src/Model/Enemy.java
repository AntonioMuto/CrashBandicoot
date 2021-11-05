package Model;

import java.awt.Rectangle;

public class Enemy extends Map_Object{
	
	    int x;
		int y;
	    int width;
	    int height;
	    Direction d ;
	    int animation;
		TypeEnemy t;
		Boolean attack;
		int spawn;
		Boolean dead;
		Boolean walking;
		Arrow a = null;
		
	    Enemy(int x, int y, int width, int height, Direction d, TypeEnemy t){
	    	super(x,y,width,height,d);    	
	    	this.t = t;
	    	this.spawn = x;
	    	this.animation = 0;
	    	this.attack = false;
	    	this.t = t;
	    	this.dead = false;
	    	this.walking = false;
	    	this.a = new Arrow(x,y+30,10,10,d);
	    }
	    
	    public Arrow getA() {
			return a;
		}

		public void setA(Arrow a) {
			this.a = a;
		}

		public Rectangle getRectangle(){
	    	Rectangle r = new Rectangle(this.getX()+23,this.getY()+20,this.getWidth()-30,this.getHeight()-20);
	    	return r;
	    }
	    
	    public TypeEnemy getType() {
	    	return t;
	    }
	    
	    public void setType(TypeEnemy t) {
	    	this.t = t;
	    }
	    
	    public int getSpawn() {
	    	return spawn;
	    }
        
	    public int getAnimation() {
	    	return animation;
	    }
	    
	    public void setAnimation(int a) {
	    	animation = a;
	    }
	    
	    public Boolean getWalking() {
			return walking;
		}
	    
	    public void setWalking(Boolean walking) {
			this.walking = walking;
		}
	    
	    
	    public void moveDino() {
	    	if(animation == 0) {
	    		animation = 1;
	    		sleep(100);
	    		return;
	    	}
	    	if(animation == 1) {
	    		animation = 2;
	    		sleep(100);
	    		return;
	    	}
	    	else {
	    		animation = 0;
	    		sleep(100);
	    		return;
	    	}
	    }
	    
	    public void attackCerb() {
	    	if(animation == 0) {
	    		animation = 1;
	    		return;
	    	}
	    	if(animation == 1) {
	    		this.attack = true;
	    		animation = 2;
	    		return;
	    	}
	    	if(animation == 2) {
	    		animation = 0;
	    		return;
	    	}
	    	else {
	    		animation = 0;
	    		return;
	    	}
	    }
	    
}
