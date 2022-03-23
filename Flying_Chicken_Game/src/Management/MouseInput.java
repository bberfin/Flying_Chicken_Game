
package Management;

import Basic.Camera;
import Basic.Game;
import Basic.Game.BEGINNING;
import Objects.Egg;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Berfin
 */
public class MouseInput extends MouseAdapter
{
    private Handler handler;
    private Camera camera;
    private Game game;
    private SpriteSheet spriteSheet; 
    
     public  MouseInput(Handler handler, Camera camera, Game game, SpriteSheet spriteSheet) {
        this.handler=handler;
        this.camera=camera;
        this.game=game;
        this.spriteSheet=spriteSheet;
    } 

     
    public void mousePressed(MouseEvent e)
    {
       int mouseX = (int)(e.getX() + camera.getX()); 
       int mouseY = (int)(e.getY() + camera.getY());
       
       if(game.beginning==BEGINNING.GAME){
           
       for(int i=0; i<handler.object.size(); i++)
       {
           GameObject tempObject=handler.object.get(i);
           if(tempObject.getId()==ObjectId.Player)
           {
               handler.addObject(new Egg(
                       tempObject.getX()+16, tempObject.getY()+24,
                       ObjectId.Egg,handler, mouseX, mouseY,spriteSheet));
           }
       }           
       
       }


    }
    
    
}
