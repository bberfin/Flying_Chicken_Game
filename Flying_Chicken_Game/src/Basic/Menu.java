
package Basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Berfin
 */
public class Menu {
    
    public Rectangle ButtonStart =  new Rectangle(200,220,190,75);    
    public Rectangle ButtonQuit  =  new Rectangle(200,350,190,75);    

    public void render(Graphics g){
        
        Graphics2D g2 = (Graphics2D)g;
     
        Font font=new Font("arial",Font.BOLD,45);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("FLYING CHICKEN", 125, 150);
    
        
        Font font2=new Font("arial",Font.BOLD,20);   
        g.setFont(font2);
        g.setColor(Color.RED);
        g.drawString("START", ButtonStart.x+60, ButtonStart.y+45);         
        g2.draw(ButtonStart);
        g.setColor(Color.BLACK);       
        g.drawString("QUIT", ButtonQuit.x+65, ButtonQuit.y+45);          
        g2.draw(ButtonQuit);     

        Font font3=new Font("arial",Font.BOLD,25);
        g.setFont(font3);
        g.setColor(Color.BLACK);
        
        g.drawString("INFORMATION : ",50, 530); 
        
        Font font4=new Font("arial",Font.TYPE1_FONT,17);
        g.setFont(font4);
        g.setColor(Color.BLACK);             
        g.drawString("* Levels successively progress from the level 1. There are 3 levels."
                ,50, 560);  
        g.drawString("* The speed will increase with each level."
                ,50, 590);    
        g.drawString("* Watch out for big cats after the first level !"
                ,50, 620);         
        g.drawString("* big basket     :  + 30 points",50, 650);     
        g.drawString("* small basket  :  + 10 points",50, 680); 
        g.drawString("* cat                 :  - 1 heart",50, 710);     
        g.drawString("* big cat           :  - 3 hearts",50, 740);        
    }
    

    
   
}
