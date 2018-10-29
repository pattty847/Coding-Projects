import peasy.*;
import ddf.minim.*;


int cols, rows;
int scl = 20;
int w = 2000;
int h = 1600;
float flying = 0;
float[][] terrain;
float value;

PeasyCam camera;

Minim minim;
AudioPlayer song;

void setup() {
  size(1200, 800, P3D);
  cols = w / scl;
  rows = h/ scl;
  terrain = new float[cols][rows];
  camera = new PeasyCam(this, 500);
  colorMode(HSB);
}

void draw() {
  flying -= 0.005;
  float yoff = flying;
  for (int y = 0; y < rows; y++) 
  {
    float xoff = -flying;
    for (int x = 0; x < cols; x++) 
    {
      terrain[x][y] = map(noise(xoff, yoff), 0, 1, 0, 255);
      xoff += 0.05;
    }
    yoff += 0.05;
  }
  translate(-width, -height);
  background(0);
  stroke(255);
  noFill();
  for (int y = 0; y < rows-1; y++) {
    beginShape(TRIANGLE_STRIP);
    for (int x = 0; x < cols; x++) {
      float hu = map(y, 0 , terrain[x][y], 0, 255);
      fill(hu, 255, 255);
      vertex(x*scl, y*scl, terrain[x][y]);
      vertex(x*scl, (y+1)*scl, terrain[x][y+1]);
    }
    endShape();
  }
  print(frameRate+"\n");
}
