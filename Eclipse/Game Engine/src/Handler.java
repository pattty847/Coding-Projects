import java.util.LinkedList;

import javax.swing.SwingUtilities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
/**
 * This file will accept each GameObject, add it to a LinkedList, then render
 * each object with a for loop in the tick() method. 
 */

public class Handler {
//-:Creates a list that each element is connected to the one before and after (for the GameObjects)
//-:Go to GameObject to see how the file is constructed.
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    LinkedList<Cell> cells = new LinkedList<Cell>();
	char currentKey = (char) 0;
	private int size = 25;
	Cell startCell, endCell;
	public Handler(){
	}
    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject obj = object.get(i); //Retreves the object for the index(i).
            obj.tick(); //Recurrsive function will continue to count and render objects because its connected to game loop.
        }
        
    }

    public void render(Graphics g, Game game){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 800, 800);
        for (int j = 0; j < game.getHeight(); j += size) {
			for (int i = 0; i < game.getWidth(); i += size) {
				g.setColor(Color.WHITE);
				g.drawRect(i, j, 25, 25);
			}
		}
//        g.setColor(Color.black);
//		for (int i = 0; i < pathfinding.getBorderList().size(); i++) {
//			g.fillRect(pathfinding.getBorderList().get(i).getX() + 1, pathfinding.getBorderList().get(i).getY() + 1,
//					size - 1, size - 1);
//		}
        for(int i=0;i<object.size();i++){
            GameObject obj = object.get(i); //Retreves the object from index(i).
            obj.render(g);
        }
    }
    
    
    
    
    public void MapCalculations(MouseEvent e) {
		// If left mouse button is clicked
		if (SwingUtilities.isLeftMouseButton(e)) {
			// If 's' is pressed create start node
			if (currentKey == 's') {
				int xRollover = e.getX() % size;
				int yRollover = e.getY() % size;

				if (startCell == null) {
					startCell = new Cell(e.getX() - xRollover, e.getY() - yRollover);
				} else {
					startCell.setXY(e.getX() - xRollover, e.getY() - yRollover);
				}
				//repaint();
			} 
			// If 'e' is pressed create end node
			else if (currentKey == 'e') {
				int xRollover = e.getX() % size;
				int yRollover = e.getY() % size;

				if (endCell == null) {
					endCell = new Cell(e.getX() - xRollover, e.getY() - yRollover);
				} else {
					endCell.setXY(e.getX() - xRollover, e.getY() - yRollover);
				}
				//repaint();
			} 
			// Otherwise, create a wall
			else {
				int xBorder = e.getX() - (e.getX() % size);
				int yBorder = e.getY() - (e.getY() % size);

				Cell newBorder = new Cell(xBorder, yBorder);
				//pathfinding.addBorder(newBorder);

				//repaint();
			}
		} 
		// If right mouse button is clicked
		else if (SwingUtilities.isRightMouseButton(e)) {
			int mouseBoxX = e.getX() - (e.getX() % size);
			int mouseBoxY = e.getY() - (e.getY() % size);

			// If 's' is pressed remove start node
			if (currentKey == 's') {
				if (startCell != null && mouseBoxX == startCell.getX() && startCell.getY() == mouseBoxY) {
					startCell = null;
					//repaint();
				}
			} 
			// If 'e' is pressed remove end node
			else if (currentKey == 'e') {
				if (endCell != null && mouseBoxX == endCell.getX() && endCell.getY() == mouseBoxY) {
					endCell = null;
					//repaint();
				}
			} 
			// Otherwise, remove wall
			else {
				//repaint();
			}
		}
	}

//-:This will remove and create a new object in the LinkedList, with the parameter of GameObject.
/**
    public GameObject(int x, int y, ID id){
    this.x = x;
    this.y = y;
    this.id = ID;
    }
 */

    public void addCell(Cell c){
        this.cells.add(c);
    }
    public void removeCell(Cell c){
        this.cells.remove(c);
    }

    public void addObj(GameObject obj){
        this.object.add(obj);
    }
    public void removeObj(GameObject obj){
        this.object.remove(obj);
    }

}