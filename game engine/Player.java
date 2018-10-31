import java.awt.Color;
import java.awt.Graphics;

import com.sun.org.apache.bcel.internal.generic.GotoInstruction;

public class Player extends GameObject{
//-:Constructor must be made with classes that extend unimplemented abstract functions
//-:and the super();
    public Player(int x, int y, ID id)
    {
        super(x, y, id);
        velX = 1;
        velY = 1;
    }

    public void tick(){
        x += velX;
        y += velY;
        
    }

    /**
     *  Set the color and render an image with the x and y variables for player. Go to Game file.
     */

    public void render(Graphics g){
        drawBox(g);
    }

    public void drawBox(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, 50, 50);
    }

    
}