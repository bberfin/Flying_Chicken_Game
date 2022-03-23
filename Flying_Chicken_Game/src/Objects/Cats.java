
package Objects;

import Basic.BufferedImageLoader;
import Management.GameObject;
import Management.Handler;
import Management.ObjectId;
import Management.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Berfin
 */
public class Cats extends GameObject 
{
    
    
    private BufferedImage cat_image;
    private BufferedImage cat;   
    private Handler handler;  //cuz we're going to need collision detection
    Random random = new Random();
    int choose = 0;


    public Cats(int x, int y, ObjectId id,Handler handler, SpriteSheet spriteSheet) {
        super(x, y, id,spriteSheet);
        this.handler=handler;

        BufferedImageLoader loader=new BufferedImageLoader();        
        cat=loader.loadImage("/cat.png");
        cat_image=spriteSheet.grabImage(4, 1, 32, 32);
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
            
        } 


        }catch(Exception e)
        {
            e.getMessage();
        }

        
    }

    @Override
    public void render(Graphics g) // what our cats look like
    {
        
        g.drawImage(cat, x, y,85,60,null);
        
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 95, 95);
    }
    
     public Rectangle getBoundsBig()
    {
        return new Rectangle(x-16, y-16, 95, 95);
    }   
    
}
