import java.awt.Graphics;

public abstract class GameObject{

//-:Anything that extends this class can use protected variables/methods/functions.
    protected int x, y; 
    protected ID id;
    protected int velX, velY;

//-:We pass GameObject these vars which set the protected
//-:vars above. They are accessable because above.
//-:These make up each game object and their qualities.
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

//-:These are unimplemented methods which can be accessed in other classes
//-:and created there, too. You must the vars to GameObject(int x, int y, ID id) and super(x, y, id)
    public abstract void tick(); 
    public abstract void render(Graphics g);

//-:Getters and setters use able for each GameObject that extends this class file. Just use setX(x), setY(y), etc...
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public int getX(){ return x; }
    public int getY(){ return y; }
    public void setID(ID id){ this.id = id; }
    public ID getID(){ return id; }
    public void setVelX(int velX){ this.velX = velX; }
    public void setVelY(int velY){ this.velY = velY; }
    public int getVelY(){ return velY; }
    public int getVelX(){ return velX; }
}