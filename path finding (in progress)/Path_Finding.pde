import java.awt.Rectangle;
int cols, rows;
int scl = 60;
int w = 1260;
int h = 1200;
Rectangle rec;

void setup(){
  size(1200, 1200, P2D);
  cols = w/scl;
  rows = h/scl;
}

void draw(){
  background(0);
  stroke(255);
  noFill();
  int mousX = mouseX;
  int mousY = mouseY;
   for(int y = 0; y < rows;y++){
      for(int x = 0; x < cols;x++){
          rec = new Rectangle(x*scl, y*scl, scl, scl);
          rect(rec.x, rec.y, scl, scl);
          if(rec.contains(mouseX-scl, mouseY)){
             fill(255);
          }else{
             noFill();
          }
      }
   }
}
