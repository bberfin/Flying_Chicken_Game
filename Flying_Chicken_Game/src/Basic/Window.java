
package Basic;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Berfin
 */


// creating a JFrame by using paramaters from Game.java

public class Window 
{
    public Window(int width,int height, String title, Game game)
    {
       JFrame frame= new JFrame(title);
       frame.setPreferredSize(new Dimension(width,height));
       frame.setMaximumSize(new Dimension(width,height));      
       frame.setMinimumSize(new Dimension(width,height)); 
       
       
       // add "extends Canvas implements Runnable" to "Game.java" to run that
       frame.add(game); 
       frame.setResizable(false);  // not resizable the frame
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack(); 
       frame.setLocationRelativeTo(null);
       frame.setVisible(true); //can be seen on screen

    }
    
}
