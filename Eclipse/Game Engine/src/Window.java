import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Canvas;

public class Window extends Canvas{

    /**
     *  4: The JFrame is created
     *  5: Size min, max, close op, resizeable...
     *  6: Frame.add(game) will add the current game to the frame.
     *  7: The game.start() method is initiated.
     *  8: Go to Game file for step 9.
     */

    private static final long serialVersionUID = 1L;

    public Window(String t, Game game) {
        JFrame frame = new JFrame(t);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
    
    
}