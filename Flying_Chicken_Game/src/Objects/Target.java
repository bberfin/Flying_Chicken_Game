
package Objects;

import Basic.BufferedImageLoader;
import Management.GameObject;
import Management.Handler;
import Management.ObjectId;
import Management.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Berfin
 */
public class Target extends GameObject
{

    private BufferedImage target_image;
    private BufferedImage target;
    private Handler handler;
    public static int score=0;
    public static int total_score=0;   


    public Target(int x, int y, ObjectId id,Handler handler, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.handler=handler;
        
        BufferedImageLoader loader=new BufferedImageLoader();        
        target=loader.loadImage("/target.png");
        target_image=spriteSheet.grabImage(6, 2, 32, 32);

    }

    @Override
    public void tick() 
    {
        try{
        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ObjectId.Block)
            {
                if(getBoundsBig().intersects(tempObject.getBounds()))
                {
                   x += x*(-1)*5;
                   y += y*(-1)*5;
                }
            }
            
            if(tempObject.getId() == ObjectId.Egg)   
            {
             if(getBounds().intersects(tempObject.getBounds()))
             {
             score += 10;
             total_score+=10;
             handler.removeObject(tempObject); 
             handler.removeObject(this);            
             
             }
            }

            
        } 

        }catch(Exception e)
        {
            e.getMessage();
        }
        
    }

    @Override
    public void render(Graphics g) 
    {
        
        g.drawImage(target, x, y,100,69, null);

    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 100, 69);
    }
    
     public Rectangle getBoundsBig()
    {
        return new Rectangle(x-16, y-16, 100, 69);
    }   
}
