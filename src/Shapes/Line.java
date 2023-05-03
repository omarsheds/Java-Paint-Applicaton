
package Shapes;

import java.awt.Color;
import javax.swing.JPanel;


public class Line extends JPanel {
    
      protected int x1;
        protected int y1;
        protected int x2;
        protected int y2;
        protected Color Chosen1;
        protected int dotted;
        
        public Line (int x1 , int y1 , int x2 , int y2 ,Color Chosen1,int dotted) {
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
            this.Chosen1=Chosen1;
            this.dotted=dotted;
        }
    
}
