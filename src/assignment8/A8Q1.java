package assignment8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author ahmaa1808
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // create a variable for the ears integer
    int ears = 155;
    // add a direction- initialize a variable
    int earsDirection = 1;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    // create the golden colour of pikachu
    Color golden = new Color(252, 215, 0);
     
      
      
      

    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!

        Random rand = new Random();
        int sieze = rand.nextInt(10) + 1;
        switch (sieze) {
            case 1:
                g.setColor(Color.CYAN);
                break;
            case 2:
                g.setColor(Color.YELLOW);
                break;
            case 3:
                g.setColor(Color.RED);
                break;
            case 4:
                g.setColor(Color.BLUE);
                break;
            case 5:
                g.setColor(Color.PINK);
                break;
            case 6:
                g.setColor(Color.GREEN);
                break;
            case 7:
                g.setColor(Color.BLACK);
                break;
            case 8:
                g.setColor(Color.ORANGE);
                break;
            case 9:
                g.setColor(Color.MAGENTA);
                break;
            case 10:
                g.setColor(Color.WHITE);
                break;
            default:
                break;
        }
        g.fillRect(0, 0, WIDTH, HEIGHT);
//g.fillRect(0, 0, WIDTH, HEIGHT);
        // GAME DRAWING GOES HERE 
        // create face of a bear with an oval (golden colour)
        g.setColor(Color.GRAY);
        g.fillOval(199, 150, 350, 350);

        // ears
        g.fillOval(ears, 80, 150, 150);
        g.fillOval(ears + 295, 80, 150, 150);

        // create the eyes
        g.setColor(Color.WHITE);
        g.fillOval(250, 200, 100, 100);
        g.fillOval(400, 200, 100, 100);

        g.fillOval(ears + 25, 100, 100, 100);
        g.fillOval(ears + 320, 100, 100, 100);

        g.setColor(Color.black);
        g.fillOval(260, 210, 80, 80);
        g.fillOval(410, 210, 80, 80);

        g.fillOval(340, 320, 70, 50);

        g.setColor(Color.WHITE);
        g.fillOval(290, 210, 40, 40);
        g.fillOval(440, 210, 40, 40);

        // draw smile 

        g.drawArc(300, 320, 150, 150, 180, 180);
        g.fillArc(300, 320, 150, 150, 180, 180);

        // create the nose 




        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            //move the ears side to side
            //right
            if (ears <= 105){
                // 
                earsDirection = 1;
                
                
                
            }
            //moving ears to the left
            if (ears >= 205){
                earsDirection= -1;
                
                
            }
            //changing the ears variable number buy adding it to earsDirection
             ears = earsDirection + ears;
              
    




            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
