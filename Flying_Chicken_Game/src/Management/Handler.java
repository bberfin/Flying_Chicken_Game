
package Management;

import Basic.Camera;
import Basic.Game;
import static Basic.Game.level;
import static Basic.Game.level2;
import static Basic.Game.level3;
import Objects.Target;
import java.awt.Graphics;
import java.util.LinkedList;


/**
 *
 * @author Berfin
 */
public class Handler 
{
    

    private Camera cam;
    private Game game;
    private SpriteSheet spriteSheet;
    private boolean up=false;
    private boolean down=false;
    private boolean right=false;
    private boolean left=false;
    
    
    
    public Handler(Camera cam,Game game,SpriteSheet spriteSheet){
        this.cam=cam;
        this.game=game;
        this.spriteSheet=spriteSheet;
    }
    
    
   
    //the list is an array of objects
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick()
    {
      for(int i=0; i<object.size(); i++ ) 
      {
          GameObject tempObject=object.get(i);//creating a temporary game object
          tempObject.tick();
      }
    }
    
    public void render(Graphics g){
      for(int i=0; i<object.size(); i++ ) 
      {
          GameObject tempObject=object.get(i);//creating a temporary game object
          tempObject.render(g);
      }        
    }
    
   //also want to be able to add and remove objects from the linked list  
    public void addObject(GameObject temObject)
    {
        object.add(temObject);
    }
    public void removeObject(GameObject temObject)
    {
        object.remove(temObject);
    }
    
   

    
     public void switchLevel(){
         setDown(false);
         setLeft(false);
         setRight(false);
         setUp(false);
        Game.GLEVEL=1; 
        Game.counter =0;
         Target.total_score=0;
        clearLevel();
        cam.setY(0);
        game.heart=10;
        Target.score=0;
        game.loadLevel(level);
       // System.out.println("playing level 1");             
    }    
    
      
    public void switchLevel1(){
         setDown(false);
         setLeft(false);
         setRight(false);
         setUp(false);
       Game.GLEVEL++;       
        clearLevel();
        cam.setY(0);
        game.heart=10;
        Target.score=0;
        game.loadLevel(level2);
       // System.out.println("playing level 2");   

    }   
    
     public void switchLevel2(){
         
         setDown(false);
         setLeft(false);
         setRight(false);
         setUp(false);         
         Game.GLEVEL++; 
        clearLevel();
        cam.setY(0);
        game.heart=10;
        Target.score=0;
        game.loadLevel(level3);
       // System.out.println("playing level 3");         

       
    }
       

    public void clearLevel()
    {
        object.clear();
    }    
    
    
    //**** getters and setters ****//
    ////////////////////////////////
    public boolean isUp(){
        return up;
    }
    public void setUp(boolean up){
        this.left=false;
        this.right=false;        
        this.up=up;
    }
    public boolean isDown(){
        return down;
    }
    public void setDown(boolean down){
        this.left=false;
        this.right=false;        
        this.down=down;
    }
    public boolean isRight(){
        return right;
    }
    public void setRight(boolean right){
        this.right=right;
    }
    public boolean isLeft(){
        return left;
    }
    public void setLeft(boolean left){      
        this.left=left;
    } 
    /////////////////////////////////
    ////////////////////////////////   
    
}
