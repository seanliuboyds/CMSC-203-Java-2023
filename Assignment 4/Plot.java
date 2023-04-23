import javax.print.attribute.standard.MediaSize.Other;

public class Plot extends java.lang.Object {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot plot) {
		if (x < (plot.x + plot.width) && (x + width) > plot.x && 
			y < (plot.y + plot.depth) && y + depth > plot.y ) {
			return true;
		}
		return false;
	}
	
	public boolean encompasses(Plot plot) {
		
		if (this.x <= plot.x && this.y <= plot.y && this.x + this.width >= plot.x + plot.width && this.y + this.depth >= plot.y + plot.depth) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public String toString() {
		return "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;
	}
	
	
	
	
	
	
	
	
}
