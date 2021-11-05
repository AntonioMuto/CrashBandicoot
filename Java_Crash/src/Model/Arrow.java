package Model;

import java.awt.Rectangle;

public class Arrow extends Map_Object {

	int x;
	int y;
	int width;
	int height;
	Direction d ;
    int animation = 100;
   public Boolean flying = false;
		
    Arrow(int x, int y, int width, int height, Direction d){
    	super(x,y,width,height,d);  
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.d = d;
    	flying = false;
	}
	
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Direction getD() {
		return d;
	}

	public void setD(Direction d) {
		this.d = d;
	}

	public int getAnimation() {
		return animation;
	}

	public void setAnimation(int animation) {
		this.animation = animation;
	}

	public Boolean getFlying() {
		return flying;
	}

	public void setFlying(Boolean flying) {
		this.flying = flying;
	}

	public Rectangle getRectangle(){
    	Rectangle r = new Rectangle(this.getX(),this.getY(),10,10);
    	return r;
    }
	
	public void shootArrow() {	
		animation = 0;
	}
	
}
