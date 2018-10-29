/**
 * Functions. 
 * 
 * The drawTarget() function makes it easy to draw many distinct targets. 
 * Each call to drawTarget() specifies the position, size, and number of 
 * rings for each target. 
 */
import peasy.*;
PeasyCam camera;
int w = 2000;
int h = 1600;
int scl = 20;
int cols, rows;
void setup() {
  size(1200, 800, P3D);
  cols = w/scl;
  rows = h/scl;
  camera = new PeasyCam(this, 500);
}
void draw() {
  lights();
  background(0);
  stroke(255);
  noFill();
  translate(width/2, height/2);
  rotateX(PI/3);
  translate(-w/2, -h/2);
  for (int y = 0; y < rows-1; y++) {
    beginShape(TRIANGLE_STRIP);
    for (int x = 0; x < cols; x++) {
      fill(color(66, 128, 244));
      vertex(x*scl, y*scl);
      vertex(x*scl, (y+1)*scl);
    }
    endShape();
    rotateX(radians(frameRate % 360));
    
  }
}
