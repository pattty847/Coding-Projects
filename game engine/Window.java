import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Canvas;

public class Window extends Canvas{

    private static final long serialVersionUID = 1L;

    public Window(int w, int h, String t, Game game) {
        JFrame frame = new JFrame(t);

        frame.setPreferredSize(new Dimension(w, h));
        frame.setMaximumSize(new Dimension(w, h));
        frame.setMinimumSize(new Dimension(w, h));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}