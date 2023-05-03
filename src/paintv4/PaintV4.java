/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package paintv4;

import Shapes.DrawerV4;
import javax.swing.JFrame;

/**
 *
 * @author Omar Shedid
 */
public class PaintV4 {

    public static void main(String[] args) {
        JFrame frm= new JFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawerV4 dr = new DrawerV4();
        frm.setTitle("Shapes Drawer");
        frm.setSize(800,500);
        frm.setContentPane(dr);
        frm.setVisible(true);  
    }
}
