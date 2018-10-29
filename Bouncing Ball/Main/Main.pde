int bSize = 50;
Ball[] b = new Ball[bSize];
void setup() {
  size(1200, 800);
  for(int i=0;i<bSize;i++){
     b[i] = new Ball();
  }
}

void draw(){
   background(51);
   fill(200);
   stroke(255);
   for(int i=0;i<bSize;i++){
     b[i].initBouncing();
     b[i].drawBall();
   }
}
