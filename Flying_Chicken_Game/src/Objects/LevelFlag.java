/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

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
public class LevelFlag extends GameObject{
        private Handler handler;  //cuz we're going to need collision detection
     private BufferedImage block_image;   

    public LevelFlag(int x, int y, ObjectId id, SpriteSheet spriteSheet) {
        super(x, y, id, spriteSheet);
        block_image=spriteSheet.grabImage(4, 2, 32, 32);       
    }

    @Override
    public void tick() {

    }  



    @Override
    public void render(Graphics g) {

       g.drawImage(block_image, x, y,32,800, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
    

}
