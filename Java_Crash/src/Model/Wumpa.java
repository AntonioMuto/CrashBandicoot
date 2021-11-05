package Model;

import java.awt.Rectangle;

public class Wumpa extends Map_Object{
	
    int x;
	int y;
    int width;
    int height;
    Direction d ;
    int animation = 0;
	
    Wumpa(int x, int y, int width, int height, Direction d){
    	super(x,y,width,height,d);    	
    }
    
    public Rectangle getRectangle(){
    	Rectangle r = new Rectangle(this.getX()+5,this.getY()+5,this.getWidth()-10,this.getHeight()-8);
    	return r;
    }
    
}
