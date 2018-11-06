import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {
	JFrame frame;
	public Window(String title) {
		frame = new JFrame(title);
        frame.setSize(new Dimension(600, 400)); 
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
	}
	
	public void buildLayout() {
		
	}

}
