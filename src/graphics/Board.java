package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Board extends JPanel{
    
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    
    private static final int CROSS_START = 10;
    private static final int CROSS_END = 115;
    private int offset_x;
    private int offset_y;

    
    public Board(){
        // setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
        setBounds(180, 80, WIDTH, HEIGHT);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(Color.BLACK);

        //Draw vertical line
        g2d.drawLine(133,0, 133, 400);
        g2d.drawLine(266,0, 266, 400);

        //Draw horizontal line
        g2d.drawLine(0, 133, 400, 133);
        g2d.drawLine(0, 266, 400, 266);

        //Draws a Cross
        // g2d.drawLine(CROSS_START, CROSS_START,CROSS_END,CROSS_END);
        // g2d.drawLine(CROSS_END,CROSS_START,CROSS_START,CROSS_END);


        // g2d.drawLine(CROSS_START + 137, CROSS_START,CROSS_END + 137,CROSS_END);
        // g2d.drawLine(CROSS_END + 137,CROSS_START,CROSS_START + 137,CROSS_END);

        //Draws a Circle
        g2d.drawArc(10+275,10,100,100,0,360);

    };





}
