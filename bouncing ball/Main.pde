int bSize = 0;
Ball[] b = new Ball[100];
void setup() {
  size(1200, 800, P2D);
  for(int i=0;i<b.length;i++){
     b[i] = new Ball();
  }
}
void mouseClicked(){
  bSize = bSize + 1;
}


void draw(){
   background(51);
   fill(200);
   stroke(255);
   for(int i=0;i<bSize;i++){
     b[i].initBouncing();
     b[i].drawBall();
     b[i].drawLTF();
   }
}
