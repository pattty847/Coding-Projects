import java.awt.Graphics;
import java.awt.Color;

public class Cell{

    private int x, y;
    private Cell parent;
    private int cols, rows;
    private int scl = 40;


    public Cell(int x, int y){
        this.x = x; 
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }
    
    public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
    
    public void setParent(Cell parent) {
		this.parent = parent;
	}

	public static boolean isEqual(Cell c, Cell c2) {
		if (c.getX() == c2.getX() && c.getY() == c2.getY()) {
			return true;
		}
		return false;
	}
}