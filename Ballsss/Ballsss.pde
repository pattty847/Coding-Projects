float circleY;
float circleX;
float lineX;
float lineY;
float ySpeed = 5;
float xSpeed = 5;

void setup() {
  size(1200, 800);
  circleY = 0;
  circleX = 0;
  lineX = 0;
  lineY = 0;
}
void draw(){
   background(51);
   fill(102);
   stroke(255);
   ellipse(circleX, circleY, 32, 32);
   line(lineX, lineY, circleX, circleY);
   line(width, 0, circleX, circleY);
   line(0, height, circleX, circleY);
   line(width, height, circleX, circleY);
   circleY = circleY += ySpeed;
   circleX = circleX += xSpeed;
   if(circleY > height || circleY < 0){
        ySpeed = ySpeed * -1;
   }
   if(circleX > width || circleX < 0){
        xSpeed = xSpeed * -1;
   }
}
