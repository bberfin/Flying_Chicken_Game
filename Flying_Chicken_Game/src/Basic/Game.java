
package Basic;

import static Basic.Game.beginning;
import Management.Handler;
import Management.KeyInput;
import Management.MouseInput;
import Management.MouseInputMenu;
import Management.ObjectId;
import Management.SpriteSheet;
import Objects.Block;
import Objects.Cats;
import Objects.CatsBig;
import Objects.Chicken;
import Objects.LevelFlag;
import Objects.Target;
import Objects.TargetBig;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 *
 * @author Berfin
 */
public class Game extends Canvas implements Runnable
{
           
    Random random = new Random();  
    public static boolean isRunning =false;    
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private SpriteSheet spriteSheet;
    public static BufferedImage level =null;
    public static BufferedImage level2 =null;    
    public static BufferedImage level3 =null;      
    private BufferedImage sprite_sheet =null;
    public int heart=10;    
    public static int GLEVEL=1;
    public static int counter=0;
    private BufferedImage background=null;    
    private Menu menu;   
    public static enum BEGINNING{ MENU,GAME,RESTART};
    public static BEGINNING beginning = BEGINNING.MENU;
    
    
    //constructor
    public Game()
    {
       new Window(640,864,"FLYING CHICKEN",this);
       
       start();
              
       camera=new Camera(0,0);         
       handler=new Handler(camera,this,spriteSheet);   
             
       BufferedImageLoader loader=new BufferedImageLoader();  
              
       if(GLEVEL==1)
       level=loader.loadImage("/level.png"); 
        if(GLEVEL==2)
       level=loader.loadImage("/level2.png");
        if(GLEVEL==3)
       level=loader.loadImage("/level3.png");
       
             
       level2=loader.loadImage("/level2.png");  
       level3=loader.loadImage("/level3.png");   
       
       background=loader.loadImage("/background.png");      
       sprite_sheet=loader.loadImage("/sprite_sheet.png");   
       //after loading the sprite_sheet!!!! 
       spriteSheet = new SpriteSheet(sprite_sheet);      
       
       camera=new Camera(0,0);         
       handler=new Handler(camera,this,spriteSheet); 

       this.addKeyListener(new KeyInput(handler));    
       

       menu =new Menu();
       
       this.addMouseListener(new MouseInputMenu(handler));   
       
       this.addMouseListener(new MouseInput(handler,camera,this,spriteSheet));       
       
       loadLevel(level); 
   
    }

    private void start() //to start the thread
    {
       isRunning=true;
       thread = new Thread(this); // this---> "run" method
       thread.start();
    }
    
    public void stop()  //to stop the thread
    {
        isRunning=false;
        try {
            thread.join();  //dead
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void gameOver(Graphics g)  
    {

        handler.clearLevel();
       
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,55));
        g.drawString("..GAME OVER..", 125, 250);
        g.setFont(new Font("Ink Free",Font.BOLD,35));
        g.drawString("Total Score : "+Target.total_score, 205, 350);   
         
        g.drawRect(200, 390, 250, 70);
        g.drawString("RESTART", 240, 430);
        
        g.drawRect(200, 490, 250, 70);        
        g.drawString("QUIT", 260, 530);   
              
         counter=9;        

       } 
   
