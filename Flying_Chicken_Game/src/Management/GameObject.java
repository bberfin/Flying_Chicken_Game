
package Management;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Berfin
 */
public abstract class GameObject 
{
  protected int x,y;              //location  
  protected float velX=0,velY=1; //velocity(if it's 3 ---> 3 pixels a second)
  protected ObjectId id;         // every object has id
  protected SpriteSheet spriteSheet;
  
  public GameObject(int x, int y,ObjectId id, SpriteSheet spriteSheet)
  {  
      this.x=x;
      this.y=y;
      this.id=id;
      this.spriteSheet = spriteSheet;
   
  }      
    // inheritance :  
    // for any other class that we want to also be able
    // to input our different x and y positions 
   
  
  public abstract void tick(); 
  public abstract void render(Graphics g); 
  public abstract Rectangle getBounds();
  
  //tick()  : every object needs to update
  //render(): every object needs to draw and appear sth
  //Rectangle getBounds() : every object needs a rectangle get bounds,
  //so we can do collision detection  

  
  
  //**** getters and setters ****//
  ////////////////////////////////
  public int getX(){
      return x;
  }
  public int getY(){
      return y;
  }  
  public float getVelX(){
      return velX;
  }
  public float getVelY(){
      return velY;
  }
  public ObjectId getId(){
      return id;
  }  
  public void setX(int x){
      this.x=x;
  }
  public void setY(int y){
      this.y=y;
  }
  public void setVelX(float velX){
      this.velX=velX;
  }
  public void setVelY(float velY){
      this.velY=velY;
  }
  public void setId(ObjectId id){
      this.id=id;  
  }    
  /////////////////////////////////
  ////////////////////////////////  
  
}
