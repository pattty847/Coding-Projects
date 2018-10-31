import java.util.Random;
public class Ball{
  PVector circleXY;
  PVector circleVel;
  PVector lineXY = new PVector(width/2, height);

  float size;
  
  Ball(){
     circleXY = new PVector(random(0, width), random(0, height));
     circleVel = new PVector(random(5, 20), random(5, 20));
     this.size = random(5, 80);
  }
  
  public void drawBall(){
      float hu = map(circleXY.y, 0, height, 0, 255);
      fill(color(hu, 255, 255));
      ellipse(circleXY.x, circleXY.y, size, size);
      moveBall();
  }
  
  
  public void moveBall(){
      circleXY.add(circleVel.x, circleVel.y); 
  }
  
  public void drawLTF(){
      line(lineXY.x, lineXY.y, circleXY.x, circleXY.y);
  }
  
  public void initBouncing(){
      if((circleXY.x >= width) || (circleXY.x <= 0)){
          circleVel.x = circleVel.x * -1;
      }
      if((circleXY.y >= height) || (circleXY.y <= 0)){
          circleVel.y = circleVel.y * -1;
      }
  }
  
  public void createFloor(){
    int cols = width / 30;
    int scl = 30;
      for (int y = 0; y < cols; y++) 
      {
        for (int x = 0; x < cols; x++) 
        {
           fill(255);
           rect(x*scl, y*scl, scl, scl);
        }
      }  
    }
}
