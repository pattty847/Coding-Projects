import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Color;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;

    private Thread thread;
    private boolean running = false;
    private final double UPDATA_CAP = 1.0/60.0;
    static Graphics graf;
    public static final int W = 800, H = 800;

    public Game(){
        new Window(W, H, "Nipples", this);
    }


    public synchronized void start(){
        Thread thread = new Thread(this); //New thread
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception c){
            e.printStackTrace();
        }
    }

    public void run()
    {
        long lastTime = System.nanoTime();
        double amountTicks = 60.0;
        double ns = 1000000000/amountTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta +=(now-lastTime)/ns;
            lastTime = now;
            while(delta>=1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: "+frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics graf = bs.getDrawGraphics();

        graf.setColor(Color.DARK_GRAY);
        graf.fillRect(0, 0, W, H);

        graf.dispose();;
        bs.show();
    }

    public void dispose(){

    }

    public static void main(String[] args)
    {
        new Game();
    }
}