/**
 * Functions. 
 * 
 * The drawTarget() function makes it easy to draw many distinct targets. 
 * Each call to drawTarget() specifies the position, size, and number of 
 * rings for each target. 
 */
import peasy.*;
import java.awt.Rectangle;

PeasyCam camera;
Rectangle rec;
GameFunction gf;
int w = 1200;
int h = 1200;
int scl = 60;
int cols, rows;
void setup() {
  size(1200, 1200, P2D);
  cols = w/scl;
  rows = h/scl;
  //camera = new PeasyCam(this, 500);
  gf = new GameFunction();
}


void draw() {
  background(0);
  stroke(255);
  gf.setup();
}
