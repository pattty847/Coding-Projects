import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Window extends Canvas{
    private Graphics g;


    public Window(){
        JFrame frame = new JFrame("Bouncing Ball"); //Initialies title
        Canvas canvas = new Canvas(); //Creates a new canvas using Ball_Main() because it extends Cavas
        canvas.setSize(800, 800);
        canvas.setBackground(Color.darkGray);
        frame.setResizable(false);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        canvas.createBufferStrategy(2);
    }

    public void update(){
        
    }
}