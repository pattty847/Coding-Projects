import java.util.Random;
import java.awt.Rectangle;

public class Ball{
  PVector circle;
  PVector circleVel;
  PVector lineXY = new PVector(width/2, height);
  PVector force;
  PVector acceleration;
  float mass;
  float size;
  
  Ball(){
     circle = new PVector(random(0, width), random(0, height));
     circleVel = new PVector(0, 0);
     acceleration = new PVector(0, 0);
     mass = random(1, 4);
  }
  
  public void applyForce(PVector force){
      PVector f = PVector.div(force, mass);
      acceleration.add(f);
  }
  
  public void applyWind(PVector wind){
      PVector windNew = PVector.div(force, wind); 
      acceleration.add(windNew);
  }
  
  public void update(){
       circleVel.add(acceleration); //Add it to the initial random placement vector.
       circle.add(circleVel);  
       acceleration.mult(0);
  }
  
  public void display(){
     stroke(0);
     strokeWeight(2);
     fill(255);
     ellipse(circle.x, circle.y, mass*16, mass*16); 
  }
  
  public void drawLTF(){
      line(lineXY.x, lineXY.y, circle.x, circle.y);
  }
  
  public void initBouncing(){
      if(circle.x>width){
         circle.x = width;
         circleVel.x*=-1;
      }else if(circle.x<0){
         circleVel.x*=-1;
         circle.x = 0;
      }
      if(circle.y > height){
         circleVel.y*=-1;
         circle.y = height;
      }
  }
}
