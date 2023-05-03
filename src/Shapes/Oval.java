/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Omar Shedid
 */
public class Oval extends JPanel{
      protected int x;
        protected int y;
        protected int width;
        protected int height;
        protected Color Chosen1;
        protected int dotted;
        protected int filled;
        
        public Oval(int x , int y , int width , int height ,Color Chosen1,int dotted) {
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
            this.Chosen1=Chosen1;
            this.dotted=dotted;
           
        }
    
    
}
