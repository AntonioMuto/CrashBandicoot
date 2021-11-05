package Model;

import java.awt.Rectangle;

public class Box extends Map_Object{
  BoxType type;
  Direction d;
  int x;
  int y;
 Box(int x, int y, int width, int height, BoxType type, Direction d){
	 super(x,y,width,height,d);
	 this.type = type;
	 this.x = x;
	 this.y = y;
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

public BoxType getType() {
	 return type;
 }
 
 public void setType(BoxType x) {
	 this.type = x;
 }

 public Rectangle getRectangle() {
	 Rectangle r = new Rectangle(this.getX(),this.getY(),this.getWidth(),this.getHeight());
	    return r;
 }
 
 public Rectangle getRectangleBounce() {
	 Rectangle r = new Rectangle(this.getX()+4,this.getY(),this.getWidth()-8,this.getHeight()-35);
	    return r;
 }
 
 public Rectangle getRectangleTestata() {
	 Rectangle r = new Rectangle(this.getX()+10,this.getY()+35,this.getWidth()-20,this.getHeight()-35);
	    return r;
 }
 
 public Rectangle getRectangleBleft(){
   if(this.getType() == BoxType.BASE) { 
	    Rectangle r = new Rectangle(this.getX(),this.getY(),this.getWidth()-35,this.getHeight());
	    return r;
   }
   
   if(this.getType() == BoxType.MASK) { 
	    Rectangle r = new Rectangle(this.getX(),this.getY()+5,this.getWidth()-35,this.getHeight()-10);
	    return r;
  }
   
   if(this.getType() == BoxType.TNT || this.getType() == BoxType.TNT1 || this.getType() == BoxType.TNT2 || this.getType() == BoxType.TNT3) { 
	    Rectangle r = new Rectangle(this.getX()+13,this.getY()+10,this.getWidth()-23,this.getHeight()-14);
	    return r;
   }
   
   if(this.getType() == BoxType.DESTROYED) { 
	    Rectangle r = new Rectangle(this.getX(),this.getY()+100,this.getWidth(),this.getHeight());
	    return r;
   }
   
   Rectangle r = new Rectangle(this.getX()+10,this.getY()+10,this.getWidth()-40,this.getHeight()-10);
   return r;
   
 }
 
 public Rectangle getRectangleBRight(){
	   if(this.getType() == BoxType.BASE) { 
		    Rectangle r = new Rectangle(this.getX(),this.getY()+5,this.getWidth(),this.getHeight()-10);
		    return r;
	   }
	   
	   if(this.getType() == BoxType.MASK) { 
		    Rectangle r = new Rectangle(this.getX()+35,this.getY()+5,this.getWidth()-35,this.getHeight()-10);
		    return r;
	  }
	   
	   if(this.getType() == BoxType.TNT || this.getType() == BoxType.TNT1 || this.getType() == BoxType.TNT2 || this.getType() == BoxType.TNT3) { 
		    Rectangle r = new Rectangle(this.getX()+13,this.getY()+10,this.getWidth()-23,this.getHeight()-14);
		    return r;
	   }
	   Rectangle r = new Rectangle(this.getX()+10,this.getY()+10,this.getWidth()-40,this.getHeight()-10);
	   return r;
	 }
 
 public int getTailX() {
	 return (this.getX() / 50);
 }
 
 public int getTailY() {
	 return (this.getY() / 50);
 }
 
}
