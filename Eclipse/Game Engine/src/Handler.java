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
    
    
	char currentKey = (char) 0;
	private int size = 40;

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
        g.fillRect(0, 0, game.getWidth(), game.getHeight());
        for (int j = 0; j < game.getHeight(); j += size) {
			for (int i = 0; i < game.getWidth(); i += size) {
				g.setColor(Color.WHITE);
				g.drawRect(i, j, size, size);
			}
        }
        for(int i=0;i<object.size();i++){
            GameObject obj = object.get(i); //Retreves the object from index(i).
            obj.render(g);
        }
    }
    
    public int getHeight() {
    	return Game.H;
    }
    public int getWidth() {
    	return Game.W;
    }
    public void addObj(GameObject obj){
        this.object.add(obj);
    }
    public void removeObj(GameObject obj){
        this.object.remove(obj);
    }

}