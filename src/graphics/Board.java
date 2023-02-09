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

    };





}
