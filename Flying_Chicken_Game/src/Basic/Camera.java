
package Basic;

import Management.GameObject;

/**
 *
 * @author Berfin
 */
public class Camera 
{
    private float x, y; //positions of our camera
    
    //constructor
    public Camera(float x, float y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void tick(GameObject object)
    {

       y+=((object.getY()-y)-100)*0.05f;
      
      if(x <= 0 )
          x=0;
      if(x >= 640 )
          x=640;
      if(y <=0 )
         y=0;     
    }
    
    //**** getters and setters ****//
    public float getX()
    {
        return x;
    }
    public void setX(float x)
    {
        this.x=x;
    }    
    public float getY()
    {
        return y;
    }
    public void setY(float y)
    {
        this.y=y;
    }    
    ///////////////////////////////
    
    
    
    
}
