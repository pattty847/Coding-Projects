import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyListener;


/**
 * This is the main heart beat for the game engine. It contains multiple comments so I can see where my knowledge progresses as time goes on.
 * The file must extend Canvas in order to draw from the Window class and implement Runnable for the thread we create in start().
 * 
 * Sequence of events:
 *  1: Game() is called from main() at the bottom
 *  2: New Window() is created with the size and title and handler is initialized.
 *  3: Go to Window class file for step 4.
 *  9: Thread is started with start() and running is set to true.
 * 10: In the run() method 'running' sets the while loop, which sets the counter for frames. 'running also sets of if statement'.
 * 11: In the render() method 'running' sets the graphics up which draws background color, etc.
 */


public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private boolean running = false;
    public static final int W = 800, H = 800;

    private Thread thread;
    private Graphics graf;
    private Handler handler;


    // Adds a new object to the handler, which displays it on the screen
    // Handler(x, y, ID); --- Add the ID to the class file ID.
    public Game(){
        handler = new Handler();
        KeyHandler keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        new Window(W, H, "Game.", this);
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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public int getHeight() {
    	return H;
    }
    public int getWidth() {
    	return W;
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
        handler.tick();
    }

    /**
     * Render sets up the background graphics, and fills them with each GameObject. 
     */

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bs.getDrawGraphics();
        handler.render(graphics, this);
        graphics.dispose();;
        bs.show();
    }

    public void dispose(){

    }

    public static void main(String[] args)
    {
        new Game();
    }
}