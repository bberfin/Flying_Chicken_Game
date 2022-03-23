
package Objects;

import Basic.BufferedImageLoader;
import Basic.Camera;
import Basic.Game;
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
public class Chicken  extends GameObject
{
    
    Handler handler;
    Game game;
    private Camera cam;
    
    private BufferedImage chicken_image;
    private BufferedImage chicken;
    
    public Chicken(int x, int y, ObjectId id,Handler handler, Game game,Camera cam, SpriteSheet spriteSheet) {
        super(x, y, id,spriteSheet);
        
        this.handler=handler;
        this.game=game;
        this.cam=cam;
        BufferedImageLoader loader=new BufferedImageLoader();        
        chicken_image=loader.loadImage("/chicken.png");
        chicken=loader.loadImage("/chicken.png");        
    }

    @Override
    public void tick() 
    {
        if(Game.GLEVEL==1){
       x+=velX; 
       y+=velY+4;         
        }
        if(Game.GLEVEL==2){
       x+=velX; 
       //y+=2*velY+4; 
              y+=velY+7;
        }
        if(Game.GLEVEL==3){
       x+=velX; 
      // y+=2*velY+5; 
              y+=velY+10;
        }
        
        
       collision();
       
       ////////**** movement ****////////
       
       // if(handler.isUp())velY=-3;
       //else if(!handler.isDown())velY=1;
           
       if(handler.isDown())velY=3;           
       else if(!handler.isUp())velY=2; 
                 
       if(handler.isRight())velX=5;          
       else if(!handler.isLeft())velX=0;
               
       if(handler.isLeft())velX=-5;          
       else if(!handler.isRight())velX=0;
      ///////////////////////////////////  
      
    }
    
    private void collision()
    {
        try
        {
      for(int i=0; i<handler.object.size(); i++)
      {
          GameObject tempObject= handler.object.get(i);
          
 
          
          
          if(tempObject.getId()==ObjectId.Block)
          {
              if(getBounds().intersects(tempObject.getBounds()))
              {
                  x+=velX*-1;
                  y+=velY*-1;
              }
          }
 
          if(tempObject.getId()==ObjectId.Cat)
          {
              if(getBounds().intersects(tempObject.getBounds()))
              {
                  game.heart -= 1;
                  handler.removeObject(tempObject);
              }
          }

          if(tempObject.getId()==ObjectId.CatBig)
          {
              if(getBounds().intersects(tempObject.getBounds()))
              {
                  game.heart -= 3;
                  handler.removeObject(tempObject);
              }
          }
          
             if(tempObject.getId() == ObjectId.LevelFlag)   
            {
             if(getBoundsBig().intersects(tempObject.getBounds()))
             {

                 if(Game.GLEVEL==1){
                 handler.switchLevel1(); 
                 //System.out.println("switch 1 , level : "+Game.GLEVEL);
                 break;
                 }

                 else if(Game.GLEVEL==2){
                 handler.switchLevel2();      
                 //System.out.println("switch 2 , level "+Game.GLEVEL); 
                 break;
                 }
                 
                 else{
                   game.GLEVEL=4;

                 }
             }
            }         
         
          
      }            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    

    @Override
    public void render(Graphics g) 
    {
        
        g.drawImage(chicken, x, y,60,75,game );

    }

    @Override
    public Rectangle getBounds()
    {
       return new Rectangle(x, y, 65, 80); 
    }
    
     public Rectangle getBoundsBig()
    {
       return new Rectangle(x-16, y-16, 81, 96); 
    }   
}
