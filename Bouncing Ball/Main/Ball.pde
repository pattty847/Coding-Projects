public class Ball{
  float circleY;
  float circleX;
  float lineX;
  float lineY;
  float ySpeed;
  float xSpeed;
  float size;
  
  Ball(){
     circleY = (random(0, height));
     circleX = (random(0, width));
     this.ySpeed = random(5, 20);
     this.xSpeed = random(5, 20);
     this.size = random(10, 30);
  }
  
  public void drawBall(){
      ellipse(circleX, circleY, size, size);
  }
  
  public void drawLTF(){
      line(lineX, lineY, circleX, circleY);
      line(width, 0, circleX, circleY);
      line(0, height, circleX, circleY);
      line(width, height, circleX, circleY); 
  }
  
  void initBouncing(){
      circleX = circleX += xSpeed;
      circleY = circleY += ySpeed;
      if(circleY > height || circleY < 0){
          ySpeed = ySpeed * -1;
          drawBall();
      }
      if(circleX > width || circleX < 0){
          xSpeed = xSpeed * -1;
          drawBall();
      }
  }  

}
