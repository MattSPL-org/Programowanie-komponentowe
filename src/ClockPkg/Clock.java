/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClockPkg;

import SevensegPkg.Sevenseg;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author mateusz
 */
public class Clock extends JPanel{
    
    Sevenseg alfa = new Sevenseg();
    LocalTime now;
     int hour0;
     int hour1;
     int min0;
     int min1;
     int sec0;
     int sec1;
     
     JLabel dig1;
     JLabel dig2;
     JLabel dig3;
     JLabel dig4;
     JLabel dig5;
     JLabel dig6;
     JLabel dots;
     JLabel dots2;
     
    JPanel panel = this;
    ImageIcon[] dotsAr = new ImageIcon[2];
    ImageIcon[] dotsAr2 = new ImageIcon[2];
    
    private int digitWidth=94;
    private int digitHeight=144;
    private int dotWidth=32;
    
    boolean colorChanged= true;
    boolean resized = false;
    
    private Image image;
    
   
    public Clock(){
    
        
    }
    
    public void create()
    {
        if(alfa.getPrimaryColor()==null)
            {
               alfa.setPrimaryColor(Color.green);
            }
            
            if(alfa.getSecondaryColor()==null)
            {
                alfa.setSecondaryColor(Color.green.darker().darker().darker());
            }
            
                    for(int i=-1;i<=9;i++)
                    {
            try {
                alfa.createDigit(i); 
                
            } catch (IOException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
                    
			dig1 = new JLabel();
                        dig2 = new JLabel();
                        dig3 = new JLabel();
                        dig4 = new JLabel();
                        dig5 = new JLabel();
                        dig6 = new JLabel();
                        dots = new JLabel();
                        dots2 = new JLabel();
			
                        FlowLayout layout = new FlowLayout();
                        
                        panel.setLayout(layout);
                        panel.setBackground(Color.DARK_GRAY.darker());
                        panel.add(dig6);
                        panel.add(dig5);
                        panel.add(dots2);
                        panel.add(dig4);
                        panel.add(dig3);
                        panel.add(dots);
                        panel.add(dig2);
                        panel.add(dig1);
                       
    }
    
    public void run()
    { 
        ArrayList numbers = new ArrayList(10);
        
        int sec1s=0;
       
        while(true)
			{ 
                            if(colorChanged || resized)
                            {
                                try {
                                    numbers.clear();
                                    
                                    dotsAr[0]= new ImageIcon(ImageIO.read(new File("digits"+File.separator+"dots2.png")));
                                    image = dotsAr[0].getImage().getScaledInstance(dotWidth, digitHeight, Image.SCALE_SMOOTH);
                                    dotsAr[0]=new ImageIcon(image);
                                    dotsAr[1]= new ImageIcon(ImageIO.read(new File("digits"+File.separator+"dots1.png")));
                                    image = dotsAr[1].getImage().getScaledInstance(dotWidth, digitHeight, Image.SCALE_SMOOTH);
                                    dotsAr[1]=new ImageIcon(image);
                                    for(int i=0;i<=9;i++)
                                    {
                                        image = new ImageIcon(ImageIO.read(new File("digits"+File.separator+i+".png"))).getImage().getScaledInstance(digitWidth, digitHeight, Image.SCALE_SMOOTH);
                                         numbers.add(i, new ImageIcon(image));
                                        
                                        }
                                      } catch (IOException ex) {
                                    Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        colorChanged=false;
                        resized=false;
                            now = LocalTime.now();
                        sec0 = now.getSecond()/10;
                        sec1 = now.getSecond()%10;
                        hour0 = now.getHour()/10;
                        hour1 = now.getHour()%10;
                        min0 = now.getMinute()/10;
                        min1 = now.getMinute()%10;
                        
			dig1.setIcon((Icon) numbers.get(sec1));
                        dig2.setIcon((Icon) numbers.get(sec0));
                        dig3.setIcon((Icon) numbers.get(min1));
                        dig4.setIcon((Icon) numbers.get(min0));
                        dig5.setIcon((Icon) numbers.get(hour1));
                        dig6.setIcon((Icon) numbers.get(hour0));
                        dots.setIcon(dotsAr[sec1%2]);
                        dots2.setIcon(dotsAr[sec1%2]);
                        panel.repaint();
                    
			}
                        
			
		
    } 
    public void setPrimaryColor(Color paint)
    {
        alfa.setPrimaryColor(paint);
    }
    
    public void setSecondaryColor(Color paint)
    {
        alfa.setSecondaryColor(paint);
    }
    
    public Color getPrimaryColor()
    {
       return alfa.getPrimaryColor();
    };
    
    public Color getSecondaryColor()
    {
       return alfa.getSecondaryColor();
    };
    
    
    public void colorRefresh()
    {
     for(int i=-1;i<=9;i++)
                    {
            try {
                alfa.createDigit(i);
            } catch (IOException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
                    }
       colorChanged=true;
    }
  
    public void setClockSize(int newDigitWidth, int newDotWidth, int newHeight)
    {
        this.resized=true;
        this.dotWidth=newDotWidth;
        this.digitWidth=newDigitWidth;
        this.digitHeight = newHeight;
    }

}
