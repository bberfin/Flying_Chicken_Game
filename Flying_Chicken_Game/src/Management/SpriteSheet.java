
package Management;

import java.awt.image.BufferedImage;

/**
 *
 * @author Berfin
 */
public class SpriteSheet 
{
    private BufferedImage image;
    
    
//divides the image into equal sizes   
    public SpriteSheet(BufferedImage image) 
    {
      this.image=image;  
    }
    
    
//going to return an image that we need    
    public BufferedImage grabImage(int col, int row,int width, int height)
    {
      return image.getSubimage((col*32)-32, (row*32)-32, width, height);
    }
    
    
}
