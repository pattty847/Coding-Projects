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
   for(int i=0;i<bSize;i++){
     PVector gravity = new PVector(0, 0.1 * b[i].mass);
     b[i].initBouncing();
     b[i].applyForce(gravity);
     b[i].update();
     b[i].display();
     b[i].drawLTF();
   }
}
