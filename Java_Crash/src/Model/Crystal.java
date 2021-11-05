package Model;

import java.awt.Rectangle;

public class Crystal extends Map_Object {
	
	 int x;
	 int y;
	 int width;
	 int height;
	 Direction d;
	 Boolean color; // false = red  true = purple

	 Crystal(int x, int y, int width, int height, Direction d, Boolean color){
		 super(x,y,width,height,d);
		 this.color = color;
	 }
	
	public Boolean getColor() {
		return color;
	}

	public void setColor(Boolean color) {
		this.color = color;
	}

	public Rectangle getRectangle(){
    	Rectangle r = new Rectangle(this.getX()+5,this.getY()+5,this.getWidth()-10,this.getHeight()-8);
    	return r;
    }
}