     public void finish(Graphics g)  
    {
        handler.clearLevel();
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,55));
        g.drawString("..FINISH LINE..", 125, 250);
        g.setFont(new Font("Ink Free",Font.BOLD,35));
        g.drawString("Total Score : "+Target.total_score, 205, 350);        

        g.drawRect(200, 390, 250, 70);
        g.drawString("RESTART", 240, 430);
        
        g.drawRect(200, 490, 250, 70);        
        g.drawString("QUIT", 260, 530);   
              
         counter=9; 
        
        
    }   
    
    
    
    @Override
    public void run() 
    {
        //**** game loop of our program ****//
        //**********************************//
        this.requestFocus();
        long lastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns=1000000000/amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();

        int frames=60;
        
        while(isRunning){
            
            
                long now=System.nanoTime();  

            delta =(now-lastTime)*0.000000001f;

            if(delta>1.0/frames){
            lastTime=now;                
                tick();

            }
            render();
        }   
        stop();
        //***********************************//
        //**********************************//        
    }
    
  //update everything in our game 
  //this method gets updated 60 times a second
    public void tick()
    {
       //**** player tracking with camera ****//
        for(int i=0; i<handler.object.size(); i++)
        {
            if(handler.object.get(i).getId()==ObjectId.Player)
            {
                camera.tick(handler.object.get(i));
            }
        }
       if(beginning == BEGINNING.GAME  )
       handler.tick();
    }
    
  //render-serve the everything (block,images..) in our game
  //this method gets updated a couple thousand times a second
    public void render()
    {
     //buffer strategy : pre-loading frames behind the actual window 
     //when u see one frame being shown
     //it's already got two more behind it 
     //that's already loaded ready to show  
       BufferStrategy bs=this.getBufferStrategy();
       if(bs==null)
       {
           this.createBufferStrategy(3);
           return;
       }
       
     /////////////////////////////////////     
        Graphics g = bs.getDrawGraphics(); 
        Graphics2D g2d = (Graphics2D) g;
     //**** draw things to our game ****//
       // g.setColor(Color.CYAN);
        g.setColor(new Color(25,200,200));
        g.fillRect(0, 0, 640, 864);

      //Everything between cam A and cam B is getting translated        
       g2d.translate(-camera.getX(), -camera.getY()); //CAM A   
       

      //must be written under the background field   
      
        if(beginning == BEGINNING.GAME){
       for(int xx=0; xx<30*72; xx+=345 ){
        for(int yy=0; yy<30*300; yy+=280)
           {
              g.drawImage(background, xx, yy, this);
           }
      } 
               handler.render(g);
               

     //cuz it'll render all of our objects above our background    
      g2d.translate(camera.getX(), camera.getY()); //CAM B               
      

      g.setColor(Color.gray);
      g.fillRect(5, 5, 300, 32);
      if(GLEVEL==4)
          finish(g);      
      else if(heart<5 && heart>0)
      g.setColor(Color.red); 

      else if(heart<0){
          gameOver(g); 
          
      }
      else
      g.setColor(Color.green); 
      
      
      g.fillRect(5, 5, heart*30, 32);   
      g.setColor(Color.black);
      g.drawRect(5, 5, 300, 32); 
      
      g.setColor(Color.BLACK); 
      g.setFont(new Font("Ink Free",Font.BOLD,25));     
      g.drawString("HEART : "+heart, 10, 28);  
      g.setColor(Color.RED);
      g.drawString("SCORE : "+Target.score, 5, 58);       
      
       }else if(beginning == BEGINNING.MENU){
           try{

           menu.render(g);               
           }catch(Exception e){
             System.out.println("");               
           }

       } 
     
     /////////////////////////////////////
        g.dispose();
        bs.show();

    }
    
    
    //** loading the level **/////////////////////////////////
    public void loadLevel(BufferedImage image)
    {
        int w=image.getWidth();
        int h=image.getHeight();
        
        for(int xx=0; xx<w; xx++)
        {
            for(int yy=0; yy<h; yy++ )
            {
               int pixel=image.getRGB(xx, yy);
               int red = (pixel >> 16) & 0xff;
               int green = (pixel >> 8) & 0xff;
               int blue = (pixel) & 0xff;
               
            if(GLEVEL==1)
            {
                
               if(red==255 )
                   handler.addObject(new Block(xx*32, yy*32, ObjectId.Block,spriteSheet));
               if(blue==255 && green==0)
                   handler.addObject(new Chicken(xx*32, yy*15, ObjectId.Player, handler,this,camera,spriteSheet));
               if(red==255 && green==216)
                   handler.addObject(new LevelFlag(xx*32, yy*32,ObjectId.LevelFlag,spriteSheet));  
               if(blue==255 && green==255){
                  handler.addObject(new TargetBig(xx*(32+random.nextInt(20)), yy*(32+random.nextInt(30)), ObjectId.TargetBig,handler,spriteSheet)); 
                  handler.addObject(new TargetBig(xx*(32+random.nextInt(20)), yy*(32+random.nextInt(30)), ObjectId.TargetBig,handler,spriteSheet));                   
                  handler.addObject(new Target(xx*((32+random.nextInt(20)+10)), yy*(32+random.nextInt(30)), ObjectId.Target,handler,spriteSheet)); 
                  
               }
               
               if(green==255 && blue==0 ){
                  handler.addObject(new Cats(xx*32, yy*32, ObjectId.Cat,handler,spriteSheet)); 
                  handler.addObject(new Target(xx*((64+random.nextInt(20)+10)), yy*(32+random.nextInt(30)), ObjectId.Target,handler,spriteSheet)); 
                 
                  for(int n=0; n<=1; n++)
                  handler.addObject(new Cats(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.Cat,handler,spriteSheet)); 
               }                 
                
            }
  
               
            if(GLEVEL==2)
            {
                
               if(red==255 )
                   handler.addObject(new Block(xx*32, yy*32, ObjectId.Block,spriteSheet));
               if(blue==255 && green==0)
                   handler.addObject(new Chicken(xx*32, yy*15, ObjectId.Player, handler,this,camera,spriteSheet));
               if(red==255 && green==216)
                   handler.addObject(new LevelFlag(xx*32, yy*32,ObjectId.LevelFlag,spriteSheet));  
               if(blue==255 && green==255){
                  handler.addObject(new CatsBig(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.CatBig,handler,spriteSheet));                                      
                 handler.addObject(new TargetBig(xx*(32+random.nextInt(10)), yy*(32+random.nextInt(20)), ObjectId.TargetBig,handler,spriteSheet)); 
                 handler.addObject(new Target(xx*((32+random.nextInt(10)+10)), yy*(32+random.nextInt(20)), ObjectId.Target,handler,spriteSheet)); 
                  
               }
               
               if(green==255 && blue==0 ){
                  handler.addObject(new Cats(xx*32, yy*32, ObjectId.Cat,handler,spriteSheet));
                  handler.addObject(new CatsBig(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.CatBig,handler,spriteSheet));                   
                  for(int n=0; n<=1; n++)
                  handler.addObject(new Cats(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.Cat,handler,spriteSheet)); 
               }                 
                
            }            
            
            if(GLEVEL==3)
            {
                
               if(red==255 )
                   handler.addObject(new Block(xx*32, yy*32, ObjectId.Block,spriteSheet));
               if(blue==255 && green==0)
                   handler.addObject(new Chicken(xx*32, yy*15, ObjectId.Player, handler,this,camera,spriteSheet));
               if(red==255 && green==216)
                   handler.addObject(new LevelFlag(xx*32, yy*32,ObjectId.LevelFlag,spriteSheet));  
               if(blue==255 && green==255){
                 handler.addObject(new Cats(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.Cat,handler,spriteSheet)); 
                 handler.addObject(new TargetBig(xx*(32+random.nextInt(10)), yy*(32+random.nextInt(20)), ObjectId.TargetBig,handler,spriteSheet)); 
                 handler.addObject(new Target(xx*((32+random.nextInt(10)+10)), yy*(32+random.nextInt(20)), ObjectId.Target,handler,spriteSheet));                                     
                  
               }
               
               if(green==255 && blue==0 ){
                  handler.addObject(new CatsBig(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.CatBig,handler,spriteSheet));                    
                  handler.addObject(new Cats(xx*32, yy*32, ObjectId.Cat,handler,spriteSheet));
                  for(int n=0; n<=2; n++)
                  handler.addObject(new Cats(xx*(32+random.nextInt(150)), yy*(32+random.nextInt(20)), ObjectId.Cat,handler,spriteSheet)); 
               }                 
                
            }            
            

            }
               
    

            }
        
    }
    //////////////////////////////////////////////////////////////
    

    
    
}
