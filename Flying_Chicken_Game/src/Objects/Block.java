
package Objects;


import Management.GameObject;
import Management.ObjectId;
import Management.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Berfin
 */
public class Block extends GameObject
{

    private BufferedImage block_image;
  
    
    public Block(int x, int y, ObjectId id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);        
        block_image=spriteSheet.grabImage(4, 2, 32, 32);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(block_image, x, y,32,32, null);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
}
