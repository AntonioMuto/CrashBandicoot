package Model;

import java.awt.Rectangle;

public class Tile extends Map_Object {

	int x;
	int y;
	int width;
	int height;
	Direction d;
	TileType t;

	Tile(int x, int y, int width, int height, Direction d, TileType t){
    	super(x,y,width,height,d);    	
    	width = 50;
    	height = 50;
    	this.t = t;
    }
	
	public TileType getType() {
		return t;
	}

	public void setT(TileType t) {
		this.t = t;
	}
	
	public Rectangle getRectangle() {
		Rectangle r = new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
		return r;
	}
	
	public Rectangle getRectangleBup() {
		Rectangle r = new Rectangle(this.getX()+5,this.getY(),this.getWidth()-10,this.getHeight()-45);
		return r;
	}
	
	public Rectangle getRectangleBDown() {
		Rectangle r = new Rectangle(this.getX()+15,this.getY()+45,this.getWidth()-30,this.getHeight()-45);
    	return r;
	}
	
	public Rectangle getRectangleBleft() {
		Rectangle r = new Rectangle(this.getX()-10,this.getY()+15,this.getWidth()-30,this.getHeight()-30);
    	return r;
	}
	
	public Rectangle getRectangleBRight() {
		Rectangle r = new Rectangle(this.getX()+45,this.getY()+15,this.getWidth()-45,this.getHeight()-30);
    	return r;
	}
	
	
	
}
