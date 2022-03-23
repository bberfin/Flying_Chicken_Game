/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Basic.Game;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Management.Handler;

/**
 *
 * @author Berfin
 */
public class MouseInputMenu extends MouseAdapter {


 //private Menu menux;
 Handler handler;   
/*
    
    public Rectangle ButtonStart =  new Rectangle(200,250,190,75);
    public Rectangle ButtonInfo  =  new Rectangle(200,350,190,75);    
    public Rectangle ButtonQuit  =  new Rectangle(200,450,190,75);    
    
    
*/    
    public MouseInputMenu(Handler handler){
        this.handler=handler;
    }
    
    public void mousePressed(MouseEvent e) {
        int mouse_x = (int) e.getX();
        int mouse_y = (int) e.getY();
        
        if(Game.beginning == Game.BEGINNING.MENU){
        //button start
        try{
        if((mouse_x >= 200 && mouse_x <= 390) &&(mouse_y >= 220 && mouse_y <= 295) ){                                    
            Game.beginning = Game.BEGINNING.GAME;

    
        } 
        
           }catch(Exception ee){
                    System.out.println("");            
        }

        
        //button quit
        if(mouse_x >= 200 && mouse_x <= 390){
            if(mouse_y >= 350 && mouse_y <= 425){
                try{
                System.exit(0);                    
                }catch(Exception ex){
                    System.out.println("bye");
                }

            }
        }            
        }
        
        
        else if (Game.counter==9){
            
            
        try{
        if((mouse_x >= 200 && mouse_x <= 450) &&(mouse_y >= 390 && mouse_y <= 460) ){                                    
         handler.switchLevel();
         
         
        } 
        
           }catch(Exception ee){
                    System.out.println("");            
        }

        
        //button quit
        if(mouse_x >= 200 && mouse_x <= 450){
            if(mouse_y >= 490 && mouse_y <= 560){
                try{
                System.exit(0);                    
                }catch(Exception ex){
                    System.out.println("bye");
                }

            }
        }         
        

        
        }      
        
        
        
          
        
    }
    

    
}
