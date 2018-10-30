public class Game  implements Runnable{
    private Thread tread;
    private boolean running = false;
    private final double UPDATA_CAP = 1.0/60.0;
    Window w;

    public void start(){
        w = new Window();
        Thread thread = new Thread(this); //New thread
        thread.run(); //Main thread .run();
    }

    public void stop(){

    }

    public void run(){
        running = true;
        double firstTime = 0;
        boolean render = false;
        double lastTime = System.nanoTime()/ 1000000000.0;
        double passedTime = 0;
        double unprocessTime = 0;
        int frames = 0;
        double frameTime = 0;
        int fps = 0;
        while(running){
            render = false;
            firstTime = System.nanoTime() / 1000000000.0; //Stores the miliseconds of the time NOW
            passedTime = firstTime - lastTime; //The passedTime is calculated by subtracting ^ from the time it is NOW
            lastTime = firstTime; //Saves initial time to be recaluclated 
            unprocessTime += passedTime; //Counts the passed time
            frameTime += passedTime;
            while(unprocessTime >= UPDATA_CAP){
                unprocessTime -= UPDATA_CAP;
                render = true;
                /* 
                * Where the game will be updated
                */
                

                if(frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: "+fps);
                }
            }
            if(render){
                frames++;
                w.update();
            }else{
                try{
                    tread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    public void dispose(){

    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}