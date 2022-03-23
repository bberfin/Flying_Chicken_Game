
package Objects;

import Management.GameObject;
import Management.ObjectId;
import Management.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Berfin
 */
public class Box extends GameObject
{

    public Box(int x, int y, ObjectId id, SpriteSheet spriteSheet){ // x,y : coordinates; id: object id
        super(x, y, id, spriteSheet); 
        
        velX=0;
        velY=-1;
    }

    @Override
    public void tick() 
    {
        x+=velX;
        y+=velY;
    }

    @Override
    public void render(Graphics g) 
    {
        g.setColor(Color.RED);
        g.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() 
    {
        return null;
    }
    
    
}
