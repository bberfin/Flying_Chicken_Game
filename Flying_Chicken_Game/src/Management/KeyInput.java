
package Management;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Berfin
 */
public class KeyInput extends KeyAdapter
{
    
    Handler handler;
    
   public KeyInput(Handler handler)
   {
      this.handler=handler; 
   }
    
    
   public void keyPressed(KeyEvent e)
   {
      int key=e.getKeyCode();
      for(int i=0; i<handler.object.size(); i++) //loop for all object
      {
          GameObject temObject = handler.object.get(i);
          if(temObject.getId()==ObjectId.Player) // for player
          {
              //if(key==KeyEvent.VK_UP)
                 // handler.setUp(true);
             // if(key==KeyEvent.VK_DOWN)
                 // handler.setDown(true);
              if(key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_D)
                  handler.setRight(true);
              if(key==KeyEvent.VK_LEFT || key==KeyEvent.VK_A)
                  handler.setLeft(true);
              
          }
      }
   }
   
   public void keyReleased(KeyEvent e)
   {
      int key=e.getKeyCode();
      for(int i=0; i<handler.object.size(); i++) //loop for all object
      {
          GameObject temObject = handler.object.get(i);
          if(temObject.getId()==ObjectId.Player) // for player
          {
              if(key==KeyEvent.VK_UP)
                  handler.setUp(false);
              if(key==KeyEvent.VK_DOWN)
                  handler.setDown(false);
              if(key==KeyEvent.VK_RIGHT || key==KeyEvent.VK_D){
                  handler.setRight(false);                 
              }

              if(key==KeyEvent.VK_LEFT || key==KeyEvent.VK_A)
                  handler.setLeft(false);            
          } 
      }  
   }
   
}
