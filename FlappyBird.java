package FlappyBird;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FlappyBird implements ActionListener, KeyListener {

    public static final int FPS = 60, WIDTH = 640, HEIGHT = 480;

    private Bird bird;
    private JFrame frame;
    private JPanel panel;
    private ArrayList<Rectangle> rects;
    private int time, scroll;
    private Timer t;

    private boolean paused;

    public void go() {
         frame = new JFrame("Flappy Bird");
        bird = new Bird();
        rects = new ArrayList<Rectangle>();
        panel = new GamePanel(this, bird, rects);
        frame.add(panel);
        
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        paused = true;
        
        t = new Timer(1000/FPS, this);
        t.start();
        

    }
    public static void main(String[] args) {
        new FlappyBird().go();
    }


    public int getScore() {
         return time;
        
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            bird.jump();
        }
        else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            paused = false;
        }
    }
    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }

    public boolean paused() {
        return paused;
    }


}
