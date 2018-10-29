import peasy.*;
PeasyCam cam;



void setup()
{
  size(500, 500);
  background(0);
  cam = new PeasyCam(this, 0, 0, 0, 50);
}
