/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Shapes;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Color.*;
import static java.awt.Color.BLACK;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class DrawerV4 extends JPanel {

    //Line Variables
    int x1, y1, x2, y2;

    //Rectangle Variables
    int x3, y3, x4, y4;
    int widthRect;
    int heightRect;

    //OVAL Variables
    int x5, y5, x6, y6;
    int widthOval;
    int heightOval;

    int flag;

    Color Chosen;

    JCheckBox filled;
    JCheckBox dotted;

    Vector<Line> lineVector = new Vector<Line>();
    
    Vector<Rectangle> rectVector = new Vector<Rectangle>();
    Vector<Rectangle> filledRectVector = new Vector<Rectangle>();

    Vector<Oval> ovalVector = new Vector<Oval>();
    Vector<Oval> filledOvalVector = new Vector<Oval>();

    Vector<Oval> ovalfreehandVector = new Vector<Oval>();
    Vector<Oval> eraserVector = new Vector<Oval>();
    
    Vector<Integer> order = new Vector<Integer>();

    //iterators
    int j, k, l, m, n, o, p = 0;

    public DrawerV4() {

        this.setBackground(WHITE);

        this.setFocusable(true);
        Chosen = BLACK;

        flag = 1;

        //--------------------(LEFT SIDE)COLOR BUTTONS-------------------------------
        JButton red = new JButton("RED");
        red.setBounds(25, 50, 120, 30);
        this.add(red);
        
        JButton green = new JButton("GREEN");
        green.setBounds(25, 100, 120, 30);
        this.add(green);
        
        JButton blue = new JButton("BLUE");
        blue.setBounds(25, 150, 120, 30);
        this.add(blue);

        JButton clear = new JButton("CLEAR");
        clear.setBounds(25, 200, 120, 30);
        this.add(clear);

        filled = new JCheckBox("FILLED");
        filled.setBounds(25, 250, 120, 30);
        this.add(filled);

        dotted = new JCheckBox("DOTTED");
        dotted.setBounds(25, 300, 120, 30);
        this.add(dotted);

        JButton undo = new JButton("UNDO");
        undo.setBounds(25, 350, 120, 30);
        this.add(undo);

        //--------------------(RIGHT SIDE)SHAPE BUTTONS-------------------------------
        JButton rectangle = new JButton("RECTANGLE");
        rectangle.setBounds(600, 50, 120, 30);
        this.add(rectangle);
        JButton oval = new JButton("OVAL");
        oval.setBounds(600, 100, 120, 30);
        this.add(oval);
        JButton line = new JButton("LINE");
        line.setBounds(600, 150, 120, 30);
        this.add(line);
        JButton FH = new JButton("FREE HAND");
        FH.setBounds(600, 200, 120, 30);
        this.add(FH);
        JButton eraser = new JButton("ERASER");
        eraser.setBounds(600, 250, 120, 30);
        this.add(eraser);

        JButton save = new JButton("SAVE");
        save.setBounds(600, 350, 120, 30);
        this.add(save);

        this.setLayout(null);

        //----------------------------------------------------------------------  
        //--------------------COLOR BUTTON ACTIONS-------------------------------
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                lineVector.clear();
                rectVector.clear();
                ovalVector.clear();
                ovalfreehandVector.clear();
                eraserVector.clear();
                filledRectVector.clear();
                filledOvalVector.clear();
                order.clear();
                x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                widthRect = heightRect = widthOval = heightOval = 0;
                repaint();

            }

        });

        undo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                switch (order.get((order.size()) - 1)) {
                    case 1:
                        lineVector.remove((lineVector.size()) - 1);
                        order.remove((order.size()) - 1);
                        x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                        widthRect = heightRect = widthOval = heightOval = 0;
                        repaint();
                        break;
                    case 2:
                        filledOvalVector.remove((filledOvalVector.size()) - 1);
                        order.remove((order.size()) - 1);
                        x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                        widthRect = heightRect = widthOval = heightOval = 0;
                        repaint();
                        break;
                    case 3:
                        ovalVector.remove((ovalVector.size()) - 1);
                        order.remove((order.size()) - 1);
                        x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                        widthRect = heightRect = widthOval = heightOval = 0;
                        repaint();
                        break;

                    case 4:
                        filledRectVector.remove((filledRectVector.size()) - 1);
                        order.remove((order.size()) - 1);
                        x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                        widthRect = heightRect = widthOval = heightOval = 0;
                        repaint();
                        break;
                    case 5:
                        rectVector.remove((rectVector.size()) - 1);
                        order.remove((order.size()) - 1);
                        x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                        widthRect = heightRect = widthOval = heightOval = 0;
                        repaint();
                        break;

                    case 6:
                        while (order.get((order.size()) - 1) == 6) {
                            ovalfreehandVector.remove((ovalfreehandVector.size()) - 1);
                            order.remove((order.size()) - 1);
                            x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                            widthRect = heightRect = widthOval = heightOval = 0;
                            repaint();
                        }
                        break;

                    case 7:
                        while (order.get((order.size()) - 1) == 7) {
                            eraserVector.remove((eraserVector.size()) - 1);
                            order.remove((order.size()) - 1);
                            x1 = x2 = x3 = x4 = x5 = x6 = y1 = y2 = y3 = y4 = y5 = y6 = 0;
                            widthRect = heightRect = widthOval = heightOval = 0;
                            repaint();
                        }
                        break;

                }

            }

        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveImage();

            }

        }
        );

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chosen = RED;

            }

        }
        );

        green.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chosen = GREEN;

            }

        });

        blue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chosen = BLUE;

            }

        });

        //--------------------SHAPES BUTTON ACTIONS-------------------------------
        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 3;

            }

        }
        );

        oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 2;

            }

        }
        );

        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 1;

            }

        }
        );

        FH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 4;

            }

        }
        );

        eraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = 5;
            }

        }
        );

        // ----------------SHAPES MOUSE LISTENER-----------------------------------------------------    
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //Start Point Coordinates

                switch (flag) {
                    case 1:
                        x1 = e.getX();
                        y1 = e.getY();

                        break;

                    case 2:

                        x5 = e.getX();
                        y5 = e.getY();

                        break;

                    case 3:

                        x3 = e.getX();
                        y3 = e.getY();
                        break;

                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //End Point Coordinates

                switch (flag) {
                    case 1:

                        x2 = e.getX();
                        y2 = e.getY();

                        if (dotted.isSelected()) {

                            lineVector.add(new Line(x1, y1, x2, y2, Chosen, 1));
                            order.add(1);
                        } else {
                            lineVector.add(new Line(x1, y1, x2, y2, Chosen, 0));
                            order.add(1);
                        }
                        System.out.println("Line Vector is implemented");

                        break;

                    case 2:
                        if (filled.isSelected()) {
                            x6 = e.getX();
                            y6 = e.getY();
                            widthOval = Math.abs(x6 - x5);
                            heightOval = Math.abs(y6 - y5);

                            filledOvalVector.add(new Oval(x5, y5, widthOval, heightOval, Chosen, 0));
                            order.add(2);

                        } else {
                            x6 = e.getX();
                            y6 = e.getY();
                            widthOval = Math.abs(x6 - x5);
                            heightOval = Math.abs(y6 - y5);
                            if (dotted.isSelected()) {
                                ovalVector.add(new Oval(x5, y5, widthOval, heightOval, Chosen, 1));
                                order.add(3);

                            } else {
                                ovalVector.add(new Oval(x5, y5, widthOval, heightOval, Chosen, 0));
                                order.add(3);
                            }
                        }

                        System.out.println("Oval Vector is implemented");

                        break;

                    case 3:
                        if (filled.isSelected()) {

                            x4 = e.getX();
                            y4 = e.getY();
                            widthRect = Math.abs(x4 - x3);
                            heightRect = Math.abs(y4 - y3);

                            filledRectVector.add(new Rectangle(x3, y3, widthRect, heightRect, Chosen, 0));
                            order.add(4);

                        } else {
                            x4 = e.getX();
                            y4 = e.getY();
                            widthRect = Math.abs(x4 - x3);
                            heightRect = Math.abs(y4 - y3);
                            if (dotted.isSelected()) {
                                rectVector.add(new Rectangle(x3, y3, widthRect, heightRect, Chosen, 1));
                                order.add(5);
                                System.out.println("Rect Vector is implemented");
                            } else {
                                rectVector.add(new Rectangle(x3, y3, widthRect, heightRect, Chosen, 0));
                                order.add(5);
                            }
                        }

                        break;
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                switch (flag) {
                    case 1:

                        x2 = e.getX();
                        y2 = e.getY();

                        System.out.println("Line is Dragged");
                        repaint();

                        break;

                    case 2:

                        x6 = e.getX();
                        y6 = e.getY();
                        widthOval = x6 - x5;
                        heightOval = y6 - y5;
                        System.out.println("Oval is being dragged");
                        repaint();

                        break;

                    case 3:
                        x4 = e.getX();
                        y4 = e.getY();
                        widthRect = x4 - x3;
                        heightRect = y4 - y3;
                        System.out.println("Rect is Dragged");
                        repaint();

                        break;

                    case 4:

                        Graphics g = getGraphics();

                        g.setColor(Chosen);

                        g.fillOval(e.getX(), e.getY(), 10, 10);
                        ovalfreehandVector.add(new Oval(e.getX(), e.getY(), 10, 10, Chosen, 1));
                        order.add(6);
                        break;
                    case 5:

                        Graphics g2 = getGraphics();
                        g2.setColor(WHITE);
                        g2.fillOval(e.getX(), e.getY(), 10, 10);
                        eraserVector.add(new Oval(e.getX(), e.getY(), 10, 10, WHITE, 1));
                        order.add(7);
                        break;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });

    }

    //------------function that saves file as JPEG in Project's route-----------
    void saveImage() {
        BufferedImage imagebuf = null;
        try {
            imagebuf = new Robot().createScreenCapture(this.bounds());
        } catch (AWTException e1) {

            e1.printStackTrace();
        }
        Graphics2D graphics2D = imagebuf.createGraphics();
        this.paint(graphics2D);
        try {
            ImageIO.write(imagebuf, "jpeg", new File("Paint.jpeg"));
        } catch (Exception e) {

            System.out.println("error");
        }
    }

