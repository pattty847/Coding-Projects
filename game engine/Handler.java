import java.util.LinkedList;
import java.awt.Graphics;
/**
 * This file will accept each GameObject, add it to a LinkedList, then render
 * each object with a for loop in the tick() method. 
 */

public class Handler {
//-:Creates a list that each element is connected to the one before and after (for the GameObjects)
//-:Go to GameObject to see how the file is constructed.
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject obj = object.get(i); //Retreves the object for the index(i).
            obj.tick(); //Recurrsive function will continue to count and render objects because its connected to game loop.
        }
    }

    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject obj = object.get(i); //Retreves the object from index(i).
            obj.render(g);
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

    public void addObj(GameObject obj){
        this.object.add(obj);
    }
    public void removeObj(GameObject obj){
        this.object.remove(obj);
    }
}