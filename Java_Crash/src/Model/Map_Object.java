package Model;

import java.awt.Rectangle;


public class Map_Object {
 int x,y,width,height;
 Direction d;
 double gravity;
 double speedY;
 
public Map_Object(int x, int y, int width, int height, Direction d) {
	super();
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.d = d;
	this.gravity = 0.4;
	this.speedY = 0;
}

public Direction getDirezione() {
	return d;
}

public void setDirezione(Direction d) {
	this.d = d;
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

public Rectangle getRectangle(int x, int y, int w, int h){
	Rectangle r = new Rectangle(x, y,w,h);
	return r;
}


public void sleep(int x) {
	try {
	    Thread.sleep(1* x);
	} catch (InterruptedException ie) {
	    Thread.currentThread().interrupt();
	}
}

}
