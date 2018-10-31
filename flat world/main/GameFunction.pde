import java.awt.Rectangle;
import java.awt.Point;
import java.util.*; 


public class GameFunction{
  
  Rectangle rec = new Rectangle();;
  LinkedList<Point> points = new LinkedList<Point>(); 
  GameFunction(){
  }
  
  public void setup()
  {
    for (int y = 0; y < rows; y++) 
    {
      for (int x = 0; x < cols; x++) 
      {
         fill(0);
         rec.setRect(x*scl, y*scl, scl, scl);
         rect(rec.x, rec.y, scl, scl);
         checkMouse();
      }
    }  
  }
  
  
  public void checkMouse()
  {
    for (int y = 0; y < rows; y++) 
    {
      for (int x = 0; x < cols; x++) 
      {
         
      }
    } 
  }
}
