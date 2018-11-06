import peasy.*;
import ddf.minim.analysis.*;
import ddf.minim.*;


int cols, rows;
int scl = 20;
int w = 800;
int h = 600;
float flying = 0;
float[][] terrain;
float value;

PeasyCam camera;

Minim minim;
AudioPlayer song;
FFT fft;

void setup() {
  size(800, 600, P3D);
  cols = w / scl;
  rows = h/ scl;
  terrain = new float[cols][rows];
  camera = new PeasyCam(this, 500);
  minim = new Minim(this);
  song = minim.loadFile("astonmartin.mp3", 1024); //1024 is a power-of-two buffer size. (good size?)
  // create an FFT object that has a time-domain buffer 
  // the same size as jingle's sample buffer
  // note that this needs to be a power of two 
  // and that it means the size of the spectrum will be half as large.
  song.loop();
  fft = new FFT(song.bufferSize(), song.sampleRate());
  colorMode(HSB);
}

void draw() {
  lights();
  fft.forward(song.mix);
  
  
  //flying -= 0.005;
  //float yoff = flying;
  //for (int y = 0; y < rows; y++) 
  //{
  //  float xoff = -flying;
  //  for (int x = 0; x < cols; x++) 
  //  {
  //     terrain[x][y] = map(noise(xoff, yoff), 0, 1, 0, 255);
  //     xoff += 0.05;
  //  }
  //  yoff += 0.05;
  //}
  
  translate(-width/2, -height/2);
  background(255);
  noFill();
  for (int y = 0; y < rows-1; y++) {
    for (int x = 0; x < cols; x++) {
      for(int i = 0; i < fft.specSize();i++){
          //float hu = map(x, 0, song., 0, 255);
          //fill(hu, 255, 255);
          rect(x*scl, y*scl, scl, scl);
      }
    }
  }
  print(frameRate+"\n");
}

void analyzeMusic(AudioPlayer song){
    
}
