
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



public class Egg extends GameObject
{
    
    
   private BufferedImage goldenEgg; 
    private Handler handler ; 
    public Egg(int x,int y,ObjectId id,Handler handler,int mouseX,int mouseY, SpriteSheet spriteSheet)
    {
        super(x, y, id,spriteSheet);
        this.handler=handler;
        
        BufferedImageLoader loader=new BufferedImageLoader();         
        goldenEgg=loader.loadImage("/goldenEgg.png");
        
        velX = (mouseX - x)/10;  //speed
        velY = (mouseY - y)/10;        
    }


    @Override
    public void tick()
    {
        x += velX;
        y += velY;
        
        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject=handler.object.get(i);
            if(tempObject.getId()==ObjectId.Block )
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    handler.removeObject(this);
                }
            }
            if(tempObject.getId()==ObjectId.Cat )
            {
                if(getBounds().intersects(tempObject.getBounds()))
                {
                    handler.removeObject(this);
                }
            }            
        }       
        
    }

    @Override
    public void render(Graphics g)
    {
              g.drawImage(goldenEgg, x, y,32,32,null);                
    }


    

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
 
}
