
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
public class TargetBig extends GameObject{

    private BufferedImage target_image;
    private BufferedImage targetBig;    
    private Handler handler;


    public TargetBig(int x, int y, ObjectId id,Handler handler, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        this.handler=handler;
        
        
            BufferedImageLoader loader=new BufferedImageLoader();        
        targetBig=loader.loadImage("/targetBig.png");    
       // target_image=spriteSheet.grabImage(6, 2, 32, 32);

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
                if(getBounds().intersects(tempObject.getBounds()))
                {
                   x += x*(-1)*5;
                   y += y*(-1)*5;
                }
            }
 
            if(tempObject.getId() == ObjectId.Target)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                   x += x*(-1)*5;
                   y += y*(-1)*5;
                }
            }
          
            
             if(tempObject.getId() == ObjectId.Cat)
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                   x += x*(-1)*5;
                   y += y*(-1)*5;
                }
            }
                     
            
            
            if(tempObject.getId() == ObjectId.Egg)   
            {
             if(getBounds().intersects(tempObject.getBounds()))
             {
             Target.score += 30;
             Target.total_score+=30;
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
                g.drawImage(targetBig, x, y,100,83, null);

    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 100, 83);
    }

}