//-------------------PAINT COMPNENT METHOD----------------
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //To see Effect when we draw
        
        
        //to set drawing stroke to dotted
        Graphics2D g2d = (Graphics2D) g;
        float[] dash1 = {2f, 0f, 2f};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        
        
        

        //To display old shapes in the same order without overlapping
        for (int i = 0; i < order.size(); i++) {

            switch (order.get(i)) {

                case 1:
                    g.setColor(lineVector.get(j).Chosen1);

                    if (lineVector.get(j).dotted == 1) {

                        g2d.setStroke(bs1);
                        g2d.drawLine(lineVector.get(j).x1, lineVector.get(j).y1, lineVector.get(j).x2, lineVector.get(j).y2);
                        g2d.setStroke(new BasicStroke(1.0f));
                    } else {
                        g.drawLine(lineVector.get(j).x1, lineVector.get(j).y1, lineVector.get(j).x2, lineVector.get(j).y2);
                    }

                    j++;
                    break;

                case 2:

                    g.setColor(filledOvalVector.get(k).Chosen1);
                    g.fillOval(filledOvalVector.get(k).x, filledOvalVector.get(k).y, filledOvalVector.get(k).width, filledOvalVector.get(k).height);

                    k++;
                    break;

                case 3:

                    g.setColor(ovalVector.get(l).Chosen1);

                    if (ovalVector.get(l).dotted == 1) {

                        g2d.setStroke(bs1);
                        g2d.drawOval(ovalVector.get(l).x, ovalVector.get(l).y, ovalVector.get(l).width, ovalVector.get(l).height);
                        g2d.setStroke(new BasicStroke(1.0f));
                    } else {
                        g.drawOval(ovalVector.get(l).x, ovalVector.get(l).y, ovalVector.get(l).width, ovalVector.get(l).height);
                    }

                    l++;
                    break;

                case 4:
                    g.setColor(filledRectVector.get(m).Chosen1);

                    g.fillRect(filledRectVector.get(m).x, filledRectVector.get(m).y, filledRectVector.get(m).width, filledRectVector.get(m).height);

                    m++;
                    break;

                case 5:
                    g.setColor(rectVector.get(n).Chosen1);
                    if (rectVector.get(n).dotted == 1) {

                        g2d.setStroke(bs1);
                        g2d.drawRect(rectVector.get(n).x, rectVector.get(n).y, rectVector.get(n).width, rectVector.get(n).height);
                        g2d.setStroke(new BasicStroke(1.0f));
                    } else {
                        g.drawRect(rectVector.get(n).x, rectVector.get(n).y, rectVector.get(n).width, rectVector.get(n).height);
                    }

                    n++;
                    break;
                case 6:

                    g.setColor(ovalfreehandVector.get(o).Chosen1);

                    g.fillOval(ovalfreehandVector.get(o).x, ovalfreehandVector.get(o).y, ovalfreehandVector.get(o).width, ovalfreehandVector.get(o).height);

                    o++;
                    break;

                case 7:

                    g.setColor(eraserVector.get(p).Chosen1);

                    g.fillOval(eraserVector.get(p).x, eraserVector.get(p).y, eraserVector.get(p).width, eraserVector.get(p).height);
                    p++;
                    break;

            }

        }

        j = k = l = m = n = o = p = 0;

        
        //to draw live drag action of current shape
        g.setColor(Chosen);
        if (filled.isSelected()) {
            switch (flag) {
                //  

                case 1:
                    if (dotted.isSelected()) {
                        g2d.setStroke(bs1);
                        g2d.drawLine(x1, y1, x2, y2);
                        g2d.setStroke(new BasicStroke(1.0f));
                    } else {
                        g.drawLine(x1, y1, x2, y2);
                    }
                    break;

                case 2:
                    g.fillOval(x5, y5, widthOval, heightOval);
                    break;

                case 3:
                    g.fillRect(x3, y3, widthRect, heightRect);
                    break;
            }

        } else {

            if (dotted.isSelected()) {
                g2d.setStroke(bs1);

                switch (flag) {

                    case 1:
                        g2d.drawLine(x1, y1, x2, y2);
                        g2d.setStroke(new BasicStroke(1.0f));
                        break;

                    case 2:
                        g2d.drawOval(x5, y5, widthOval, heightOval);
                        g2d.setStroke(new BasicStroke(1.0f));
                        break;

                    case 3:
                        g2d.drawRect(x3, y3, widthRect, heightRect);
                        g2d.setStroke(new BasicStroke(1.0f));
                        break;
                }

            } else {
                switch (flag) {
                    //  

                    case 1:
                        g.drawLine(x1, y1, x2, y2);
                        break;

                    case 2:
                        g.drawOval(x5, y5, widthOval, heightOval);
                        break;

                    case 3:
                        g.drawRect(x3, y3, widthRect, heightRect);
                        break;
                }
            }

        }
    }

}
