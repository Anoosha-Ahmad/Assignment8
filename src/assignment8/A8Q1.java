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

    // Height and Width of the game
    static final int WIDTH = 780;
    static final int HEIGHT = 600;
    
    // create a variable for the ears integer 
    // to be used as an input for the coordinate of the ears --> used to move the ears
        int ears = 155;  
        
    // add a direction- initialize a variable for the movement
    int earsDirection = 1;
    
    // create a variable for the eyes integer
    // create a variable for the eyes integer
    // to be used as an input for the coordinate of the ears --> used to move the ears
    int eyes = 290;
    
     // add a direction- initialize a variable for the movement
    int eyesDirection = 1;
    
    // intilize the  variable for the glitch to be used 
    int glitch = 0;
    int glitch2 = 0;
    
    
 
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
   
    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        // create and initialize the variable "random" to create a seizure (exploring with the drawing functions)
        Random rand = new Random();
         int sieze = rand.nextInt(10) + 1;
        switch (sieze) {
            case 1:
                g.setColor(Color.CYAN);
                break;
            case 2:
                g.setColor(Color.YELLOW);
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
            case 9:
                g.setColor(Color.MAGENTA);
                break;
            default:
                break;
        }
        g.fillRect(0, 0, WIDTH, HEIGHT);
//g.fillRect(0, 0, WIDTH, HEIGHT);
        if(eyes <= 270){
            glitch = -100;
            glitch2 = 100;
        }
        else{
            glitch = 0;
            glitch2 = 0;
        }
        // GAME DRAWING GOES HERE 
        // create face of a bear with an oval (gray colour)
        g.setColor(Color.GRAY);
        g.fillOval(glitch + 199, glitch + 150, 350, 350);

        // ears
        g.fillOval(glitch + ears, glitch + 80, 150, 150);
        g.fillOval(glitch2 + ears + 295, glitch2 +80, 150, 150);

        // create the eyes
        g.setColor(Color.WHITE);
        g.fillOval(glitch + 250, glitch + 200, 100, 100);
        g.fillOval(glitch2 + 400, glitch2 + 200, 100, 100);

        g.fillOval(glitch + ears + 25, glitch + 100, 100, 100);
        g.fillOval(glitch2 + ears + 320, glitch2 + 100, 100, 100);

        g.setColor(Color.black);
        g.fillOval(glitch + 260, glitch + 210, 80, 80);
        g.fillOval(glitch2 + 410, glitch2 + 210, 80, 80);

        g.fillOval(glitch + 340 + glitch2, glitch + 320 + glitch2, 70, 50);

        g.setColor(Color.WHITE);
        //when eyes are moved from their original spot, change the colour of eyes to red so it looks like a devil
        if(eyes <= 270)
            g.setColor(Color.RED);
        g.fillOval(glitch + eyes, glitch + 210, 40, 40);
        g.fillOval(glitch2 + eyes + 150, glitch2 + 210, 40, 40);

        // draw smile 
        g.setColor(Color.WHITE);

        g.drawArc(glitch + 300 + glitch, glitch + 320+ glitch, 150, 150, 180, 180);
        g.fillArc(glitch + 300+ glitch, glitch + 320+ glitch, 150, 150, 180, 180);

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
             
             if (eyes <= 260){
                 eyesDirection = 1;
             }
//          
             if(eyes >= 300){
                 eyesDirection = -1;
             }
               eyes = eyesDirection*2 + eyes;
             //eyes 
             
              
    




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
