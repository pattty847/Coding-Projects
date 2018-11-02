import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;

public class Ball{
    int circleY;
    int circleX;
    float lineX;
    float lineY;
    int ySpeed = 1;
    int xSpeed = 1;
    int size;
    
    Ball(int x, int y, int s){
        this.circleX = x;
        this.circleY = y;
        this.size = s;
    }

    public void drawBall(Graphics g){
        g.setColor(Color.CYAN);
        g.drawOval(circleX, circleY, size, size);
    }

    public void initMoving(){
        circleX = circleX += xSpeed;
        circleY = circleY += ySpeed;
        if(circleY > 800 || circleY < 0){
            ySpeed = ySpeed * -1;
        }
        if(circleX > 800 || circleX < 0){
            xSpeed = xSpeed * -1;
        }
    }
}