/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package paintv3;

import Shapes.DrawerV3;
import javax.swing.JFrame;

/**
 *
 * @author Omar Shedid
 */
public class PaintV3 {

    public static void main(String[] args) {
        JFrame frm= new JFrame();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawerV3 dr = new DrawerV3();
        frm.setTitle("Shapes Drawer");
        frm.setSize(800,500);
        frm.setContentPane(dr);
        frm.setVisible(true);  
    }
}
