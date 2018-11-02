import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{
	char currentKey = (char) 0;

    public void keyPressed(KeyEvent e){
    	char key = e.getKeyChar();
		currentKey = key;
    }
    
    public void keyReleased(KeyEvent e) {
		currentKey = (char) 0;
	}
}