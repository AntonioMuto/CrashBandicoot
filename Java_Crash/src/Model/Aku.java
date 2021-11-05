package Model;

public class Aku extends Map_Object{
    private int x;
	private int y;
    private int width = 30;
    private int height = 30;
    public Direction d ;
    private int stato = 0;
    
    public Aku(int x, int y, int width, int height, Direction d) {
    	super(x,y,width,height,d);
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

	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}
}
